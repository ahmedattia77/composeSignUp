package com.example.compose.composable.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.composable.linearProgressBar
import com.example.compose.composable.logoImage
import com.example.compose.composable.signUpText
import com.example.compose.composable.textField
import com.example.compose.composable.welcomeAboardText


@Composable
fun test1() {

    Card(modifier = Modifier
        .fillMaxSize(),
        shape =AbsoluteRoundedCornerShape(bottomLeft = 40.dp, bottomRight = 40.dp) ,
        colors = CardDefaults.cardColors(containerColor = Color.White)) {

        Text(text = "Ahmed Attia" , fontSize = 18.sp , color = Color.Black)
        Text(text = "Ahmed Attia" , fontSize = 18.sp , color = Color.Black)
        Text(text = "Ahmed Attia" , fontSize = 18.sp , color = Color.Black)
    }

}
