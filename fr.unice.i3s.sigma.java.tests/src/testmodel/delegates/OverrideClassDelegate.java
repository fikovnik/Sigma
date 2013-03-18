package testmodel.delegates;

import testmodel.TestOverriding;

public class OverrideClassDelegate {

	public static boolean validateNormalConstraint(TestOverriding self) {
		return true;
	}

	public static String getNormalAttribute(TestOverriding self) {
		return "normalAttribute";
	}

	public static String invokeNormalMethod(TestOverriding self) {
		return "normalMethod";
	}

}
