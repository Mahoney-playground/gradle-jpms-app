plugins {
    id("uk.org.lidalia.jpmsapp.gradle.kotlin-java-module")
    id("application")
}

application {
    applicationDefaultJvmArgs = listOf("-ea")
    mainClass.set("uk.org.lidalia.jpmsapp.app.AppKt")
    mainModule.set("uk.org.lidalia.jpmsapp.app")
}
javaModuleDependencies.moduleNameToGA.put("org.apache.commons.text", "org.apache.commons:commons-text")
