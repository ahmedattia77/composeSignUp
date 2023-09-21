package com.example.compose.composable

import android.widget.ProgressBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.TextDelegate
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Rubik

@Composable
fun signUp2(){

    val state = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = state.value){
        if (state.value){
            scrollState.animateScrollTo(scrollState.maxValue , tween(300))
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){

        logoImage()
        signUpText()
        welcomeAboardText()

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Step 2")
            Text(text = "2 of 2" , color = colorResource(id = R.color.pink))
        }
        
        Spacer(modifier = Modifier.height(12.dp))

        linearProgressBar(progressValue = 1f)

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(vertical = 16.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Mr number" , color = Color.Black , fontSize = 18.sp ,
                fontWeight = FontWeight.ExtraBold)
            Text(text = "MR 10220032" , color = Color.Black , fontSize = 16.sp)
        }

        textField(hint = R.string.phone,
            type = KeyboardType.Phone , icon = { Icon(painter = painterResource(id = R.drawable.phone) ,contentDescription = null) })

        textField(hint = R.string.gender,
            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id =R.drawable.gender) ,contentDescription = null) })

        textField(hint = R.string.date,
            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id = R.drawable.calendar) ,contentDescription = null) })

        textField(hint = R.string.password,
            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id = R.drawable.password),contentDescription = null) })

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
                .padding(horizontal = 74.dp)
        ) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.height(30.dp))
        
        Box (modifier = Modifier
            .fillMaxSize()
            .height(80.dp)
            .background(
                color = colorResource(id = R.color.pink)
            )
        ) {

            Card(modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .fillMaxWidth()
                .height(20.dp),
                shape = AbsoluteRoundedCornerShape(bottomLeft = 40.dp, bottomRight = 40.dp) ,
                colors = CardDefaults.cardColors(containerColor = Color.White)) {
            }

            Row (modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(top = 20.dp)){
                Text(
                    text = "Already have an account ? ",
                    fontSize = 16.sp,
                )
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

