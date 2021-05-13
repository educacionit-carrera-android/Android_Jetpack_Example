package com.example.androidjetpackexample.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class OnBoarding(
    @DrawableRes val imagen: Int,
    val titulo: String,
    val descripcion: String
) : Parcelable