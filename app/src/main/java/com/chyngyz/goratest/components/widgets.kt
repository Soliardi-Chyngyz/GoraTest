package com.chyngyz.goratest.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.chyngyz.goratest.ui.theme.Typography

@Composable
fun LinearProgress() {
   Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
   ) {
      Text("Loading...", style = Typography.body1)
      LinearProgressIndicator()
   }
}