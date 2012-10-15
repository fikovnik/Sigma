package fr.unice.i3s.sigma.ui.ide.validation;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.SigmaQuickFixExecutionException;

public class ExecuteSigmaQuickFixCommand implements Command {

	private final ISigmaQuickFix quickFix;
	private final EObject eObject;
	private ChangeDescription changeDescription;

	public ExecuteSigmaQuickFixCommand(ISigmaQuickFix quickFix, EObject eObject) {
		this.quickFix = quickFix;
		this.eObject = eObject;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void execute() {
		ChangeRecorder recorder = new ChangeRecorder(eObject.eResource());
		try {
			quickFix.execute(eObject);
		} catch (SigmaQuickFixExecutionException e) {
			// TODO: log
			e.printStackTrace();
		} finally {
			changeDescription = recorder.endRecording();
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		if (changeDescription != null) {
			changeDescription.applyAndReverse();
		}
	}

	@Override
	public void redo() {
		if (changeDescription != null) {
			changeDescription.applyAndReverse();
		}
	}

	@Override
	public Collection<?> getResult() {
		return null;
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return Collections.emptyList();
	}

	@Override
	public String getLabel() {
		return quickFix.getLabel();
	}

	@Override
	public String getDescription() {
		return quickFix.getDescription();
	}

	@Override
	public void dispose() {
		changeDescription = null;
	}

	@Override
	public Command chain(Command command) {
		// TODO Auto-generated method stub
		return null;
	}

}
