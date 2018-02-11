#!/usr/bin/env bash
set -e
set -o pipefail

KOTLIN_HOME=../kotlin-native
DIR=.
PATH=$KOTLIN_HOME/dist/bin:$PATH
PATH=$KOTLIN_HOME/bin:$PATH

# Compile Kotlin code to LLVM bytecode
echo "Compiling Kotlin Code"
konanc $DIR/Main.kt -o Main
echo "Compiled!"