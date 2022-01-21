package com.chyngyz.goratest.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.chyngyz.goratest.ui.theme.LightGray
import com.chyngyz.goratest.ui.theme.Purple500
import com.chyngyz.goratest.ui.theme.SemiGray
import com.chyngyz.goratest.ui.theme.Typography

@Composable
fun GoraAppBar(
   title: String,
   showHome: Boolean = true,
   icon: ImageVector = Icons.Default.ArrowBack,
   onBackArrowClicked: () -> Unit = {}
) {

   if (showHome)
      WithArrowBackTopBar(title)
   else
      NonArrowBackTopBar(onBackArrowClicked, icon, title)

}

@Composable
fun WithArrowBackTopBar(title: String) {

   TopAppBar(
      backgroundColor = LightGray, elevation = 10.dp,
      title = {
         Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
         ) {
            Text(
               text = title,
               style = Typography.h6,
               color = SemiGray.copy(alpha = 0.7f),
               modifier = Modifier.padding(end = 10.dp)
            )
         }
      },
   )

}

@Composable
private fun NonArrowBackTopBar(
   onBackArrowClicked: () -> Unit,
   icon: ImageVector,
   title: String,
) {
   TopAppBar(
      backgroundColor = LightGray, elevation = 10.dp,
      navigationIcon = {
         IconButton(onClick = {
            onBackArrowClicked.invoke()
         }) {
            Icon(
               imageVector = icon,
               contentDescription = "arrow back",
               tint = Purple500.copy(alpha = 0.7f)
            )
         }
      },
      title = {
         Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
         ) {
            Text(
               text = title,
               style = Typography.h6,
               color = SemiGray.copy(alpha = 0.7f),
               modifier = Modifier.padding(end = 60.dp)
            )
         }
      },
   )
}
