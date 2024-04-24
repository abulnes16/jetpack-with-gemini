package com.abulnes16.jetpack_with_gemini.navigation

interface AppRoutes {
    val route: String
}

object Welcome: AppRoutes {
  override  val route: String = "welcome"
}

object Chat: AppRoutes {
    override val route: String = "chat"
}