package fr.unice.i3s.sigma.scala.utils

import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import fr.unice.i3s.sigma.scala.core.SigmaScalaPlugin

object PlatformUtils {

  def createInfo(message: Any, exception: Throwable): IStatus =
    createStatus(IStatus.INFO, message, exception)

  def createError(message: Any, exception: Throwable): IStatus =
    createStatus(IStatus.ERROR, message, exception)

  def createStatus(severity: Int, message: Any, exception: Throwable): IStatus = {
    new Status(severity, SigmaScalaPlugin.PLUGIN_ID, message.toString, exception)
  }

}

