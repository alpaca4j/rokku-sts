package com.ing.wbaa.rokku.sts.config

import akka.actor.{ ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider }
import com.typesafe.config.Config

class VaultSettings(config: Config) extends Extension {

  val vaultUrl: String = config.getString("vault.url")
  val vaultPath: String = config.getString("vault.path")
  val vaultToken: String = config.getString("vault.token")
  val readTimeout: Int = config.getString("vault.read-timeout").toInt
  val openTimeout: Int = config.getString("vault.open-timeout").toInt
  val retries: Int = config.getString("vault.retries").toInt

}

object VaultSettings extends ExtensionId[VaultSettings] with ExtensionIdProvider {
  override def createExtension(system: ExtendedActorSystem): VaultSettings = new VaultSettings(system.settings.config)

  override def lookup(): ExtensionId[VaultSettings] = VaultSettings
}
