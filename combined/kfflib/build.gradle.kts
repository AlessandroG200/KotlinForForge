plugins {
    `java-library`
}

base.archivesName.set("kfflib")
version = project.property("kff_version") as String
group = "dev.alessandro"

tasks.jar.configure {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(provider {
        listOf(
            zipTree(rootProject.tasks.named<Jar>("libNeoForgeJar").get().archiveFile),
            zipTree(rootProject.tasks.named<Jar>("libForgeJar").get().archiveFile)
        )
    })

    manifest.attributes("FMLModType" to "GAMELIBRARY")
}
