@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

include("utilities", "list", "app")
