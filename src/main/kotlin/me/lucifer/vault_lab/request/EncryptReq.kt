package me.lucifer.vault_lab.request

import com.fasterxml.jackson.annotation.JsonProperty

data class EncryptReq(
    @JsonProperty("data")
    val data: MutableMap<String, Any>,
    @JsonProperty("keyName")
    val keyName: String
)