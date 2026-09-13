import thedarkcolour.kotlinforforge.plugin.getKffMaxVersion

plugins {
    id("kff.common-conventions")
}

base.archivesName.set("kotlinforforge")

evaluationDependsOnChildren()

configurations {
    apiElements {
        artifacts.clear()
    }
    runtimeElements {
        setExtendsFrom(emptySet())
        artifacts.clear()
    }
}

repositories {
    mavenCentral()
}

val shadow: Configuration by configurations.creating {
    exclude("org.jetbrains", "annotations")
}

dependencies {
    shadow(libs.kotlin.reflect)
    shadow(libs.kotlin.stdlib)
    shadow(libs.kotlinx.coroutines.core)
    shadow(libs.kotlinx.coroutines.core.jvm)
    shadow(libs.kotlinx.coroutines.jdk8)
    shadow(libs.kotlinx.serialization.core)
    shadow(libs.kotlinx.serialization.json)

    // KFF Modules
    include(projects.combined.kfflang)
    include(projects.combined.kfflib)
    include(projects.combined.kffmod)
}

fun DependencyHandler.include(dep: ModuleDependency) {
    val version = project.version.toString()
    val kffMaxVersion = getKffMaxVersion()
    api(dep)
}

tasks {

    assemble {
        dependsOn(":combined:kfflang:build")
        dependsOn(":combined:kfflib:build")
        dependsOn(":combined:kffmod:build")
    }
}


val supportedMcVersions = listOf("1.19.3", "1.19.4", "1.20", "1.20.1", "1.20.2")

// Kotlin function ambiguity fix
fun <T : Any> Property<T>.provider(value: T) {
    set(value)
}
