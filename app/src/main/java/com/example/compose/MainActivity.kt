package com.example.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.data.model.Person
import com.example.compose.navigation.setUpNavGraph
import com.example.compose.screen.signUp.constrainlayout
import com.example.compose.screen.signUp.lazyColum
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.viewmodel.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme{
                Scaffold {
                    val navController = rememberNavController()
                    setUpNavGraph(navHostController = navController)
                }
            }
        }

    }
}
