package me.lucifer.vault_lab.service

import com.google.gson.Gson
import me.lucifer.vault_lab.request.DecryptReq
import me.lucifer.vault_lab.request.EncryptReq
import me.lucifer.vault_lab.response.BaseRes
import me.lucifer.vault_lab.response.DecryptRes
import me.lucifer.vault_lab.response.EncryptRes
import org.springframework.stereotype.Service
import org.springframework.vault.VaultException
import org.springframework.vault.core.VaultTemplate
import org.springframework.web.client.HttpServerErrorException

@Service
class CryptographyService(
    private val operations : VaultTemplate
){
    fun encrypt(req: EncryptReq) : BaseRes {
        return try {
            val transitOperations = operations.opsForTransit("transit")
            val jsonData = Gson().toJson(req.data).toString()
            val cipherText = transitOperations.encrypt(req.keyName, jsonData)
            BaseRes.okWrap(EncryptRes(cipherText, jsonData))
        } catch (ex: VaultException) {
            BaseRes.errWrap(BaseRes.Status(1, ex.message?.split(";")?.get(0)?.split(": ")?.get(1)))
        } catch (ex: Exception) {
            BaseRes.errWrap(BaseRes.Status(1, "Don't know"))
        }
    }

    fun decrypt(req: DecryptReq) : BaseRes {
        return try {
            val transitOperations = operations.opsForTransit("transit")
            val data = transitOperations.decrypt(req.keyName, req.cipher)
            return BaseRes.okWrap(DecryptRes(Gson().fromJson(data, MutableMap::class.java)))
        } catch (ex: HttpServerErrorException) {
            BaseRes.errWrap(BaseRes.Status(1, ex.message?.split(";")?.get(0)?.split(": ")?.get(1)))
        } catch (ex: Exception) {
            BaseRes.errWrap(BaseRes.Status(1, "Don't know"))
        }
    }
}