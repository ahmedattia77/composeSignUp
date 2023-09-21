package com.example.compose.ui

sealed class Screen(val route:String){
    object SignUp :Screen("signUp")
    object SignUp2 :Screen("signUp2")
}
