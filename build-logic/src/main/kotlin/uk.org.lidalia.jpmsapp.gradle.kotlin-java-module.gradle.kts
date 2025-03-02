import org.gradle.api.JavaVersion.VERSION_21
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.gradlex.java-module-dependencies")
    id("org.jetbrains.kotlin.jvm")
}

group = "uk.org.lidalia.jpmsapp"
val moduleName = "${project.group}.${project.name}"

java {
    sourceCompatibility = VERSION_21
    targetCompatibility = VERSION_21
}

tasks.withType<KotlinCompile> {
    compilerOptions.jvmTarget = JVM_21
}

// this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
tasks.compileJava {
    // Compiling module-info in the 'main/java' folder needs to see already compiled Kotlin code
    options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
}
