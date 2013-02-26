package fr.unice.i3s.sigma.docgen.graphviz.common

import org.eclipse.emf.ecore.EPackage
import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EEnum

class ClassDiagram(rootPkg: EPackage) extends TextTemplate with EcorePackageScalaSupport {

  override def stripWhitespace = true

  override def render {
    !"digraph G" curlyIndent {
      // preface
      !"""
	   rankdir = TD;
	   compound=true;
	   fontname = "Arial"
	   fontsize = "8"
	   
	   node [
	     fontname = "Arial"
	     fontsize = "12"
	     margin = "0"
	     shape = "plaintext"
	   ]
	   
	   edge [
	     fontname = "Arial"
	     fontsize = "9"
	     dir = "both"
	   ]	
	   """
      !endl << endl

      renderPackage(rootPkg)
    }
  }

  protected[common] def renderPackage(pkg: EPackage) {
    // render sub packages
    for (spkg ← pkg.getESubpackages) {
      renderSubPackage(spkg)
      !endl << endl
    }

    // render data types
    val dataTypes = pkg.eClassifiers collect { case e: EDataType ⇒ e }
    for (dataType ← dataTypes) {
      renderDataType(dataType)
      !endl << endl
    }

    // render enums
    val enums = pkg.eClassifiers collect { case e: EEnum ⇒ e }
    for (enum ← enums) {
      renderEnum(enum)
      !endl << endl
    }

    // render call classes
    val classes = pkg.eClassifiers collect { case e: EClass ⇒ e }
    for (clazz ← classes) {
      // render class
      renderClass(clazz, "white")
      !endl << endl

      // render generalization
      for (superType ← clazz.eSuperTypes intersect (classes)) {
        renderGeneralization(clazz, superType)
        !endl << endl
      }

      // render references
      for (ref ← clazz.eReferences if classes.contains(ref.eReferenceType)) {
        renderReference(clazz, ref)
        !endl << endl
      }
    }
  }

  protected[common] def renderSubPackage(pkg: EPackage) {
    !s"subgraph ${fqn(pkg)}" curlyIndent {
      !s"label = ${pkg.name.quoted}" << endl
      renderPackage(pkg)
    }
  }

  protected[common] def renderDataType(dataType: EDataType) {
    !s"${fqn(dataType)}" squareIndent {
      !"label = " angleIndent {
        !s"""
		  <TABLE bgcolor="white" border="0" cellspacing="0" cellpadding="0" cellborder="0" port="port">
		  <TR><TD>
		  <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
		  <TR><TD>«datatype»</TD></TR>
		  <TR><TD>${dataType.name}</TD></TR>
		  </TABLE>
		  </TD></TR>
		  <TR><TD>
		  <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
		  <TR><TD align="left">«javaclass» ${dataType.instanceClassName}</TD></TR>
		  </TABLE>
		  </TD></TR>
		  </TABLE>
		  """
      }
    }
  }

  protected[common] def renderEnum(enum: EEnum) {
    !s"${fqn(enum)}" squareIndent {
      !"label = " angleIndent {
        !s"""
    	  <TABLE bgcolor="white" border="0" cellspacing="0" cellpadding="0" cellborder="0" port="port">
    	  <TR><TD>
    	  <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
    	  <TR><TD>«enumeration»</TD></TR>
    	  <TR><TD>${enum.name}</TD></TR>
    	  </TABLE>
    	  </TD></TR>
    	  <TR><TD>
    	  <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
        """
        !endl

        for (e ← enum.eLiterals) {
          !s"""<TR><TD align="left">- ${e.literal}</TD></TR>""" << endl
        }

        !"""
    	  </TABLE>
    	  </TD></TR>
    	  </TABLE>
    	  """
      }
    }
  }

  protected[common] def renderClass(clazz: EClass, bgColor: String) {
    val name =
      if (clazz.isAbstract) s"<I>${clazz.name}</I>" else clazz.name

    val attrs = clazz.eStructuralFeatures collect { case e: EAttribute ⇒ e }

    !s"${fqn(clazz)}" squareIndent {
      !"label = " angleIndent {
        // name
        !s"""
        <TABLE bgcolor="$bgColor" border="0" cellspacing="0" cellpadding="0" cellborder="0" port="port">
        <TR><TD>
        <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
        <TR><TD>$name</TD></TR>
        </TABLE>
        </TD></TR>
        """

        !endl
        // generate attributes
        if (attrs.isEmpty) {
          !"<!-- No attributes -->" << endl
        } else {
          !"""
          <!-- Begin attributes -->
          <TR><TD>
          <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
          """
          !endl

          for (e ← attrs) {
            !s"""<TR><TD align="left">${featureLabelWithType(e)}</TD></TR>""" << endl
          }

          !"""
          </TABLE>
          </TD></TR>
          <!-- End attributes -->
          """

          !endl
        }
        !"</TABLE>"
      }
    }
  }

  protected[common] def renderGeneralization(subType: EClass, superType: EClass) {
    !s"${fqn(superType)}:port -> ${fqn(subType)}:port" squareIndent {
      !"""
      arrowhead = "none"
      arrowhead = "none"
      arrowtail = "onormal"
      minlen = "1.5"
      """
    }
  }

  protected[common] def renderReference(clazz: EClass, ref: EReference) {
    !s"${fqn(clazz)}:port -> ${fqn(ref.eReferenceType)}:port" squareIndent {
      !s"""
      arrowhead = "${if (ref.eOpposite == null) "vee" else "none"}" 
      arrowtail = "${if (ref.isContainment) "diamond" else "none"}" 
      taillabel = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD></TD></TR></TABLE>>
      label = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD>- ${ref.name}</TD></TR></TABLE>>
      headlabel = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD>${multiplicity(ref)}</TD></TR></TABLE>>
      minlen = "3"
      labeldistance = "3.0"
      labelangle = "20.0" 
      """
    }
  }

  protected[common] def multiplicity(feature: EStructuralFeature): String = {
    val multi = (feature.lowerBound, feature.upperBound) match {
      case (-1, -1) ⇒ "*"
      case (1, -1) ⇒ "1..*"
      case (1, 1) ⇒ "1"
      case (-1, 1) ⇒ "0..1"
      case (n, m) ⇒ s"$n..$m"
    }
    s"[$multi]"
  }

  protected[common] def featureLabel(feature: EStructuralFeature): String = {
    s"- ${feature.name} ${multiplicity(feature)}"
  }

  protected[common] def featureLabelWithType(feature: EStructuralFeature) = {
    feature match {
      case e: EAttribute ⇒ s"- ${e.name} : ${e.eType.name} ${multiplicity(e)}"
      case e: EReference ⇒ s"- ${e.name} : ${e.eReferenceType.name} ${multiplicity(e)}"
    }
  }

  protected[common] def fqn(pkg: EPackage): String = {
    require(pkg != null)

    def superPackages(p: EPackage): List[EPackage] = Option(p.eSuperPackage) match {
      case None ⇒ List(p)
      case Some(sp) ⇒ superPackages(sp) ::: List(sp, p)
    }
    superPackages(pkg) map (_.name) mkString ("__")
  }

  protected[common] def fqn(classifier: EClassifier): String = {
    require(classifier != null)

    Option(classifier.ePackage).map(fqn(_)).getOrElse("") + "__" + classifier.name
  }

}