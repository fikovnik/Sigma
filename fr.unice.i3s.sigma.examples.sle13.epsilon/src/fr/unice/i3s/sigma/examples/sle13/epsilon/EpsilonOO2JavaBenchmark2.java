package fr.unice.i3s.sigma.examples.sle13.epsilon;

import java.io.File;
import java.net.URI;

import oo.OOPackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;

import fr.unice.i3s.sigma.examples.sle13.benchmark.M2TMicroBenchmark;

public class EpsilonOO2JavaBenchmark2 implements M2TMicroBenchmark {

	private static final String TEMPLATE_ROOT = "src/fr/unice/i3s/sigma/examples/sle13/epsilon/";
	private static final String SOURCE = "src/fr/unice/i3s/sigma/examples/sle13/epsilon/OO2Java.egl";

	private EglTemplate template;
	private EglFileGeneratingTemplateFactory factory;

	@Override
	public void pre(Resource resource) throws Exception {
		String ePackageUri = OOPackage.eINSTANCE.getNsURI();
		URI source = new File(SOURCE).toURI();
		
		factory = new EglFileGeneratingTemplateFactory();
		factory.setTemplateRoot(new File(TEMPLATE_ROOT).toURI().toString());

		template = factory.load(source);
		InMemoryEmfModel model = new InMemoryEmfModel("model", resource,
				ePackageUri);
		
		factory.getContext().getModelRepository().addModel(model);
	}

	@Override
	public void run(Resource resource, File targetDir) throws Exception {
		template.populate("targetDir", targetDir.getAbsolutePath());
		template.process();
	}

	@Override
	public void post(Resource resource) throws Exception {
		factory.getContext().getModelRepository().dispose();
	}

}
