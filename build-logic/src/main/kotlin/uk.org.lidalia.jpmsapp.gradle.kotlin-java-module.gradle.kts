plugins {
    id("de.jjohannes.java-module-dependencies")
    id("org.jetbrains.kotlin.jvm")
}

group = "uk.org.lidalia.jpmsapp"
val moduleName = "${project.group}.${project.name}"

val javaLanguageVersion = JavaLanguageVersion.of(17)
java {
    toolchain.languageVersion.set(javaLanguageVersion)
}
kotlin.jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(javaLanguageVersion)
}

// this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
tasks.compileJava {
    // Compiling module-info in the 'main/java' folder needs to see already compiled Kotlin code
    options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
}
