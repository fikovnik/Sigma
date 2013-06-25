---
layout: frontpage
title: Sigma Project
---

_The documentation is under construction, for more information please [contact us](#contact)._

## About ##

Model manipulation languages play an essential role in _Model-Driven Engineering_ by providing support for automating operations such as model validation and transformation. A number of different external _Domain-Specific Languages_ (DSL) for model manipulation have been proposed. They allow developers to manipulate models using higher-level abstractions resulting in gains in expressiveness over the use of general purpose programming languages. On the other hand, the complexity of their provided tool support and performance limitations together with language usability and interoperability issues can significantly contribute to accidental complexities, especially in larger projects. 

The Sigma project is our ongoing effort in exploring an alternative approach to model manipulation based on internal DSLs. It consists of a family of internal DSLs in [Scala](http://scala-lang.org) for manipulating [EMF](http://www.eclipse.org/modeling/emf/) models such as [model consistency checking](model-consistency-checking.html), [_model-to-model_ (M2M)](m2m-transformation.html) and [_model-to-text_ (M2T)](m2t-transformation.html) transformation. All these DSLs are build on a common infrastructure that provides a convenient model navigation and modification operations. The resulting languages have similar expressiveness and features found in existing approaches, while taking advantage of Scala versatility, performance and tool support.

## Publications ##

* Filip Křikava, Philippe Collet. "[On the Use of an Internal DSL for Enriching EMF Models](http://st.inf.tu-dresden.de/OCL2012/preproceedings/09.pdf)" in Proceedings of the International [Workshop on OCL and Textual Modelling 2012](http://st.inf.tu-dresden.de/OCL2012/) (OCL), Innsbruck, September 2012. 

## Who is using Sigma ##

* [ACTRESS](http://fikovnik.net/Actress) project

## Presentation ##

* Filip Křikava. [Enriching EMF Models with Scala (quick overview)](http://www.slideshare.net/krikava/enriching-emf-models-with-scala), EclipseCon'12 Europe Modeling Symposium, October 2012

* Filip Křikava, Philippe Collet. [On the Use of an Internal DSL for Enriching EMF Models](http://www.slideshare.net/krikava/krikava-ocl12), OCL'12 Workshop, September 2012

## Contact ##
<a id="contact"> </a>

SIGMA is being developed by the [MODALIS](http://modalis.polytech.unice.fr/) team in [I3S Laboratory](http://www.i3s.unice.fr/I3S/).

For further information, please contact:

* [Philippe Collet](http://www.i3s.unice.fr/~collet/)
* [Filip Křikava](http://fikovnik.net/about/)
* or visit [SIGMA github project]({{site.githubProject}})

### Acknowledgement ###

This work is partly funded by the [ANR SALTY project](https://salty.unice.fr/) under contract ANR-09-SEGI-012.
