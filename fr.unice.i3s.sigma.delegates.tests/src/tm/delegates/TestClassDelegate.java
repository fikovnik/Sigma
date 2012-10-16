package tm.delegates;

import fr.unice.i3s.sigma.core.ValidationResult;
import tm.TestClass;

public final class TestClassDelegate {

	public static boolean validateNonZero(TestClass self) {
		return self.getAttribute() != 0;
	}

	public static boolean validateSmallerThan100(TestClass self) {
		return self.getAttribute() < 100;
	}

	public static boolean validateDivides64(TestClass self) {
		return true; // 64 % self.getAttribute() == 0;
	}

	public static String validateWithMessage(TestClass self) {
		if (self.getAttribute() == 3) {
			return "The number must not be 3";
		} else {
			return null;
		}
	}

	public static ValidationResult validateWithQuickFix(TestClass self) {
		// if (self.getAttribute() != 8) {
		// return ValidationResult.warning("The number must be 8",
		// new SigmaQuickFix<TestClass>(TestClass.class,
		// "Make the number become 8", new IFix<TestClass>() {
		// @Override
		// public void execute(TestClass self) {
		// self.setAttribute(8);
		// }
		// }));
		// } else {
		return ValidationResult.ok();
		// }
	}

	public static int getDerivedAttribute(TestClass self) {
		return self.getAttribute() / 2;
	}

	public static int invokeGetSquare(TestClass self) {
		return self.getAttribute() * self.getAttribute();
	}

}
