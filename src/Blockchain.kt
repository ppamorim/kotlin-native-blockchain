//
// Copyright (c) 2018 Pedro Paulo de Amorim
//
// Permission is hereby granted, free of charge, to any person
// obtaining a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without restriction,
// including without limitation the rights to use, copy, modify, merge,
// publish, distribute, sublicense, and/or sell copies of the Software,
// and to permit persons to whom the Software is furnished to do so,
// subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included
// in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
// THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

class Blockchain {

   private val chain: MutableList<Block> = mutableListOf(buildGenesisBlock())

    fun buildGenesisBlock(): Block {
        return Block(0, 0, ByteArray(0), "0")
    }

    fun blockAt(index: Int): Block {
        return chain[index]
    }

    fun lastBlock(): Block {
        return chain.last()
    }

    fun add(block: Block) {
        block.previousHash = lastBlock().hash
        block.hash = block.calculateHash()
        chain.add(block)
    }

    fun isValid(): Boolean {
        for (i in 1..chain.count() - 1) {
            val currentBlock = chain[i]
            if (currentBlock.hash != currentBlock.calculateHash()) {
                return false
            }
            val previousBlock = chain[i - 1]
            if (currentBlock.previousHash != previousBlock.hash) {
                return false
            }
        }
        return true
    }

}
