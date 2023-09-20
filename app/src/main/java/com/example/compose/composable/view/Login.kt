package com.example.compose.composable.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Rubik


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login (){
    val context = LocalContext.current
    val scaffoldState = "rememberScaffoldState()"
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
    {
        Image(
            painter = painterResource(id = R.drawable.prinse),
            contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),

        )

        Text(text = "Login",
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = Rubik,
            )


//        OutlinedTextField(
//            value = email.value,
//            onValueChange = {text ->
//                email.value = text
//            },
//            label =  Text("King's name") ,
//            leadingIcon = Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null),
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Text
//            ) ,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 4.dp)
//                .padding(horizontal = 25.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedLabelColor = Color.Magenta
//                , focusedBorderColor = Color.Gray
//            )
//        )
    }

}
