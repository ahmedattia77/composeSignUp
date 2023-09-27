package com.example.compose.screen.signUp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDown(list: List<String>? = null, hint:Int, type: KeyboardType, leadingIcon: @Composable (() -> Unit)) : String {
    var options = listOf("empty")

    if (list == null)
        options = listOf("empty")
    else
         options = list

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }


        Box(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 25.dp)) {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { },
                    label = { Text(stringResource(id = hint)) },
                    leadingIcon = leadingIcon,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrowdwon),
                            "contentDescription")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = colorResource(id = R.color.pink),
                        focusedBorderColor = Color.Gray,
                        textColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = type
                    ),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }, modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxWidth()
                ) {
                    options?.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(text = selectionOption) },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            })
                    }
                }
            }
        }
    return selectedOptionText
}


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passwordTextField(
    hint:Int,
    type:KeyboardType,
    leadingIcon: @Composable (() -> Unit),
    textValue: MutableState<String>,

    ) :String{

    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    OutlinedTextField(
        value = textValue.value,
        onValueChange = {text ->
            textValue.value = text
        },
        label = { Text(text = stringResource(id = hint)) },
        leadingIcon = leadingIcon,
        trailingIcon = {
            val image = if (passwordVisible)
                painterResource(id =R.drawable.visibility)
            else painterResource(id =R.drawable.visibility_off)

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(painter  = image, description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
    return textValue.value
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField(
    hint:Int, type:KeyboardType ,
    leadingIcon: @Composable (() -> Unit)
) : String{
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {text ->
            textValue.value = text
        },
        label = { Text(text = stringResource(id = hint)) },
        leadingIcon = leadingIcon,
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
    return textValue.value
}

@Composable
fun logoImage (){
    Image(
        painter = painterResource(R.drawable.signup),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 52.dp)
            .size(90.dp)
    )
}

@Composable
fun signUpText (){
    Text(
        color = Color.Black,
        fontSize = 32.sp,
        fontWeight = FontWeight.ExtraBold,
        text = "Sign Up",
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
fun welcomeAboardText (){
    Text(
        color = colorResource(id = R.color.smallText),
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        text = "Welcome Aboard",
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun linearProgressBar(progressValue :Float){
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .padding(horizontal = 24.dp),
        progress = progressValue,
        color = colorResource(id =R.color.pink ),
        trackColor = colorResource(id =R.color.pink2)
    )
}
