package com.chyngyz.goratest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val Typography = Typography(

   h5 = TextStyle(
      fontFamily = font,
      fontWeight = FontWeight.Bold,
      fontSize = 24.sp,
      letterSpacing = 0.sp,
      color = SemiGray
   ),

   h6 = TextStyle(
      fontFamily = font,
      fontWeight = FontWeight.Bold,
      fontSize = 18.sp,
      letterSpacing = 0.sp,
      color = SemiGray
   ),

   body1 = TextStyle(
      fontFamily = font,
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp,
      color = SemiGray
   ),

   button = TextStyle(
      fontFamily = font,
      fontWeight = FontWeight.Bold,
      fontSize = 16.sp,
      color = Color.White,
   ),

   caption = TextStyle(
      fontFamily = font,
      fontWeight = FontWeight.Normal,
      fontSize = 14.sp,
      letterSpacing = 0.4.sp,
      color = SemiGray
   )
)