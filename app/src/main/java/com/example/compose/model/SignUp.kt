package com.example.compose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SignUp(
    val name:String,
    val salutation:String,
    val patientCategory:String,
    val state:String,
    val city:String,
    val area:String,
    var address:String,
    var phone:String?=null,
    var gender:String?= null,
    var dateOfBirth:String?=null,
    var password:String?=null,
): Parcelable