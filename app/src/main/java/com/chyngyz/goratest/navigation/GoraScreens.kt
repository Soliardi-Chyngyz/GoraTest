package com.chyngyz.goratest.navigation

import java.lang.IllegalArgumentException

enum class GoraScreens {
   UsersScreen,
   DetailScreen;

   companion object {
      fun fromRoute(route: String?): GoraScreens =
         when (route?.substringBefore("/")) {
            UsersScreen.name -> UsersScreen
            DetailScreen.name -> DetailScreen
            null -> UsersScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
         }
   }
}