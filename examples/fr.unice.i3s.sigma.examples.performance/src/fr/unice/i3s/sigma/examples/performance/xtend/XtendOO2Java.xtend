package fr.unice.i3s.sigma.examples.performance.xtend


class XtendOO2Java {
	
	def genGetter(oo.Property p)
		'''
		public «p.type.name» get«p.name.toFirstUpper()»() {
			return «p.name»;
		}
		'''

	def genSetter(oo.Property p)
		'''
		public void set«p.name.toFirstUpper()»(«p.type.name» value) {
			this.«p.name» = «p.name»;
		}
		'''
	
	def genField(oo.Property p) 
		'''private «p.type.name» «p.name»;'''
	
	def genOperation(oo.Operation o)
		'''
		public «o.returnType.name» «o.name»() {
		  // TODO: should be implemented
		  throw new UnsupportedOperationException("«o.name»");
		}
		'''
	
	def generate(oo.Class cls)	
		'''
		public class «cls.name» {
			
			// fields
			«FOR p : cls.properties»
			«genField(p)»
			«ENDFOR»
			
			// getters
			«FOR p : cls.properties»
			«genGetter(p)»
			«ENDFOR»
			
			// setters
			«FOR p : cls.properties»
			«genSetter(p)»
			«ENDFOR»
			
			// operations
			«FOR p : cls.operations»
			«genOperation(p)»
			«ENDFOR»
		}
	    '''
		
	
}