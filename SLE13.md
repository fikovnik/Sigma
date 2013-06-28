---
layout: standalone
title: SLE 2013 Companion Webpage
---

This pages contains additional material accompanying the paper _"Exploring Internal Domain-Specific Languages for Model Manipulation"_ for [SLE'13](http://planet-sl.org/sle2013/) conference. All Sigma related code is in the SLE13 branch.

## Models

### Object-Oriented Model (OO Model)

![OO Ecore Model](images/SLE13/OO.ecorediag.png "OO Ecore Model")

### Relational Model (DB Model)

![DB Ecore Model](images/SLE13/DB.ecorediag.png "DB Ecore Model")

## M2T Micro-benchmarking

The example on which we run a sample micro benchmarks was inspired by the example from [Acceleo tutorial](http://wiki.eclipse.org/Acceleo/Getting_Started#Generating_java_beans).

### Code

- Sigma: [OO2Java.scala](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13/src/fr/unice/i3s/sigma/examples/sle13/sigma/OO2Java.scala)
- Scala: [OO2JavaInScala.scala](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13/src/fr/unice/i3s/sigma/examples/sle13/scala/OO2JavaInScala.scala)

    The idea behind a _pure_ Scala implementation (no implicit conversions) is to get an impression about the performance degradation of using Sigma in comparison to only Scala. 
- Java: [OO2JavaInJava.java](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13/src/fr/unice/i3s/sigma/examples/sle13/java/OO2JavaInJava.java)
- Acceleo: [OO2Java.mtl](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13.acceleo/src/fr/unice/i3s/sigma/examples/sle13/acceleo/main/OO2Java.mtl)
- Epsilon EGL: [OO2Java.egl](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13.epsilon/src/fr/unice/i3s/sigma/examples/sle13/epsilon/OO2Java.egl), [JavaClass.egl](https://github.com/fikovnik/Sigma/blob/feature/SLE13/examples/fr.unice.i3s.sigma.examples.sle13.epsilon/src/fr/unice/i3s/sigma/examples/sle13/epsilon/JavaClass.egl)

    The EGL code was split to simulate similar modularity of the other M2T transformations. The run was made only using the `JavaClass.egl`


### Sample results

Following are the running times in milliseconds for 20 runs each transforming 500 classes with 100 methods. Like other micro-benchmarking, these results are only informative.

<iframe width="100%" height="630" frameborder="0" src="https://docs.google.com/spreadsheet/pub?key=0AgXBNlEmVc-kdDFRWlFtRXg4OHFBSlUzNXM2ZmhqWUE&single=true&gid=0&output=html&widget=true" />
