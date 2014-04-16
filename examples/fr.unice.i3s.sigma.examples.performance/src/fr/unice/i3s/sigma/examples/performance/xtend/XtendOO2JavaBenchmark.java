package fr.unice.i3s.sigma.examples.performance.xtend;

import java.io.File;

import oo.Class;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import fr.unice.i3s.sigma.examples.performance.xtend.XtendOO2Java;
import fr.unice.i3s.sigma.examples.performance.benchmark.M2TMicroBenchmark;

public class XtendOO2JavaBenchmark implements M2TMicroBenchmark {

	@Override
	public void pre(Resource resource) throws Exception {
	}

	@Override
	public void run(Resource resource, File targetDir) throws Exception {
		TreeIterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject x = it.next();
			if (x instanceof oo.Class) {
				Class cls = (oo.Class) x;
				String res = new XtendOO2Java().generate(cls).toString();
				File to = new File(targetDir, cls.getName() + ".java");
				Files.write(res, to, Charsets.US_ASCII);
			}
		}
	}

	@Override
	public void post(Resource resource) throws Exception {
	}

}
