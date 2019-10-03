package com.example.animaldirectory.models

import android.media.MediaPlayer
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(
    var species: String,
    var category: String,
    var avgHeight: String,
    var avgWeight: String,
    var animalSound: String
) : Parcelable