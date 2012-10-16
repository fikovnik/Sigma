package fr.unice.i3s.sigma.ui.ide.validation;

import static com.google.common.io.Files.copy;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class SigmaQuickFixMarkResolversTest {

	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();
	static {
		SWTBotPreferences.KEYBOARD_LAYOUT = "org/eclipse/swtbot/swt/finder/keyboard/MAC_EN_US";
	}

	private static final AtomicInteger screenShotCounter = new AtomicInteger(1);

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot.viewByTitle("Welcome").close();
	}

	@Before
	public void resetWorkbench() {
		bot.resetWorkbench();
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
	}

	@Test
	public void testName() throws Exception {
		final String xmiFile = "Library-2BooksWithNoCopies.xmi";

		// new project
		String path = createProject("test");
		screenshot();

		// copy test model
		copy(new File(xmiFile), new File(path, xmiFile));

		// refresh project so the file appears
		refreshProject("test");
		screenshot();

		SWTBotEditor editor = openFile("test", xmiFile);
		SWTBot editorBot = editor.bot();
		screenshot();

		// validate
		editorBot.tree().getAllItems()[0].contextMenu("Validate").click();
		SWTBotShell s = bot.shell("Validation Problems");
		screenshot();

		// close the dialog with the errors
		bot.button("OK").click();
		bot.waitUntil(shellCloses(s), 10000);

		// open Problems view
		SWTBot problemsBot = openView("org.eclipse.ui.views.ProblemView").bot();
		// try the quick fix
		problemsBot.tree().expandNode("Errors (2 items)").getItems()[0]
				.select().pressShortcut(Keystrokes.COMMAND,
						KeyStroke.getInstance('1'));
		screenshot();

		s = bot.shell("Quick Fix");
		screenshot();

		// close the dialog with the errors
		bot.button("Finish").click();
		bot.waitUntil(shellCloses(s), 10000);
		screenshot();

		// this time it should be only one error
		problemsBot.tree().expandNode("Errors (1 item)").getItems()[0].select();
		screenshot();

		// save the editor
		editor.saveAndClose();
		screenshot();

		deleteProject("test");
		screenshot();
	}

	private SWTBotView openView(final String viewId) throws PartInitException {
		// return bot.menu("Window").menu("Show View").menu("Problems").click();
		UIThreadRunnable.asyncExec(new VoidResult() {
			@Override
			public void run() {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView(viewId);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
		return bot.viewById(viewId);
	}

	private SWTBotEditor openFile(final String projectName,
			final String filePath) throws PartInitException {
		// projExpBot.tree().expandNode("test").getNode(xmiFile).doubleClick();

		final IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName).getFile(new Path(filePath));

		UIThreadRunnable.asyncExec(new VoidResult() {
			@Override
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				IEditorDescriptor desc = PlatformUI.getWorkbench()
						.getEditorRegistry().getDefaultEditor(file.getName());
				try {
					page.openEditor(new FileEditorInput(file), desc.getId());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});

		return bot.editorByTitle(file.getName());
	}

	private void refreshProject(String projectName) {
		SWTBot projExpBot = bot.viewById(
				"org.eclipse.ui.navigator.ProjectExplorer").bot();
		projExpBot.tree().getTreeItem(projectName).contextMenu("Refresh")
				.click();
	}

	private static void screenshot() {
		bot.captureScreenshot("screenshots/"
				+ (screenShotCounter.getAndIncrement()) + ".png");
	}

	private String createProject(String projectName) {
		bot.menu("File").menu("New").menu("Project...").click();

		SWTBotShell createProjectDialogShell = bot.shell("New Project");
		// bot.tree().getTreeItem("General").expand().getNode("Project").select();
		bot.tree().expandNode("General").select("Project");
		bot.button("Next >").click();

		bot.textWithLabel("Project name:").setText(projectName);

		String path = bot.textWithLabel("Location:").getText();
		bot.button("Finish").click();
		bot.waitUntil(shellCloses(createProjectDialogShell), 10000);

		return path;
	}

	private void deleteProject(String projectName) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);
		if (project.exists()) {
			project.close(null);
			project.delete(true, true, null);
		}
	}

}
