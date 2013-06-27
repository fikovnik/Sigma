package fr.unice.i3s.sigma.examples.sle13.acceleo;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.resource.Resource;

import fr.unice.i3s.sigma.examples.sle13.acceleo.main.OO2Java;
import fr.unice.i3s.sigma.examples.sle13.benchmark.M2TMicroBenchmark;

public class AcceleoOO2JavaBenchmark implements M2TMicroBenchmark {

	@Override
	public void pre(Resource resource) throws Exception {
	}

	@Override
	public void run(Resource resource, File targetDir) throws Exception {
	    OO2Java generator = new OO2Java(resource.getContents().get(0), targetDir, Collections.emptyList());
	    generator.doGenerate(new BasicMonitor());		
	}

	@Override
	public void post(Resource resource) throws Exception {
	}
	
}
