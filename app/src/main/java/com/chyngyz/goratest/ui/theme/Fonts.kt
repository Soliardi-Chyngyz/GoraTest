package com.chyngyz.goratest.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.chyngyz.goratest.R

val font = FontFamily(
   Font(R.font.ss_regular),
   Font(R.font.ss_bold, weight = FontWeight.Bold),
   Font(R.font.ss_semibold, weight = FontWeight.SemiBold),
   Font(R.font.ss_light, weight = FontWeight.Light),
   Font(R.font.ss_medium, weight = FontWeight.Medium)
)