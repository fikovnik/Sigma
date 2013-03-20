/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Nina Rinskaya
 *     		Fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=172820.
 *******************************************************************************/
package fr.unice.i3s.sigma.tests.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Util {

	// TODO: possible workaround for the 3.8 release
	// https://git.eclipse.org/c/gmf-tooling/org.eclipse.gmf-tooling.git/tree/tests/org.eclipse.gmf.tests/src/org/eclipse/gmf/tests/Utils.java
	// /**
	// * Sets a target platform in the test platform to get workspace builds OK
	// * with PDE.
	// *
	// * @throws Exception
	// */
	// @SuppressWarnings("restriction")
	// public static void setTargetPlatform() throws Exception {
	// ITargetPlatformService tpService = TargetPlatformService.getDefault();
	// ITargetDefinition targetDef = tpService.newTarget();
	// targetDef.setName("Tycho platform");
	// Bundle[] bundles = Platform.getBundle("org.eclipse.core.runtime")
	// .getBundleContext().getBundles();
	// List<ITargetLocation> bundleContainers = new
	// ArrayList<ITargetLocation>();
	// Set<File> dirs = new HashSet<File>();
	// for (Bundle bundle : bundles) {
	// AbstractBundle aBundle = (AbstractBundle) bundle;
	// final BaseData bundleData = (BaseData) aBundle.getBundleData();
	// File file = bundleData.getBundleFile().getBaseFile();
	// File folder = file.getParentFile();
	// if (!dirs.contains(folder)) {
	// dirs.add(folder);
	// bundleContainers.add(tpService.newDirectoryLocation(folder
	// .getAbsolutePath()));
	// }
	// }
	// targetDef.setTargetLocations(bundleContainers
	// .toArray(new ITargetLocation[bundleContainers.size()]));
	// targetDef.setArch(Platform.getOSArch());
	// targetDef.setOS(Platform.getOS());
	// targetDef.setWS(Platform.getWS());
	// targetDef.setNL(Platform.getNL());
	// // targetDef.setJREContainer()
	// tpService.saveTargetDefinition(targetDef);
	// LoadTargetDefinitionJob.load(targetDef);
	// }

	/**
	 * Search the user hard-drive for a Java class library. Returns null if none
	 * could be found.
	 */
	public static String[] getJavaClassLibs() {
		// check bootclasspath properties for Sun, JRockit and Harmony VMs
		String bootclasspathProperty = System
				.getProperty("sun.boot.class.path"); //$NON-NLS-1$
		if ((bootclasspathProperty == null)
				|| (bootclasspathProperty.length() == 0)) {
			// IBM J9 VMs
			bootclasspathProperty = System.getProperty("vm.boot.class.path"); //$NON-NLS-1$
			if ((bootclasspathProperty == null)
					|| (bootclasspathProperty.length() == 0)) {
				// Harmony using IBM VME
				bootclasspathProperty = System
						.getProperty("org.apache.harmony.boot.class.path"); //$NON-NLS-1$
			}
		}
		String[] jars = null;
		if ((bootclasspathProperty != null)
				&& (bootclasspathProperty.length() != 0)) {
			StringTokenizer tokenizer = new StringTokenizer(
					bootclasspathProperty, File.pathSeparator);
			final int size = tokenizer.countTokens();
			jars = new String[size];
			int i = 0;
			while (tokenizer.hasMoreTokens()) {
				final String fileName = toNativePath(tokenizer.nextToken());
				if (new File(fileName).exists()) {
					jars[i] = fileName;
					i++;
				}
			}
			if (size != i) {
				// resize
				System.arraycopy(jars, 0, (jars = new String[i]), 0, i);
			}
		} else {
			String jreDir = getJREDirectory();
			final String osName = System.getProperty("os.name");
			if (jreDir == null) {
				return new String[] {};
			}
			if (osName.startsWith("Mac")) {
				return new String[] { toNativePath(jreDir
						+ "/../Classes/classes.jar") };
			}
			final String vmName = System.getProperty("java.vm.name");
			if ("J9".equals(vmName)) {
				return new String[] { toNativePath(jreDir
						+ "/lib/jclMax/classes.zip") };
			}
			String[] jarsNames = null;
			ArrayList<String> paths = new ArrayList<String>();
			if ("DRLVM".equals(vmName)) {
				FilenameFilter jarFilter = new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".jar")
								& !name.endsWith("-src.jar");
					}
				};
				jarsNames = new File(jreDir + "/lib/boot/").list(jarFilter);
				addJarEntries(jreDir + "/lib/boot/", jarsNames, paths);
			} else {
				jarsNames = new String[] { "/lib/vm.jar", "/lib/rt.jar",
						"/lib/core.jar", "/lib/security.jar", "/lib/xml.jar",
						"/lib/graphics.jar" };
				addJarEntries(jreDir, jarsNames, paths);
			}
			jars = new String[paths.size()];
			paths.toArray(jars);
		}
		return jars;
	}

	/**
	 * Makes the given path a path using native path separators as returned by
	 * File.getPath() and trimming any extra slash.
	 */
	public static String toNativePath(String path) {
		String nativePath = path.replace('\\', File.separatorChar).replace('/',
				File.separatorChar);
		return nativePath.endsWith("/") || nativePath.endsWith("\\") ? nativePath
				.substring(0, nativePath.length() - 1) : nativePath;
	}

	private static void addJarEntries(String jreDir, String[] jarNames,
			ArrayList<String> paths) {
		for (int i = 0, max = jarNames.length; i < max; i++) {
			final String currentName = jreDir + jarNames[i];
			File f = new File(currentName);
			if (f.exists()) {
				paths.add(toNativePath(currentName));
			}
		}
	}

	/**
	 * Returns the JRE directory this tests are running on. Returns null if none
	 * could be found.
	 * 
	 * Example of use: [org.eclipse.jdt.core.tests.util.Util.getJREDirectory()]
	 */
	public static String getJREDirectory() {
		return System.getProperty("java.home");
	}

}
