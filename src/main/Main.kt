
class Block(
    val index: Int,
    val timestamp: Long,
    val data: ByteArray,
    var hash: String,
    var previousHash: String = "") {

    fun calculateHash(): String {
        return
    }
}

class Blockchain {

   val chain: [Block] = [buildGenesisBlock()]

    fun buildGenesisBlock() {
        return Block(0, 0, [], "0")
    }

    fun lastBlock() {
        return chain.last()!!
    }

    fun add(block: Block) {
        block.previousHash = lastBlock().hash
        block.hash = block.calculateHash()
        chain.add(block)
    }

    fun isValid(): Boolean {
        for (i in 1..chain.count) {
            val currentBlock = chain[i]
            if (currentBlock.hash != currentBlock.calculateHash()) {
                return false
            }
            val previousBlock = chain[i - 1]
            if (currentBlock.previousBlock != previousBlock.hash) {
                return false
            }
        }
        return true
    }

}

fun main(args: Array<String>) {
    println("Test")
}