#!/usr/bin/env bash

KOTLIN_HOME=../kotlin-native
DIR=.
PATH=$KOTLIN_HOME/dist/bin:$PATH
PATH=$KOTLIN_HOME/bin:$PATH
PATH=$KOTLIN_HOME/dist/dependencies/clang-llvm-3.9.0-darwin-macos/bin/:$PATH

    # Compile Kotlin code to LLVM bytecode
echo "Compiling Kotlin Code"
konanc $DIR/Block.kt $DIR/Blockchain.kt $DIR/SHA512Context.kt $DIR/Main.kt \
          -o Main || exit 1
        # -o $DIR/build/bin/Main || exit 1

echo "Compiled!"