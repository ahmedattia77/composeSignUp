package com.example.compose.screen.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.data.model.Person
import com.example.compose.data.model.registeration.RegisterationResponse
import com.example.compose.utils.ApiStatus
import com.example.compose.viewmodel.RegistrationViewModel


@Composable
fun lazyColum(){

    val viewModel :RegistrationViewModel = hiltViewModel()
    val response = viewModel.registrationFlow.collectAsState()
    var list :List<String>? = null
    when(response.value){
        is ApiStatus.Success -> {
         list = (response.value as ApiStatus.Success<RegisterationResponse>).data.data[0].allCities.map {
             it.city_name
         }
        }
        is ApiStatus.Failure -> {

        }
        is ApiStatus.Loading -> {

        }
        is ApiStatus.Empty -> {

        }
    }

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)){
        if (list == null || list!!.isEmpty() ){
            list = listOf("Loading")
        }
        itemsIndexed(list!! ){index,item ->
            val size:TextUnit = if (index % 2 == 0) 16.sp else 18.sp
            val color:Color = if (index % 2 == 0) Color.White else Color.Red
            CustomItem2(item = item , size = size , color = color)
        }
    }
}


@Composable
fun CustomItem(person: Person){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)) {
        Text(text = person.name,
            fontSize = 18.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold)

        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            Text(text = person.address , fontSize = 16.sp , color = Color.White)
            Text(text = person.jopTitle , fontSize = 16.sp , color = Color.White)
            Text(text = person.age.toString(), fontSize = 16.sp , color = Color.White)
        }
    }
}

@Composable
fun CustomItem2(item:String , size:TextUnit ,color: Color){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()) {
        Text(text = item,
            fontSize = size,
            color = color,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp))
    }
}