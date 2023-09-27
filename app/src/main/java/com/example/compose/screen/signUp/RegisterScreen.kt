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
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.compose.R
import com.example.compose.data.model.registeration.RegisterationResponse
import com.example.compose.model.SignUp
import com.example.compose.navigation.Screen
import com.example.compose.utils.ApiStatus
import com.example.compose.utils.rememberImeState
import com.example.compose.viewmodel.RegistrationViewModel

@Composable
fun performOnLifeCycle(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onCreate : () -> Unit = {})
{
    DisposableEffect(lifecycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
            when(event){
                Lifecycle.Event.ON_START -> onCreate
                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        return@DisposableEffect onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun signUp(navHostController: NavHostController ,
           lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current)
{
    val context = LocalContext.current

    var area_ :String? = null
    var city_ :String ? = null
    var patientCategory_ :String? = null
    var status_ :String? = null
    var name_ :String? = null
    var salutation_:String? = null
    var address_:String? = null

    var statusList : List<String>? = null
    var salutationList : List<String>? = null
    var patientCategoryList : List<String>? = null
    var cityList : List<String>? = null

    val viewModel: RegistrationViewModel = hiltViewModel()
    val response = viewModel.registrationFlow.collectAsState()

    performOnLifeCycle(
        lifecycleOwner = lifecycleOwner,
        onCreate = {
            Toast.makeText(context , "eny" ,Toast.LENGTH_SHORT).show()
        })

    when(response.value){
        is  ApiStatus.Loading -> {

        }
        is ApiStatus.Success -> {
            statusList = (response.value as ApiStatus.Success<RegisterationResponse>).data.data[0]
                .allStates.map { index ->
                index.state_name
            }
            cityList = (response.value as ApiStatus.Success<RegisterationResponse>).data.data[0]
                .allCities.map {index ->
                index.city_name
            }
            patientCategoryList = (response.value as ApiStatus.Success<RegisterationResponse>).data.data[0]
                .allPatientCategories.map { index ->
                index.category_name
            }
            salutationList = (response.value as ApiStatus.Success<RegisterationResponse>).data.data[0]
                .allSalutations.map { index ->
                index.salutation
            }
        }
        is ApiStatus.Failure -> {
            val errorMsg = (response.value as ApiStatus.Failure).msg.toString()
            Toast.makeText(context , errorMsg , Toast.LENGTH_SHORT).show()
        }
        is ApiStatus.Empty -> {

        }
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

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .verticalScroll(rememberScrollState())) {

                name_ = textField(hint = R.string.name,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null
                    )
                })

                salutation_ = dropDown(list = salutationList, hint = R.string.salutation_hint,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.medical),
                        contentDescription = null
                    )
                })

                patientCategory_ = dropDown(list = patientCategoryList,
                hint = R.string.patient_hint,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.medical),
                        contentDescription = null
                    )
                })


                status_ = dropDown(list = statusList,
                hint = R.string.state_hint,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null
                    )
                })

                city_ = dropDown(list = cityList, hint = R.string.city_hint,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null
                    )
                })

                 area_ = textField(hint = R.string.area_hint,
                type = KeyboardType.Text, leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null
                    )
                })

                address_ = textField(hint = R.string.address_hint,
            type = KeyboardType.Text , leadingIcon = { Icon(painter = painterResource(id = R.drawable.map),
                contentDescription = null)})
        }

        Button(onClick = {
            if (name_.isNullOrEmpty() || salutation_.isNullOrEmpty() ||
                patientCategory_.isNullOrEmpty() || status_.isNullOrEmpty() ||
                city_.isNullOrEmpty() || area_.isNullOrEmpty() || address_.isNullOrEmpty()){
                Toast.makeText(context ,"make sure you've enter all Fields " ,Toast.LENGTH_SHORT).show()
            }
            else{
                val signUp = SignUp(
                    name = name_ !!,
                    salutation = salutation_!!,
                    patientCategory = patientCategory_!!,
                    state = status_ !!,
                    city = city_ !!,
                    area = area_ !!,
                    address = address_ !!
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