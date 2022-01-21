package com.chyngyz.goratest.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chyngyz.goratest.screens.detail.DetailScreen
import com.chyngyz.goratest.screens.detail.DetailViewModel
import com.chyngyz.goratest.screens.home.HomeViewModel
import com.chyngyz.goratest.screens.home.UsersScreen

@ExperimentalFoundationApi
@Composable
fun GoraNavigation() {

   val navController = rememberNavController()
   NavHost(navController = navController, startDestination = GoraScreens.UsersScreen.name) {

      composable(GoraScreens.UsersScreen.name) {
         val homeViewModel = hiltViewModel<HomeViewModel>()
         UsersScreen(navController, homeViewModel)
      }

      val detail = GoraScreens.DetailScreen.name
      composable("$detail/{userId}", arguments = listOf(navArgument("userId") {
         type = NavType.IntType
      })) {
         it.arguments?.getInt("userId")?.let { id ->
            val viewModel = hiltViewModel<DetailViewModel>()
            DetailScreen(navController, id, viewModel)
         }
      }
   }
}