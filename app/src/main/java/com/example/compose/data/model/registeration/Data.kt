package com.example.compose.data.model.registeration

data class Data(
    val allCities: List<AllCity>,
    val allCountries: List<AllCountry>,
    val allGovtIdentifiers: List<AllGovtIdentifier>,
    val allPatientCategories: List<AllPatientCategory>,
    val allSalutations: List<AllSalutation>,
    val allStates: List<AllState>,
    val return_code: String,
    val return_message: String
)