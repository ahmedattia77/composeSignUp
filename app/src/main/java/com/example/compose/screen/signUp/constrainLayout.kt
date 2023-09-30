package com.example.compose.screen.signUp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun constrainlayout(){

    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (button ,fab , textAhemd) = createRefs()
        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .constrainAs(button) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {}

        FloatingActionButton(onClick = {},
            modifier = Modifier
                .constrainAs(fab){
                 bottom.linkTo(parent.bottom , margin = 34.dp)
                 end.linkTo(parent.end , margin = 16.dp)
                }) {}

        Text(text = "Ahmed Attia" , modifier = Modifier.constrainAs(textAhemd){
            top.linkTo(button.bottom , margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }

}