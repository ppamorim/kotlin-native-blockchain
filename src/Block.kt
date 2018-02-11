class Block(
    val index: Int,
    val timestamp: Long,
    var data: ByteArray,
    var previousHash: String = "") {

    var hash: String = calculateHash()

    fun calculateHash(): String {
        //Not ready
        return SHA512Context.sha512(byteArrayOf(index.toByte(), timestamp.toByte()), false).toString()
    }
}