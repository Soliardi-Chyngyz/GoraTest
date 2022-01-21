package com.chyngyz.goratest.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.GrayscaleTransformation
import com.chyngyz.goratest.R
import com.chyngyz.goratest.components.GoraAppBar
import com.chyngyz.goratest.components.LinearProgress
import com.chyngyz.goratest.model.photos.Album
import com.chyngyz.goratest.model.photos.AlbumItem
import com.chyngyz.goratest.ui.theme.LightGray
import com.chyngyz.goratest.ui.theme.Shapes
import com.chyngyz.goratest.ui.theme.Typography

@ExperimentalFoundationApi
@Composable
fun DetailScreen(navController: NavHostController, id: Int, viewModel: DetailViewModel) {

   viewModel.getPhotos(id)

   Scaffold(topBar = {
      GoraAppBar(
         title = "Photos",
         showHome = false,
         onBackArrowClicked = { navController.popBackStack() })
   }) {
      Surface(modifier = Modifier.fillMaxSize()) {
         DetailComponent(navController, viewModel)
      }
   }
}

@ExperimentalFoundationApi
@Composable
fun DetailComponent(navController: NavController, viewModel: DetailViewModel) {

   Column(verticalArrangement = Arrangement.Top) {
      PhotoList(navController, viewModel.data.value.data)
   }
}

@ExperimentalFoundationApi
@Composable
fun PhotoList(navController: NavController, data: Album?) {
   if (data.isNullOrEmpty())
      LinearProgress()
   else {
      LazyVerticalGrid(cells = GridCells.Adaptive(145.dp), contentPadding = PaddingValues(8.dp) ,content = {
         items(data.size) { index ->
            PhotoCard(data[index], navController)
         }
      })
   }
}

@Composable
fun PhotoCard(item: AlbumItem, navController: NavController) {

   Card(
      shape = Shapes.small,
      backgroundColor = LightGray,
      elevation = 6.dp,
      modifier = Modifier
         .padding(8.dp)
         .fillMaxWidth()
         .height(180.dp)
   ) {
      Column(modifier = Modifier.padding(8.dp)) {
         Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            val painter = rememberImagePainter(data = item.url, builder = {
               placeholder(R.drawable.sds)
               error(R.drawable.sds)
               crossfade(1000)
            })

            Image(
               painter = painter,
               contentDescription = "url",
               modifier = Modifier
                  .height(142.dp)
                  .width(142.dp)
            )
         }
         Text(
            item.title,
            style = Typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.padding(6.dp)
         )
      }
   }
}
