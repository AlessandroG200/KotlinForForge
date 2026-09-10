# Kotlin For Forge (Fork)

Makes Kotlin (Neo)Forge-friendly.
Upstream mod by thedarkcolour at (https://github.com/thedarkcolour/KotlinForForge)
Forked for personal use (Kotlin updates on 1.20.1 and 1.21.1)
### Modifications done (dated at September 10, 2026):

- Updated Kotlin to 2.4.20
- Published on Github Packages under the "dev.alessandro" group to not conflict with upstream
- Disabled modrith and curseforge publishing, and replaced their workflows with a manual dispatch workflow to publish to Github Packages.
- Bumps Gradle to 9.7.1

### Updating reference for myself:

1. Bump the needed libraries
2. Run the `publishAllPublicationsToMavenLocalRepository` task to check that compiles
3. Test the resulting mod (`kotlinforforge-[VERSION]-all`) on 1.21.1 NeoForge
4. If nothing strange happens, commit changes and run the workflow.

### See the original README at [upstream](https://github.com/thedarkcolour/KotlinForForge/blob/5.x/README.md)