package com.chyngyz.goratest.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.chyngyz.goratest.components.GoraAppBar
import com.chyngyz.goratest.components.LinearProgress
import com.chyngyz.goratest.model.user.Users
import com.chyngyz.goratest.model.user.UsersItem
import com.chyngyz.goratest.navigation.GoraScreens
import com.chyngyz.goratest.ui.theme.SemiGray
import com.chyngyz.goratest.ui.theme.Typography

@Composable
fun UsersScreen(navController: NavHostController, homeViewModel: HomeViewModel) {

   Scaffold(topBar = {
      GoraAppBar(title = "Users")
   }) {
      Surface(modifier = Modifier.fillMaxSize()) {
         HomeContent(navController, homeViewModel)
      }
   }
}

@Composable
fun HomeContent(navController: NavHostController, homeViewModel: HomeViewModel) {

   Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Top) {
      UserList(navController, homeViewModel.data.value.data)
   }
}

@Composable
fun UserList(navController: NavHostController, data: Users?) {

   if (data.isNullOrEmpty())
      LinearProgress()
   else {
      data.forEach { item ->
         UserCard(item, navController)
      }
   }
}

@Composable
fun UserCard(item: UsersItem, navController: NavController) {

   Column(
      modifier = Modifier
         .height(50.dp)
         .fillMaxWidth()
         .padding(start = 16.dp)
         .clickable {
            navController.navigate(GoraScreens.DetailScreen.name + "/${item.id}")
         },
      verticalArrangement = Arrangement.Center
   ) {
      Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.SpaceBetween,
         modifier = Modifier
            .fillMaxWidth()
      ) {
         Row(horizontalArrangement = Arrangement.Start) {
            Text(item.name, style = Typography.body1)
         }

         Row(horizontalArrangement = Arrangement.End, modifier = Modifier.padding(end = 16.dp)) {
            Icon(
               imageVector = Icons.Default.ArrowForward,
               contentDescription = null,
               tint = SemiGray.copy(alpha = 0.4f)
            )
         }
      }
   }
   Divider(Modifier.padding(start = 16.dp))
}
