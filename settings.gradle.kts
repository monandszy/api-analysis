plugins {
  // Apply the foojay-resolver plugin to allow automatic download of JDKs
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "practice-projects"



fun includeModules(dir: File) {
  if (dir.exists() && dir.isDirectory) {
    // Recursively process each subdirectory
    dir.listFiles()?.filter { it.isDirectory }?.forEach { subDir ->
      // Include nested directories only if they start with "_"
      if (subDir.name.startsWith("_")) {
        includeModules(subDir) // Recurse into subdirectories starting with "_"
      } else {
        include(":${subDir.name}") // Include other directories directly
        project(":${subDir.name}").projectDir = subDir
      }
    }
  }
}

val modulesDir = file("_modules")
includeModules(modulesDir)