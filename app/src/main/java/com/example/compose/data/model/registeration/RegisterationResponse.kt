package com.example.compose.data.model.registeration

data class RegisterationResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Boolean
)