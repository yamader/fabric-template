import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.kotlin)
  alias(libs.plugins.fabric.loom)
}

val archivesName = "hoge"
group = "net.dyama"
version = "0.1.0"

dependencies {
  minecraft(libs.minecraft)
  mappings(libs.yarn)
  modImplementation(libs.fabric.loader)
  modImplementation(libs.fabric.api)
  modImplementation(libs.fabric.kotlin)
}

tasks {
  val javaVersion = JavaVersion.VERSION_17

  processResources {
    filesMatching("fabric.mod.json") {
      expand(
        mutableMapOf(
          "version" to project.version,
          "fabric_loader" to libs.versions.fabric.loader.get(),
          "fabric_api" to libs.versions.fabric.api.get(),
          "fabric_kotlin" to libs.versions.fabric.kotlin.get(),
          "minecraft" to libs.versions.minecraft.get(),
          "java" to javaVersion.toString()
        )
      )
    }
    filesMatching("*.mixins.json") {
      expand(
        mutableMapOf(
          "java" to javaVersion.toString()
        )
      )
    }
  }

  withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = javaVersion.toString()
    targetCompatibility = javaVersion.toString()
    options.release.set(javaVersion.toString().toInt())
  }

  withType<KotlinCompile> {
    kotlinOptions { jvmTarget = javaVersion.toString() }
  }

  java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    withSourcesJar()
  }

  jar {
    from("LICENSE") {
      rename { "${it}_${archivesName}" }
    }
  }
}
