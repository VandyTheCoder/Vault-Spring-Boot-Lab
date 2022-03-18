package me.lucifer.vault_lab.service

import com.google.gson.Gson
import me.lucifer.vault_lab.request.DecryptReq
import me.lucifer.vault_lab.request.EncryptReq
import me.lucifer.vault_lab.response.DecryptRes
import me.lucifer.vault_lab.response.EncryptRes
import org.springframework.stereotype.Service
import org.springframework.vault.core.VaultTemplate

@Service
class CryptographyService(
    private val operations : VaultTemplate
){
    fun encrypt(req: EncryptReq) : EncryptRes {
        val transitOperations = operations.opsForTransit("transit")
        val jsonData = Gson().toJson(req.data).toString()
        val cipherText = transitOperations.encrypt(req.keyName, jsonData)
        return EncryptRes(cipherText, jsonData)
    }

    fun decrypt(req: DecryptReq) : DecryptRes {
        val transitOperations = operations.opsForTransit("transit")
        val data = transitOperations.decrypt(req.keyName, req.cipher)
        return DecryptRes(Gson().fromJson(data, MutableMap::class.java))
    }
}