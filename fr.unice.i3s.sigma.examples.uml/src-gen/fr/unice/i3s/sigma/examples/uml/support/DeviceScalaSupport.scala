package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Device;

trait DeviceScalaSupport {
  implicit class DeviceScalaSupport(that: Device) {
    
  }
}

object DeviceScalaSupport extends DeviceScalaSupport
