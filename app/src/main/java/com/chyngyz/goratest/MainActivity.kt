package com.chyngyz.goratest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chyngyz.goratest.navigation.GoraNavigation
import com.chyngyz.goratest.ui.theme.GoraTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   @ExperimentalFoundationApi
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         GoraTestTheme {
            GoraTestApplication()
         }
      }
   }
}

@ExperimentalFoundationApi
@Composable
private fun GoraTestApplication() {
   Surface(
      color = MaterialTheme.colors.background,
      modifier = Modifier
         .fillMaxSize()
   ) {
      Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
         GoraNavigation()
      }
   }
}