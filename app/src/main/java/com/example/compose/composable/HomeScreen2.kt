package com.example.compose.composable

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.TextDelegate
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Rubik

@Composable
fun signUp2(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){

        Image(painter = painterResource(R.drawable.signup),
            contentDescription = null,
            Modifier
                .padding(top = 54.dp)
                .size(90.dp))
        
            Text(text = "Sign up" ,
                fontSize = 32.sp,
                fontFamily = Rubik)

            Text(text = "Welcome A board" ,
                fontSize = 16.sp,
                color = colorResource(id = R.color.font2))

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Step 2" ,
                color = colorResource(id = R.color.pink))
            Text(text = "2 of 2" , color = colorResource(id = R.color.pink))
        }

//        Image(painter = painterResource(R.drawable.comline),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 12.dp))

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp),
            progress = 1f,
            color = colorResource(id =R.color.pink ,

             )
        )

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(top = 16.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Mr number" , color = Color.Black , fontSize = 18.sp ,
                fontFamily = Rubik)
            Text(text = "MR 10220032" , color = Color.Black , fontSize = 16.sp)
        }

        textField(hint = R.string.phone,
            type = KeyboardType.Phone , icon = { Icon(imageVector = Icons.Outlined.Phone ,contentDescription = null) })

        textField(hint = R.string.gender,
            type = KeyboardType.Text , icon = { Icon(imageVector = Icons.Outlined.Person ,contentDescription = null) })

        textField(hint = R.string.date,
            type = KeyboardType.Text , icon = { Icon(imageVector = Icons.Outlined.DateRange ,contentDescription = null) })

        textField(hint = R.string.password,
            type = KeyboardType.Text , icon = { Icon(imageVector = Icons.Outlined.Lock ,contentDescription = null) })

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
                .padding(horizontal = 74.dp)
        ) {
            Text(text = "Sign Up")
        }


        Box (modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Magenta,
                shape = AbsoluteRoundedCornerShape(bottomLeft = 25.dp, bottomRight = 25.dp)
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

