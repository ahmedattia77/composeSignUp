package com.example.compose.screen.signUp


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.data.remot.ApiService
import com.example.compose.model.SignUp
import com.example.compose.utils.ApiStatus
import com.example.compose.utils.ExposeDropMenuStateHolder
import com.example.compose.utils.rememberExposeMenuStateHolder
import com.example.compose.utils.rememberImeState
import com.example.compose.viewmodel.RegistrationViewModel


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp2(navHostController: NavHostController){


    val content = LocalContext.current

    val data = navHostController.previousBackStackEntry?.savedStateHandle?.get<SignUp>("signUp")



    val phone = remember {
        mutableStateOf("")
    }

    val gender = remember {
        mutableStateOf("")
    }
    val dateOfBirth = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

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
            Text(text = "Step 2" , color = colorResource(id = R.color.pink))
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
            type = KeyboardType.Phone , icon = { Icon(painter = painterResource(id = R.drawable.phone) ,
                contentDescription = null) },phone)


//        textField(hint = R.string.gender,
//            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id =R.drawable.gender) ,
//                contentDescription = null) },gender)

        val gender_ = dropDown(list = listOf("male" ,"female"),
            hint =R.string.gender ,
            type = KeyboardType.Text,
            icon = { Icon(painter = painterResource(id = R.drawable.gender)
                , contentDescription = null )})


        textField(hint = R.string.date,
            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id = R.drawable.calendar) ,
                contentDescription = null) },dateOfBirth)

        textField(hint = R.string.password,
            type = KeyboardType.Text , icon = { Icon(painter = painterResource(id = R.drawable.password),
                contentDescription = null) },password)

        Button(onClick = {
//                if (phone.value.isEmpty() || gender.value.isEmpty() ||
//                    dateOfBirth.value.isEmpty() || password.value.isEmpty())
//                    Toast.makeText(content , "make sure you've enter all Fields correct",
//                        Toast.LENGTH_SHORT).show()
//                else{
//                    data?.phone = phone.value
//                    data?.gender = gender.value
//                    data?.dateOfBirth = dateOfBirth.value
//                    data?.password = password.value

//                }
        },
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField2(hint:Int, type:KeyboardType ,icon: @Composable (() -> Unit) ,
              textValue:MutableState<String>){

    var expanded by  remember {mutableStateOf(false)}

    var selectedIndex by remember {mutableStateOf("")}

    var size by remember {mutableStateOf(Size.Zero)}

    val listOfItems = listOf("Test" ,"Test" ,"Test" ,"Test" ,"Test","Test","Test","Test","Test","Test")

//    val icon = if (expanded){
//        R.drawable.arrowup
//    }else {
//        R.drawable.arrowdwon
//    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {text ->
            textValue.value = text
        },
        label = { Text(text = stringResource(id = hint)) },
        leadingIcon = icon,
        trailingIcon = icon,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = type
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .padding(horizontal = 25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.pink)
            , focusedBorderColor = Color.Gray,
            textColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
    )

}
