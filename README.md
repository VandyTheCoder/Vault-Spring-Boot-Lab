# Vault Lab
This is playground for spring-booter to test integrating with Vault the Hashi-Corp product.
Secret-Engines that are available now:
- **Transit** : Encrypt and Decrypt 

## Prerequisites
- Install Vault and Run Vault
```shell
brew tap hashicorp/tap
brew install hashicorp/tap/vault
vault server -dev
```
- Enable Vault's Transit Secret Engine (Open New Terminal)
```shell
vault secrets enable transit
```
You can access local vault ui via [Vault UI](http://localhost:8200).
You'll notice in vault server dev running log on yellow highlighted text.
Take the value of **Root Token**. You need to use value for authentication.
Please set the root token value in **application.yml**.

## Running Vault Lab
- Go to Vault Lab App Folder
```shell
cd VaultLab
./gradlew bootRun
```
---

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/gradle-plugin/reference/html/#build-image)
* [Vault Client Quick Start](https://docs.spring.io/spring-cloud-vault/docs/current/reference/html/#client-side-usage)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

