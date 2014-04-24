package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Member;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait MemberScalaSupport extends EMFScalaSupport {
  type Member = fr.inria.spirals.sigma.ttc14.fixml.objlang.Member
  
  object Member {
    def unapply(that: Member): Option[(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class)] =
      Some((that.getParent))
  }
}

object MemberScalaSupport extends MemberScalaSupport
