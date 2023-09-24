package com.example.compose.navigation

sealed class Screen(val route:String){
    object SignUp : Screen("signUp")
    object SignUp2 : Screen("signUp2")
}
