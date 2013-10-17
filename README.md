# SIGMA [![Build Status](https://travis-ci.org/fikovnik/Sigma.png?branch=develop)](https://travis-ci.org/fikovnik/Sigma) #

## Introduction ##

Sigma is a framework for enriching EMF models using JVM based General Programming Languages ([GPL](http://en.wikipedia.org/wiki/General-purpose_programming_language)). While the framework is general, there is a special treatment for [Scala](http://www.scala-lang.org). However any other JVM languages can be supported. While it started as a quick fix to a problems faced in [OCL](http://en.wikipedia.org/wiki/Object_Constraint_Language) (see the [OCL'12](http://st.inf.tu-dresden.de/OCL2012/preproceedings/09.pdf) paper for more details) it focuses towars much more ambitions goal….

Documentation can be found on the [project website](http://fikovnik.net/Sigma/).

## Building ##

Sigma is built by maven (tested with version 3.0.5). To make a build do the following:

1. Build Sigma dependencies (only need to be done once)

    `./build-deps.sh install`

1. Build Sigma

    `./build.sh install`

    This will also launch UI tests so make sure that you don't touch mouse
or keyboard while the build is running.

To make a release make sure the git flow has been properly done. Next
to the build commands execute:

1. Deploy to the update site

    `./release.sh milestones/1.0`

The maven build can be further customized by using one of these profiles:

* `skip-ui-tests` - do not run UI tests. 
  
    In order to skip all tests add `-Dmaven.test.skip=true` to the `./build.sh`.
