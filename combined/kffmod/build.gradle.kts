plugins {
    `java-library`
}

base.archivesName.set("kffmod")
version = project.property("kff_version") as String
group = "dev.alessandro"

tasks.jar.configure {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(provider {
        listOf(
            zipTree(rootProject.tasks.named<Jar>("modNeoForgeJar").get().archiveFile),
            zipTree(rootProject.tasks.named<Jar>("modForgeJar").get().archiveFile)
        )
    })
}
