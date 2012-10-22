package testmodel.delegates;

import static com.google.common.base.Strings.isNullOrEmpty;
import testmodel.TestClass;
import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.core.annotations.Satisfies;
import fr.unice.i3s.sigma.delegates.SigmaQuickFix;
import fr.unice.i3s.sigma.delegates.SigmaQuickFix.IFix;

/**
 * 
 * Dependencies:
 * 
 * <pre>
 * A -> 
 * B -> E, F 
 * C ->
 * D -> B
 * E -> C
 * F ->
 * </pre>
 * 
 * 
 */
@Satisfies("checkNonEmpty")
public final class TestClassDelegate {

	public static boolean validateA(TestClass self) {
		return self.getAttribute().contains("A");
	}

	@Satisfies({ "E", "F" })
	public static boolean validateB(TestClass self) {
		return self.getAttribute().contains("B");
	}

	public static boolean validateC(TestClass self) {
		return self.getAttribute().contains("C");
	}

	@Satisfies("B")
	public static boolean validateD(TestClass self) {
		return self.getAttribute().contains("D");
	}

	@Satisfies("C")
	public static String validateE(TestClass self) {
		if (self.getAttribute().contains("E")) {
			return null;
		} else {
			return "E is missing";
		}
	}

	public static ValidationResult validateF(TestClass self) {
		if (self.getAttribute().contains("F")) {
			return ValidationResult.ok();
		}

		return ValidationResult.warning("F is missing",
				new SigmaQuickFix<TestClass>(TestClass.class,
						"Add F at the end", new IFix<TestClass>() {
							@Override
							public void execute(TestClass self) {
								self.setAttribute(self.getAttribute() + "F");
							}
						}));
	}

	public static String getDerivedAttribute(TestClass self) {
		return self.getAttribute() + self.getAttribute();
	}

	public static String invokeMethod(TestClass self) {
		return ">>" + self.getAttribute() + "<<";
	}

	public static boolean checkNonEmpty(TestClass self) {
		return !isNullOrEmpty(self.getAttribute());
	}

}
