package fr.unice.i3s.sigma.ui.ide.validation.helpers;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

public class TreeHasItems extends DefaultCondition {
	private final SWTBotTree tree;

	public TreeHasItems(SWTBotTree tree) {
		this.tree = tree;
	}

	// return true if the condition matches, false otherwise
	@Override
	public boolean test() {
		return tree.hasItems();
	}

	// provide a human readable error message
	@Override
	public String getFailureMessage() {
		return "Timed out waiting for " + tree + " to contain some items";
	}
}