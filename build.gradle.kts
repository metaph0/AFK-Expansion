plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.metapho"
version = "1.0.0"
description = "AFK PlaceholderAPI Expansion"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/") {
        name = "placeholderapi"
    }
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc"
    }
}

dependencies {
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-api:4.24.0")
    compileOnly("net.kyori:adventure-text-minimessage:4.24.0")
}

tasks {
    shadowJar {
        archiveFileName.set("AFK-Expansion.jar")
    }
}
