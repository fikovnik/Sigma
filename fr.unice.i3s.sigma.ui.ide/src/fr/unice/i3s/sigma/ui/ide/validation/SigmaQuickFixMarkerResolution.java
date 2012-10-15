package fr.unice.i3s.sigma.ui.ide.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.SigmaQuickFixExecutionException;
import fr.unice.i3s.sigma.ui.ide.validation.ISigmaQuickFixManager.ISigmaQuickFixEntry;

public class SigmaQuickFixMarkerResolution implements IMarkerResolution {

	private final ISigmaQuickFix quickFix;

	public SigmaQuickFixMarkerResolution(ISigmaQuickFixEntry entry) {
		this.quickFix = entry.getQuickFix();
	}

	@Override
	public String getLabel() {
		return quickFix.getLabel();
	}

	@Override
	public void run(IMarker marker) {
		URI eObjectURI = SigmaQuickFixManager.getMarkerURI(marker);

		// first we need to find its editing domain
		// - if there is an opened editor we will reuse it
		// - otherwise we open a new one
		final EditingDomain domain = getEditingDomain(eObjectURI);
		if (domain == null) {
			// TODO: log
			return;
		}

		EObject eObject = null;
		ResourceSet resourceSet = domain.getResourceSet();
		for (Resource resource : resourceSet.getResources()) {
			EObject temp = resource.getEObject(eObjectURI.fragment());
			if (temp != null) {
				eObject = temp;
				break;
			}
		}
		if (eObject == null) {
			// TODO: log
			return;
		}

		// FIXME: revalidate?
		// Diagnostic diagnostics = Diagnostician.INSTANCE.validate(eObj);
		// if (diagnostics.getSeverity() == Diagnostic.OK) {
		// return ;
		// }

		// validate - runs the quick fix guard
		try {
			if (!quickFix.validate(quickFix.getContextClass().cast(eObject))) {
				// TODO: log
				return;
			}
		} catch (SigmaQuickFixExecutionException e) {
			// TODO: log
			e.printStackTrace();
			return;
		}

		try {
			// safely execute the quick fix using a command stack so it supports
			// undo / redo
			domain.getCommandStack().execute(
					new ExecuteSigmaQuickFixCommand(quickFix, eObject));
			eObject.eResource().setModified(true);
			marker.delete();
		} catch (Exception e) {
			// TODO: log
			e.printStackTrace();
		}
	}

	private EditingDomain getEditingDomain(URI uri) {
		String path = getResourcePath(uri);
		String editorId = PlatformUI.getWorkbench().getEditorRegistry()
				.getDefaultEditor(path).getId();

		IEditorPart part = null;

		try {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(path));
			part = page.openEditor(new FileEditorInput(file), editorId, false);
		} catch (PartInitException e) {
			return null;
		}

		if (part instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) part).getEditingDomain();
		} else {
			return null;
		}
	}

	private String getResourcePath(URI uri) {
		String path = uri.path();
		if (path.startsWith("/resource")) {
			// "/resource" is EMF stuff not recognized by Path class
			// It is used to identify a resource located in the workspace. The
			// next path segment after "/resource" should be the name of a
			// project, which can be followed by the folder and/or file we want
			// to locate. This is then recognized by eclipse.
			// ref: http://goo.gl/2C0jJ
			path = path.substring("/resource".length());
		}
		return path;
	}

}
