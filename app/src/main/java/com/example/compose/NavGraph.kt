package com.example.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.composable.signUp
import com.example.compose.composable.signUp2
import com.example.compose.ui.Screen

@Composable
fun setUpNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = Screen.SignUp.route ){
        composable(route = Screen.SignUp.route){
            signUp(navHostController)
        }
        composable(route = Screen.SignUp2.route){
            signUp2()
        }
    }
}