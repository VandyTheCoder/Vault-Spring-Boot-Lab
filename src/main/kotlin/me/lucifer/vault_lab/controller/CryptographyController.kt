package me.lucifer.vault_lab.controller

import me.lucifer.vault_lab.request.DecryptReq
import me.lucifer.vault_lab.request.EncryptReq
import me.lucifer.vault_lab.response.DecryptRes
import me.lucifer.vault_lab.response.EncryptRes
import me.lucifer.vault_lab.service.CryptographyService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1/crypto"])
class CryptographyController(
    private val cryptographyService: CryptographyService
){
    @PostMapping("/encrypt")
    fun encrypt(@RequestBody req: EncryptReq) : ResponseEntity<EncryptRes>{
        return ok(cryptographyService.encrypt(req))
    }

    @PostMapping("/decrypt")
    fun decrypt(@RequestBody req: DecryptReq) : ResponseEntity<DecryptRes>{
        return ok(cryptographyService.decrypt(req))
    }
}