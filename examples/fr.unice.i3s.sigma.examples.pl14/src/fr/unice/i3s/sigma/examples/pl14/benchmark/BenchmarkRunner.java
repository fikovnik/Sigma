package fr.unice.i3s.sigma.examples.pl14.benchmark;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.io.Files;

public class BenchmarkRunner {

	private static final int NUMBER_OF_EXECUTION = 20;

	private final Class<?> benchmarkClazz;
	private final ResourceGenerator generator = new OO2JavaModelGenerator();

	public BenchmarkRunner(String clazz) throws Exception {
		benchmarkClazz = Class.forName(clazz);
	}

	private M2TMicroBenchmark createBenchmark() throws Exception {
		return (M2TMicroBenchmark) benchmarkClazz.getConstructors()[0]
				.newInstance();
	}

	public void execute(int n, boolean deleteOnExit) throws Exception {
		Resource resource = generator.generate();

		{
			File f = new File(generator.toString()+".xmi");
			FileOutputStream fout = new FileOutputStream(f);
			try {
				resource.save(fout, null);
			} finally {
				if (fout != null)
					fout.close();
			}
			System.out.println("Saving generated model to: "+f.getAbsolutePath());
		}

		List<File> temps = new LinkedList<File>();

		System.out.println("Running: " + benchmarkClazz);
		long tt = System.currentTimeMillis();
		File temp = Files.createTempDir();
		System.out.println(temp);
		temps.add(temp);
		for (int i = 0; i < n; i++) {

			M2TMicroBenchmark benchmark = createBenchmark();

			benchmark.pre(resource);

			long start = System.currentTimeMillis();
			benchmark.run(resource, temp);
			long end = System.currentTimeMillis();

			benchmark.post(resource);

			System.out.println(end - start);
		}
		System.out.println("Total: "+(System.currentTimeMillis() - tt));

		if (deleteOnExit) {
			for (File f : temps) {
				Files.deleteRecursively(f);
			}
		} else {
			for (File f : temps) {
				System.out.println(f.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new IllegalArgumentException("Missing benchmark class name");
		}

		String clazz = args[0];

		BenchmarkRunner runner = new BenchmarkRunner(clazz);
		runner.execute(NUMBER_OF_EXECUTION, true);
	}

}
