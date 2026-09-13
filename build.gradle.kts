plugins {
    id("kff.common-conventions")
}

// maven.repo.local is set within the Julia script in the website branch
tasks.create("publishAllMavens") {
    dependsOn(":forge:publishAllMavens")
}

task<Exec>("testREADME") {
    group = "verification"
    description = "Applies steps in README to ensure it works on mdk"
    workingDir("./")
    commandLine("kotlinc", "-script", ".github/ReadmeTester.kts")
    doLast {
        executionResult.get().assertNormalExitValue()
    }
}
