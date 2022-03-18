package me.lucifer.vault_lab.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.vault.authentication.ClientAuthentication
import org.springframework.vault.authentication.TokenAuthentication
import org.springframework.vault.client.VaultEndpoint
import org.springframework.vault.config.AbstractVaultConfiguration
import org.springframework.vault.core.VaultTemplate
import java.net.URI

@Configuration
class VaultConfig(appConfig: AppConfig): AbstractVaultConfiguration() {

    private val vaultConfig = appConfig.vaultConfig

    @Bean
    override fun vaultEndpoint(): VaultEndpoint = VaultEndpoint.from(URI(vaultConfig.endpoint))

    @Bean
    override fun clientAuthentication(): ClientAuthentication = TokenAuthentication(vaultConfig.rootToken)

    @Bean
    override fun vaultTemplate(): VaultTemplate = VaultTemplate(vaultEndpoint(), clientAuthentication())
}