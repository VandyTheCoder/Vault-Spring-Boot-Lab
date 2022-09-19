package me.lucifer.vault_lab.response

data class BaseRes(
    val status: Status = Status(),
    val result: Any?,
){
    data class Status(
        val code: Long = 0L,
        val message: String? = null
    )

    companion object {
        fun okWrap(data: Any?) : BaseRes = BaseRes(result = data)
        fun errWrap(status: Status): BaseRes = BaseRes(status = status, result = null)
    }
}