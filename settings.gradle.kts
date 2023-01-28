rootProject.name = "Hoge mod"

pluginManagement {
  repositories {
    maven("https://maven.fabricmc.net") { name = "Fabric" }
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      // versions
      version("kotlin", "1.8.0")
      version("fabric-loom", "1.1.7")

      version("minecraft", "1.19.3")
      version("fabric-loader", "0.14.13")
      version("fabric-api", "0.73.0+1.19.3")
      version("fabric-kotlin", "1.9.0+kotlin.1.8.0")

      // libraries
      library("minecraft", "com.mojang", "minecraft").versionRef("minecraft")
      library("yarn", "net.fabricmc:yarn:1.19.3+build.5")
      library("fabric-loader", "net.fabricmc", "fabric-loader").versionRef("fabric-loader")
      library("fabric-api", "net.fabricmc.fabric-api", "fabric-api").versionRef("fabric-api")
      library("fabric-kotlin", "net.fabricmc", "fabric-language-kotlin").versionRef("fabric-kotlin")

      // plugins
      plugin("kotlin", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
      plugin("fabric-loom", "fabric-loom").versionRef("fabric-loom")
    }
  }
}
