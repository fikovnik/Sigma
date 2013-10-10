package fr.unice.i3s.sigma.examples.pl14.java;

import java.io.File;

import oo.Class;
import oo.Classifier;
import oo.Package;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import fr.unice.i3s.sigma.examples.pl14.benchmark.M2TMicroBenchmark;

public class JavaOO2JavaBenchmark implements M2TMicroBenchmark {

	@Override
	public void pre(Resource resource) throws Exception {
	}

	@Override
	public void run(Resource resource, File targetDir) throws Exception {
		oo.Package pkg = (Package) resource.getContents().get(0);
		for (Classifier c : pkg.getOwnedElements()) {
			if (c instanceof oo.Class) {
				Class cls = (oo.Class) c;
				String res = new OO2JavaInJava(cls).toString();
				File to = new File(targetDir, cls.getName() + ".java");
				Files.write(res, to, Charsets.US_ASCII);
			}
		}
	}

	@Override
	public void post(Resource resource) throws Exception {
	}

}
