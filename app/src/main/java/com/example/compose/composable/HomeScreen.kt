package com.example.compose.composable



import android.graphics.drawable.Icon
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
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

@Composable
fun HomeScreen(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        logoImage()
        signUpText()
        welcomeAboardText()
        textField(hint = R.string.email_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.Email ,contentDescription = null) })
        textField(hint = R.string.state_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.AddCircle ,contentDescription = null) })
        textField(hint = R.string.patient_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.AddCircle ,contentDescription = null) })
        textField(hint = R.string.state_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.AddCircle ,contentDescription = null) })
        textField(hint = R.string.city_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.LocationOn ,contentDescription = null) })
        textField(hint = R.string.area_hint,
            type = KeyboardType.Email , icon = { Icon(imageVector = Icons.Outlined.LocationOn ,contentDescription = null) })
        
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp)
                .padding(top = 16.dp),
        ) {
            Text(text = "Next" , color = Color.White , fontSize = 16.sp)
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
                shape =AbsoluteRoundedCornerShape(bottomLeft = 40.dp, bottomRight = 40.dp) ,
                colors = CardDefaults.cardColors(containerColor = Color.White)) {
            }

            Row (modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(top = 40.dp)){
                Text(
                    text = "Already have an account ? ",
                    fontSize = 16.sp,
                )
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                )
            }
        }

    }
}

@Composable
fun text (text:String){
    Text(text = text,
        fontSize = 18.sp,
        color = Color.Red
    )
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
            .padding(top = 12.dp)
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Magenta
            , focusedBorderColor = Color.Gray
        )
        )
}

@Composable
fun logoImage (){
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 20.dp)
            .size(90.dp)
    )
}

@Composable
fun background (){
    Image(
        painter = painterResource(R.drawable.curved_background),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 20.dp)
    )
}

@Composable
fun signUpText (){
    Text(
        color = Color.Black,
        fontSize = 24.sp,
        fontFamily = FontFamily.Monospace,
        text = "Sign up",
        modifier = Modifier.padding(6.dp)
    )
}

@Composable
fun welcomeAboardText (){
    Text(
        color = Color.Gray,
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        text = "Welcome Aboard",
        modifier = Modifier.padding(4.dp)
    )
}