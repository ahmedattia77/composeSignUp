package com.example.compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.navigation.setUpNavGraph
import com.example.compose.screen.signUp.dropDown
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.viewmodel.RegistrationViewModel

class MainActivity : ComponentActivity() {

    lateinit var navController:NavHostController
    private val viewModel :RegistrationViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme{
                navController = rememberNavController()
                setUpNavGraph(navHostController = navController)
            }
        }

    }
}