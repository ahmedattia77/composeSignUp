package com.example.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.model.SignUp
import com.example.compose.screen.signUp.signUp
import com.example.compose.screen.signUp.signUp2
import com.example.compose.viewmodel.RegistrationViewModel

@Composable
fun setUpNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController,
        startDestination = Screen.SignUp.route
    ){
        composable(route = Screen.SignUp.route){
            signUp(navHostController)
        }
        composable(route = Screen.SignUp2.route){
            val result =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<SignUp>("signUp")
            signUp2(navHostController)
        }
    }
}