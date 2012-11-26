package fr.unice.i3s.sigma.delegates.codegen;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Iterables.transform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.delegates.AbstractSigmaDelegate;
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain;
import fr.unice.i3s.sigma.delegates.SigmaEObjectValidator;
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegate;
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegateFactory;
import fr.unice.i3s.sigma.delegates.SigmaSettingDelegate;
import fr.unice.i3s.sigma.delegates.SigmaSettingDelegateFactory;
import fr.unice.i3s.sigma.delegates.SigmaValidationDelegate;
import fr.unice.i3s.sigma.delegates.SigmaValidationDelegateFactory;
import fr.unice.i3s.sigma.delegates.StaticValidationDelegate;

public class SigmaGenModelGeneratorAdapter extends GenBaseGeneratorAdapter {

	private final SigmaDelegateDomain domain;

	public SigmaGenModelGeneratorAdapter(SigmaDelegateDomain domain,
			SigmaGeneratorAdapterFactory factory) {
		super(factory);
		this.domain = domain;
	}

	@Override
	protected Diagnostic doPreGenerate(Object object, Object projectType) {
		assert object != null;
		GenModel genModel = (GenModel) object;
		try {
			if ((projectType == MODEL_PROJECT_TYPE) && !hasDelegates(genModel)) {
				GenPackage genPackage = genModel.getGenPackages().get(0);
				createImportManager(genPackage.getReflectionPackageName(),
						genPackage.getFactoryInterfaceName() + "Tables"); // Only
																			// used
																			// to
																			// suppress
																			// NPE
				processModel(genModel);
			}
		} catch (Exception e) {
			BasicDiagnostic thisDiagnostic = new BasicDiagnostic(
					Diagnostic.ERROR, getClass().getPackage().getName(), 0,
					"Failed to pre-generate " + genModel.getModelPluginID()
							+ " constraints", new Object[] { e });
			Diagnostic thatDiagnostic = super
					.doPreGenerate(object, projectType);
			if (thatDiagnostic.getSeverity() == Diagnostic.OK) {
				return thisDiagnostic;
			} else {
				thatDiagnostic.getChildren().add(thisDiagnostic);
				return thatDiagnostic;
			}
		}

		return super.doPreGenerate(object, projectType);
	}

	private void processModel(GenModel genModel) {
		SigmaInvocationDelegateFactory invocationFactory = createInvocationDelegateFactory();
		SigmaSettingDelegateFactory settingFactory = createSettingDelegateFactory();
		SigmaValidationDelegateFactory validationFactory = createValidationDelegateFactory();

		for (GenPackage genPkg : genModel.getGenPackages()) {
			for (GenClass genClazz : genPkg.getGenClasses()) {
				EClass clazz = genClazz.getEcoreClass();
				boolean clazzHasChange = false;

				if (clazz == null) {
					// TODO: debug log
					continue;
				}

				// operations
				for (GenOperation genOperation : genClazz.getGenOperations()) {
					EOperation operation = genOperation.getEcoreOperation();

					SigmaInvocationDelegate delegate = invocationFactory
							.createInvocationDelegate(operation);

					if (delegate == null) {
						// TODO log info
						continue;
					}

					String body = generateOperationInvocationMethodCall(
							genClazz, delegate);
					body = wrap(body, delegate);
					installOperationBody(operation, body);
				}

				// setters
				for (GenFeature genFeature : genClazz.getGenFeatures()) {
					EStructuralFeature feature = genFeature.getEcoreFeature();

					SigmaSettingDelegate delegate = settingFactory
							.createSettingDelegate(feature);

					if (delegate == null) {
						// TODO log info
						continue;
					}

					String body = generateFeatureInvocationMethodCall(genClazz,
							delegate);
					body = wrap(body, delegate);
					installFeatureBody(feature, body);
				}

				// constraints
				for (final String constraint : getEClassConstraints(clazz)) {
					SigmaValidationDelegate delegate = validationFactory
							.createValidationDelegate(clazz, constraint);

					if (delegate == null) {
						// TODO log info
						continue;
					}

					EOperation constraintOperation = find(
							clazz.getEOperations(),
							new Predicate<EOperation>() {
								@Override
								public boolean apply(EOperation input) {
									return constraint.equals(input.getName());
								}
							}, null);
					if (constraintOperation == null) {
						constraintOperation = createConstraintEOperation(constraint);
						clazz.getEOperations().add(constraintOperation);
						clazzHasChange = true;
					}

					String body = generateValidationInvocationMethodCall(
							genClazz, delegate);
					body = wrap(body, delegate);
					installOperationBody(constraintOperation, body);
				}

				if (clazzHasChange) {
					genClazz.initialize(clazz);
				}
			}
		}
	}

	protected String wrap(String body, AbstractSigmaDelegate<?> delegate) {
		// FIXME: good idea, but the exists() method must be like 100times
		// smarter. It has to look for the current IProject...
		// if (!delegate.exists()) {
		// StringBuilder sb = new StringBuilder();
		//
		// sb.append("// The target delegate does not seem to be ready yet.\n");
		// sb.append("// Once it is, uncomment following lines.\n\n");
		// sb.append("// TODO: implement delegate and uncomment\n\n");
		// sb.append("//" + body.replace("\n", "\n//"));
		// sb.append("\n\n");
		// sb.append("throw new UnsupportedOperationException();");
		//
		// return sb.toString();
		// }
		return body;
	}

	protected static Iterable<String> getEClassConstraints(EClass clazz) {
		List<String> constrants = new ArrayList<String>();

		EAnnotation ecoreAnnotation = clazz
				.getEAnnotation(EcorePackage.eNS_URI);
		if (ecoreAnnotation != null) {
			String constraintStr = ecoreAnnotation.getDetails().get(
					"constraints");
			if (constraintStr != null) {
				constrants.addAll(Arrays.asList(constraintStr.split(" ")));
			}
		}

		return constrants;
	}

	private EOperation createConstraintEOperation(String constraint) {
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName(constraint);
		eOperation.setEType(EcorePackage.Literals.EBOOLEAN);

		EParameter firstParameter = EcoreFactory.eINSTANCE.createEParameter();
		firstParameter.setName("diagnostics");
		firstParameter.setEType(EcorePackage.Literals.EDIAGNOSTIC_CHAIN);
		eOperation.getEParameters().add(firstParameter);

		EParameter secondParameter = EcoreFactory.eINSTANCE.createEParameter();
		secondParameter.setName("context");

		EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericType.setEClassifier(EcorePackage.Literals.EMAP);

		EGenericType firstTypeArgument = EcoreFactory.eINSTANCE
				.createEGenericType();
		firstTypeArgument.setEClassifier(EcorePackage.Literals.EJAVA_OBJECT);
		eGenericType.getETypeArguments().add(firstTypeArgument);

		EGenericType secondTypeArgument = EcoreFactory.eINSTANCE
				.createEGenericType();
		secondTypeArgument.setEClassifier(EcorePackage.Literals.EJAVA_OBJECT);
		eGenericType.getETypeArguments().add(secondTypeArgument);
		secondParameter.setEGenericType(eGenericType);
		eOperation.getEParameters().add(secondParameter);

		return eOperation;
	}

	private void installOperationBody(EOperation element, String body) {
		EcoreUtil.setAnnotation(element, GenModelPackage.eNS_URI, "body", body);
	}

	private void installFeatureBody(EStructuralFeature element, String body) {
		EcoreUtil.setAnnotation(element, GenModelPackage.eNS_URI, "get", body);
	}

	// TODO: auto-import delegate classes
	protected String generateOperationInvocationMethodCall(GenClass genClazz,
			SigmaInvocationDelegate delegate) {
		// GenModel model = genClazz.getGenModel();

		StringBuilder sb = new StringBuilder();

		if (delegate.getTarget().getEType() != null) {
			sb.append("return ");
		}

		sb.append(delegate.getMethodClassName());
		sb.append(".");
		sb.append(delegate.getMethodName());
		sb.append("(this");

		EList<EParameter> parameters = delegate.getTarget().getEParameters();
		if (!parameters.isEmpty()) {
			sb.append(", ");
			Joiner.on(", ").appendTo(sb,
					transform(parameters, new Function<EParameter, String>() {
						@Override
						public String apply(EParameter input) {
							return input.getName();
						}
					}));
		}

		sb.append(");");

		return sb.toString();
	}

	// TODO: auto-import delegate classes
	protected String generateFeatureInvocationMethodCall(GenClass genClazz,
			SigmaSettingDelegate delegate) {
		// GenModel model = genClazz.getGenModel();

		StringBuilder sb = new StringBuilder();

		sb.append("return ");
		sb.append(delegate.getMethodClassName());
		sb.append(".");
		sb.append(delegate.getMethodName());
		sb.append("(this);");

		return sb.toString();
	}

	// TODO: auto-import delegate classes
	private String generateValidationInvocationMethodCall(GenClass genClazz,
			SigmaValidationDelegate delegate) {
		// GenModel model = genClazz.getGenModel();
		GenPackage genPkg = genClazz.getGenPackage();

		StringBuilder sb = new StringBuilder();

		// @formatter:off
		sb.append("return "+SigmaEObjectValidator.class.getName()+".validate(\n");
		sb.append("    this,\n");
		sb.append("    diagnostics,\n");
		sb.append("    context,\n");
		sb.append("    new "+StaticValidationDelegate.class.getName()+"<"+delegate.getTarget().getName()+">(\n");
		sb.append("        "+domain.getClass().getName()+".getDefaultInstance(),\n");
		sb.append("        eClass(),\n");
		sb.append("        \""+delegate.getConstraint()+"\") {\n");
		sb.append("            @Override\n");
		sb.append("            public Object doValidate("+delegate.getTarget().getName()+" object) {\n");
		sb.append("                return "+delegate.getMethodClassName()+"."+delegate.getMethodName()+"(object);\n");
		sb.append("            }\n");
		sb.append("    },\n");
		sb.append("    "+genPkg.getUtilitiesPackageName()+"."+genPkg.getValidatorClassName()+".DIAGNOSTIC_SOURCE,\n");
		sb.append("    0);");
		// @formatter:on

		return sb.toString();
	}

	protected SigmaInvocationDelegateFactory createInvocationDelegateFactory() {
		return new SigmaInvocationDelegateFactory();
	}

	protected SigmaSettingDelegateFactory createSettingDelegateFactory() {
		return new SigmaSettingDelegateFactory();
	}

	protected SigmaValidationDelegateFactory createValidationDelegateFactory() {
		return new SigmaValidationDelegateFactory();
	}

	/**
	 * Return true if any local GenPackage is for an EPackage that has OCL
	 * validation/setting/invocation delegates.
	 */
	protected boolean hasDelegates(GenModel genModel) {
		for (GenPackage genPackage : genModel.getGenPackages()) {
			EPackage ePackage = genPackage.getEcorePackage();
			if ((ePackage != null) && hasDelegates(ePackage)) {
				return true;
			}
		}
		return false;
	}

	protected boolean hasDelegates(EPackage ePackage) {
		List<String> validationDelegates = EcoreUtil
				.getValidationDelegates(ePackage);
		for (String validationDelegate : validationDelegates) {
			if (isValidationDelegateURI(validationDelegate)) {
				return true;
			}
		}
		List<String> settingDelegates = EcoreUtil.getSettingDelegates(ePackage);
		for (String settingDelegate : settingDelegates) {
			if (isValidationDelegateURI(settingDelegate)) {
				return true;
			}
		}
		List<String> invocationDelegates = EcoreUtil
				.getInvocationDelegates(ePackage);
		for (String invocationDelegate : invocationDelegates) {
			if (isValidationDelegateURI(invocationDelegate)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isValidationDelegateURI(String validationDelegate) {
		return isSigmaDelegateURI(validationDelegate);
	}

	protected boolean isSettingDelegateURI(String settingDelegate) {
		return isSigmaDelegateURI(settingDelegate);
	}

	protected boolean isInvocationDelegateURI(String invocationDelegates) {
		return isSigmaDelegateURI(invocationDelegates);
	}

	protected boolean isSigmaDelegateURI(String delegate) {
		return domain.getURI().equals(delegate);
	}
}
