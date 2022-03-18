package me.lucifer.vault_lab.request

import com.fasterxml.jackson.annotation.JsonProperty

data class DecryptReq(
    @JsonProperty("cipher")
    val cipher: String,
    @JsonProperty("keyName")
    val keyName: String
)