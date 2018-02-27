#!/usr/bin/env bash
git submodule add git@github.com:JetBrains/kotlin-native.git

# Download Kotlin/Native sources
git submodule update --init --recursive

# Download and build all of the dependencies required by Kotlin/Native
cd kotlin-native
./gradlew dependencies:update§

# Build Kotlin/Native toolchain
./gradlew cross_dist

# Go back to the root directory
cd ..