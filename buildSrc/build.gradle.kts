plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

dependencies {
    implementation("de.jjohannes.gradle:java-module-dependencies:0.6")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}

val javaLanguageVersion = JavaLanguageVersion.of(8)

java {
    toolchain.languageVersion.set(javaLanguageVersion)
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(javaLanguageVersion)
    }
}
