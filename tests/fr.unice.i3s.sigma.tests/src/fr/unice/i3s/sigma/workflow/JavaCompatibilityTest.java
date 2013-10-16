package fr.unice.i3s.sigma.workflow;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;

import scala.Function2;
import scala.Option;
import scala.runtime.AbstractFunction2;
import fr.unice.i3s.sigma.workflow.lib.*;
import fr.unice.i3s.sigma.java.workflow.Workflow;

public class JavaCompatibilityTest extends Workflow {

	private final String projectName = "spinefm-core";
	private final String runtimeProject = "../" + projectName;
	private final String src = runtimeProject + "/src";
	private final String srcGen = runtimeProject + "/src-gen";
	private final String model = "platform:/resource/" + projectName
			+ "/model/MetamodelSpineFM.genmodel";

	private final static Function2<String, String, Option<String>> mapper = new AbstractFunction2<String, String, Option<String>>() {
		@Override
		public Option<String> apply(String base, String from) {
			URI uri = URI.createURI(base + "/" + from.replace('.', '/')
					+ "Delegate.java");
			boolean found = URIConverter.INSTANCE.exists(uri, null);
			return found ? Option.apply(from + "Delegate") : Option
					.<String> apply(null);
		}
	};

	public void execute() {
		execute(new StandaloneSetup() {
			{
				setPlatformPath(runtimeProject);
			}
		});

		execute(new CleanDirectory() {
			{
				setPath(srcGen);
			}
		});

		execute(new GenerateEcore() {
			{
				setGenModelURI(model);
				srcPath(src);
				setInstanceDelegateNameMapper(mapper);
			}
		});
	}

	public static void main(String[] args) {
//		new JavaCompatibilityTest().execute();
	}

}
