package fr.unice.i3s.sigma.examples.sle13;

import org.eclipse.emf.ecore.resource.Resource;

public interface MicroBenchmark {

	public void pre(Resource resource) throws Exception;
	public void run(Resource resource) throws Exception;
	public void post(Resource resource) throws Exception;
	
}
