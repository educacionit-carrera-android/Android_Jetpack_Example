package com.example.androidjetpackexample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Libro(
    val nombre: String,
    val autor: String
) : Parcelable