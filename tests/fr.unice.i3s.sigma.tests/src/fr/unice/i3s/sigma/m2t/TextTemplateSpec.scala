package fr.unice.i3s.sigma.m2t

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.test.scalatest.M2TMatchers

class TextTemplateSpec extends FlatSpec with MustMatchers with M2TMatchers {
  
  "TextTemplate" must "" in {
    
    class T extends StaticTextTemplate {      
      def execute {        
        !"a" curlyIndent {
          !"b"
        }
        !"c" curlyIndent {
          !"d"
        }
      }
    }
    
    
  }
  
}