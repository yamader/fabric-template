package net.dyama.hoge

import net.fabricmc.api.ModInitializer

@Suppress("UNUSED")
object Hoge: ModInitializer {
  private const val MOD_ID = "hoge"

  override fun onInitialize() {
    println("Hoge mod has been initialized.")
  }
}
