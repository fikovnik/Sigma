package fr.unice.i3s.sigma.examples.performance.epsilon;

import java.io.File;
import java.net.URI;

import oo.Class;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplate;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import fr.unice.i3s.sigma.examples.performance.benchmark.M2TMicroBenchmark;

public class EpsilonOO2JavaBenchmark1 implements M2TMicroBenchmark {

	private static final String TEMPLATE_ROOT = "src/fr/unice/i3s/sigma/examples/pl14/epsilon/";
	private static final String SOURCE = "src/fr/unice/i3s/sigma/examples/pl14/epsilon/JavaClass.egl";

	private EglTemplate template;
	private EglFileGeneratingTemplateFactory factory;

	@Override
	public void pre(Resource resource) throws Exception {
		URI source = new File(SOURCE).toURI();

		factory = new EglFileGeneratingTemplateFactory();
		factory.setTemplateRoot(new File(TEMPLATE_ROOT).toURI().toString());

		template = factory.load(source);
	}

	@Override
	public void run(Resource resource, File targetDir) throws Exception {
		TreeIterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject x = it.next();
			if (x instanceof oo.Class) {
				Class cls = (oo.Class) x;
				template.populate("cls", cls);
				String res = template.process();
				File to = new File(targetDir, cls.getName() + ".java");
				Files.write(res, to, Charsets.US_ASCII);
			}
		}
	}

	@Override
	public void post(Resource resource) throws Exception {
		factory.getContext().getModelRepository().dispose();
	}

}
