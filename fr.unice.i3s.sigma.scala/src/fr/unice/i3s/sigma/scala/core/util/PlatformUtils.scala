package fr.unice.i3s.sigma.scala.core.util

import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status

import fr.unice.i3s.sigma.scala.core.SigmaScalaPlugin

object PlatformUtils {

  def createInfo(message: Any): IStatus =
    createStatus(IStatus.INFO, message)

  def createError(message: Any, exception: Throwable): IStatus =
    createStatus(IStatus.ERROR, message, Some(exception))

  def createStatus(severity: Int, message: Any, exception: Option[Throwable] = None): IStatus = {
    new Status(severity, SigmaScalaPlugin.PLUGIN_ID, message.toString, exception.orNull)
  }

}

