package me.lucifer.vault_lab

import me.lucifer.vault_lab.config.AppConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(AppConfig::class)
class VaultLabApplication

fun main(args: Array<String>) {
	runApplication<VaultLabApplication>(*args)
}
