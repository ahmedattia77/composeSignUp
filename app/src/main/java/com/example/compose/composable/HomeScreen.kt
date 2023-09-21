package com.example.compose.composable

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.ui.Screen

@Composable
fun signUp(navHostController: NavHostController){

    val state = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = state.value){
        if (state.value){
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
        verticalArrangement = Arrangement.Top
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
            type = KeyboardType.Email ,icon = { Icon(painter = painterResource(id = R.drawable.profile) ,
                contentDescription = null) })

        textField(hint = R.string.salutation_hint,
            type = KeyboardType.Email ,icon = { Icon(painter = painterResource(id = R.drawable.medical) ,
                contentDescription = null) })

        textField(hint = R.string.patient_hint,
            type = KeyboardType.Email , icon = { Icon(painter = painterResource(id = R.drawable.medical),contentDescription = null) })
        textField(hint = R.string.state_hint,
            type = KeyboardType.Email , icon = { Icon(painter = painterResource(id = R.drawable.map),contentDescription = null) })
        textField(hint = R.string.city_hint,
            type = KeyboardType.Email , icon = { Icon(painter = painterResource(id = R.drawable.map),contentDescription = null) })
        textField(hint = R.string.area_hint,
            type = KeyboardType.Email , icon = { Icon(painter = painterResource(id = R.drawable.map),contentDescription = null) })
        
        Button(onClick = {
              navHostController.navigate(route = Screen.SignUp2.route)
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
            .fillMaxSize().height(80.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField(hint:Int, type:KeyboardType ,icon: @Composable (() -> Unit)){

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {text ->
            textValue.value = text
        },
        label = { Text(text = stringResource(id = hint)) },
        leadingIcon = icon,
        keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = type
        ) ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .padding(horizontal = 25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Magenta
            , focusedBorderColor = Color.Gray
        ),
        shape = RoundedCornerShape(12.dp)
        )
}

@Composable
fun isExpanded(){
    val isExpanded = remember {
        mutableStateOf(false)
    }

    val gender = remember {
        mutableStateOf("")
    }
//
//    ExposedDropdownMenuBox(expanded = , onExpandedChange = ) {
//
//    }


}


@Composable
fun logoImage (){
    Image(
        painter = painterResource(R.drawable.signup),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 52.dp)
            .size(90.dp)
    )
}


@Composable
fun signUpText (){
    Text(
        color = Color.Black,
        fontSize = 32.sp,
//        fontFamily = Rubik,
        fontWeight = FontWeight.ExtraBold,
        text = "Sign Up",
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
fun welcomeAboardText (){
    Text(
        color = colorResource(id = R.color.smallText),
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        text = "Welcome Aboard",
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun linearProgressBar(progressValue :Float){
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .padding(horizontal = 24.dp),
        progress = progressValue,
        color = colorResource(id =R.color.pink ),
        trackColor = colorResource(id =R.color.pink2)
    )
}