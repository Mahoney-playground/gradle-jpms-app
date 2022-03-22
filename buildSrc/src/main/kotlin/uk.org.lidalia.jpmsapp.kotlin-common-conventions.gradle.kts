import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:1.9")

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}

tasks {
    val compileKotlin: KotlinCompile by tasks
    val compileJava: JavaCompile by tasks

    compileJava.source = compileKotlin.source
    compileKotlin.destinationDirectory.set(compileJava.destinationDirectory.get())
}

val javaLanguageVersion = JavaLanguageVersion.of(17)

java {
    toolchain.languageVersion.set(javaLanguageVersion)
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(javaLanguageVersion)
    }
}

testing {
    suites {
        // Configure the built-in test suite
        @Suppress("UNUSED_VARIABLE", "UnstableApiUsage") val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.8.1")
        }
    }
}
