package fr.unice.i3s.sigma.delegates

import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate
import java.lang.reflect.Method
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.BasicSettingDelegate
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder
import org.eclipse.emf.common.notify.NotificationChain

final class SigmaSettingDelegate(
  feature: EStructuralFeature,
  delegateMethod: Method,
  domain: SigmaDelegateDomain) extends AbstractSigmaDelegate(delegateMethod, domain) with SettingDelegate {

  private val delegate = new BasicSettingDelegate.Stateless(feature) {
    override def get(owner: InternalEObject, resolve: Boolean, coreType: Boolean) =
      // FIMXE: do we need this
      SigmaSettingDelegate.this.get(owner, resolve, coreType).asInstanceOf[Object]

    // derived features are, implicitly, never set
    override def isSet(owner: InternalEObject) = false
  }

  def get(owner: InternalEObject, resolve: Boolean, coreType: Boolean) =
    domain.safeDynamicInvoke(delegateMethod, owner) {
      val ret = delegateMethod.invoke(null /* static */ , owner)
      domain.processResult(feature, ret)
    }

  // following are the methods from the SettingDelegate that are handled by the 
  // stateless delegate helper 

  override def dynamicSetting(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int) =
    delegate.dynamicSetting(owner, settings, dynamicFeatureID)

  override def dynamicGet(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int, resolve: Boolean,
    coreType: Boolean) =
    delegate.dynamicGet(owner, settings, dynamicFeatureID,
      resolve, coreType)

  override def dynamicIsSet(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int) =
    delegate.dynamicIsSet(owner, settings, dynamicFeatureID)

  override def dynamicSet(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int, newValue: Object) =
    delegate.dynamicSet(owner, settings, dynamicFeatureID, newValue)

  override def dynamicUnset(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int) =
    delegate.dynamicUnset(owner, settings, dynamicFeatureID)

  override def dynamicInverseAdd(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int,
    otherEnd: InternalEObject, notifications: NotificationChain) =
    delegate.dynamicInverseAdd(owner, settings,
      dynamicFeatureID, otherEnd, notifications)

  override def dynamicInverseRemove(owner: InternalEObject,
    settings: DynamicValueHolder, dynamicFeatureID: Int,
    otherEnd: InternalEObject, notifications: NotificationChain) =
    delegate.dynamicInverseRemove(owner, settings,
      dynamicFeatureID, otherEnd, notifications)
}