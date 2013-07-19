package fr.unice.i3s.sigma.docgen.common

import org.eclipse.emf.ecore.EPackage
import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import fr.unice.i3s.sigma.m2t.TextTemplate
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.TypeUnion._

class ClassDiagram extends TextTemplate with EcoreDocUtils with EcorePackageScalaSupport {

  type M2TSource = EPackage
  
  protected def execute {
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

      // FIXME: use type unions [T: (EPackage |∨| EClassifier)#λ]
      source match {
        case e: EClass ⇒ {
          renderClass(e, "lightgrey")

          // render generalization
          for (superType ← e.eSuperTypes) {
            renderClass(superType, "white", attributes = false, operations = false)
            renderGeneralization(e, superType)
            !endl
          }

          // render references
          for (ref ← e.eReferences) {
            renderClass(ref.eReferenceType, "white", attributes = false, operations = false)
            renderReference(e, ref)
            !endl
          }
        }
        case e: EPackage ⇒ renderPackage(e)
        case e ⇒ error("rootElement must be either EClass or EPackage not " + e)
      }
    }
  }

  protected[common] def renderPackage(pkg: EPackage) {
    // render sub packages
    for (spkg ← pkg.getESubpackages) {
      renderSubPackage(spkg)
      !endl
    }

    // render data types
    val dataTypes = pkg.eClassifiers collect { case e: EDataType ⇒ e }
    for (dataType ← dataTypes) {
      renderDataType(dataType)
      !endl
    }

    // render enums
    val enums = pkg.eClassifiers collect { case e: EEnum ⇒ e }
    for (enum ← enums) {
      renderEnum(enum)
      !endl
    }

    // render call classes
    val classes = pkg.eClassifiers collect { case e: EClass ⇒ e }
    for (clazz ← classes) {
      // render class
      renderClass(clazz, "white")
      !endl

      // render generalization
      for (superType ← clazz.eSuperTypes intersect (classes)) {
        renderGeneralization(clazz, superType)
        !endl
      }

      // render references
      for (ref ← clazz.eReferences if classes.contains(ref.eReferenceType)) {
        renderReference(clazz, ref)
        !endl
      }
    }
  }

  protected[common] def renderSubPackage(pkg: EPackage) {
    !s"subgraph ${fqpn(pkg)}" curlyIndent {
      !s"label = ${pkg.name.quoted}"
      renderPackage(pkg)
    }
  }

  protected[common] def renderDataType(dataType: EDataType) {
    !s"${fqcn(dataType)}" squareIndent {
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
    !s"${fqcn(enum)}" squareIndent {
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

        for (e ← enum.eLiterals) {
          !s"""<TR><TD align="left">- ${e.literal}</TD></TR>"""
        }

        !"""
    	  </TABLE>
    	  </TD></TR>
    	  </TABLE>
    	  """
      }
    }
  }

  protected[common] def renderClass(clazz: EClass,
    bgColor: String,
    attributes: Boolean = true,
    operations: Boolean = true) {

    val name =
      if (clazz.isAbstract) s"<I>${clazz.name}</I>" else clazz.name

    val attrs = clazz.eStructuralFeatures collect { case e: EAttribute ⇒ e }

    !s"${fqcn(clazz)}" squareIndent {
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

        // generate attributes
        if (attributes && !attrs.isEmpty) {
          !"""
          <!-- Begin attributes -->
          <TR><TD>
          <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
          """

          for (e ← attrs) {
            !s"""<TR><TD align="left">${featureLabelWithType(e)}</TD></TR>"""
          }

          !"""
          </TABLE>
          </TD></TR>
          <!-- End attributes -->
          """
        }

        // generate operations
        if (operations && !clazz.eOperations.isEmpty) {
          !"""
          <!-- Begin operations -->
          <TR><TD>
          <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
          """

          for (o ← clazz.eOperations) {
            !s"""<TR><TD align="left">${operationLabelWithType(o)}</TD></TR>"""
          }

          !"""
          </TABLE>
          </TD></TR>
          <!-- End operations -->
          """
        }
        !"</TABLE>"
      }
    }
  }

  protected[common] def renderGeneralization(subType: EClass, superType: EClass) {
    !s"${fqcn(superType)}:port -> ${fqcn(subType)}:port" squareIndent {
      !"""
      arrowhead = "none"
      arrowhead = "none"
      arrowtail = "onormal"
      minlen = "1.5"
      """
    }
  }

  protected[common] def renderReference(clazz: EClass, ref: EReference) {
    val multi = multiplicity(ref) match {
      case Some(m) ⇒ m
      case None ⇒ "1"
    }
    !s"${fqcn(clazz)}:port -> ${fqcn(ref.eReferenceType)}:port" squareIndent {
      !s"""
      arrowhead = "${if (ref.eOpposite == null) "vee" else "none"}" 
      arrowtail = "${if (ref.isContainment) "diamond" else "none"}" 
      taillabel = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD></TD></TR></TABLE>>
      label = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD>- ${ref.name}</TD></TR></TABLE>>
      headlabel = <<TABLE border="0" cellborder="0" cellspacing="0" cellpadding="0"><TR><TD>${multi}</TD></TR></TABLE>>
      minlen = "3"
      labeldistance = "3.0"
      labelangle = "20.0" 
      """
    }
  }
}