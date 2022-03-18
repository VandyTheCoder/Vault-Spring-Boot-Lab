package me.lucifer.vault_lab.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
class AppConfig(
    val vaultConfig : VaultConfig = VaultConfig()
){
    data class VaultConfig(
        var rootToken : String = "",
        var endpoint : String = ""
    )
}