package com.example.compose.screen.signUp

import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.model.SignUp
import com.example.compose.navigation.Screen
import com.example.compose.utils.rememberImeState

@Composable
fun signUp(navHostController: NavHostController){

    val content = LocalContext.current

    val fullName = remember {
            mutableStateOf("")
        }

    val salutation = remember {
            mutableStateOf("")
        }

    val patientCategory = remember {
            mutableStateOf("")
        }
    val state = remember {
            mutableStateOf("")
        }

    val city = remember {
            mutableStateOf("")
        }

    val area = remember {
            mutableStateOf("")
        }

    val booleanState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = booleanState.value){
        if (booleanState.value){
            scrollState.animateScrollTo(scrollState.maxValue , tween(300))
        }
    }

    Column (
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        logoImage()
        signUpText()
        welcomeAboardText()

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Step 1" , color = colorResource(id = R.color.pink))
            Text(text = "1 of 2" , color = colorResource(id = R.color.pink))
        }
        
        Spacer(modifier = Modifier.height(12.dp))

        linearProgressBar(progressValue = .5f)

        Spacer(modifier = Modifier.height(26.dp))


        textField(hint = R.string.name,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.profile) ,
                contentDescription = null) },fullName)

        val salutation_ = dropDown(list = listOf("salutation" , "salutation2" ,"salutation3")
            ,hint = R.string.salutation_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.medical) ,
                contentDescription = null) })

        val patientCategory_ = dropDown(list = listOf("patientCategory" ,"patientCategory2" ,"patientCategory3"),
            hint = R.string.patient_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.medical),
                contentDescription = null) })

        val state_ = dropDown(list = listOf("state1" , "state2" , "state3"),
            hint = R.string.state_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.map),
                contentDescription = null) })

        textField(hint = R.string.city_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.map),
                contentDescription = null) },city)
        textField(hint = R.string.area_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.map),
                contentDescription = null) },area)

        Button(onClick = {
            if (fullName.value.isEmpty() || salutation.value.isEmpty() ||
                patientCategory.value.isEmpty() || state.value.isEmpty() ||
                city.value.isEmpty() || area.value.isEmpty())
                Toast.makeText(content , "make sure you've enter all Fields " ,Toast.LENGTH_SHORT).show()
            else{
                val signUp = SignUp(
                    name = fullName.value,
                    salutation = salutation.value,
                    patientCategory = patientCategory.value,
                    state = state.value ,
                    city = city.value,
                    area = area.value
                )
                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "signUp",
                    value = signUp
                )
                navHostController.navigate(Screen.SignUp2.route)
            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp)
                .padding(top = 6.dp)
        ) {
            Text(text = "Next" , color = Color.White , fontSize = 16.sp)
        }

        Box (modifier = Modifier
            .fillMaxSize()
            .height(80.dp)
            .background(
                color = colorResource(id = R.color.pink),
            )
            ) {

            Card(modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .fillMaxWidth()
                .height(16.dp),
                shape =AbsoluteRoundedCornerShape(bottomLeft = 40.dp, bottomRight = 40.dp) ,
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
                    color = Color.White
                )
            }
        }
    }
}