package com.example.fromtouzdemo.data.models

import com.google.gson.annotations.SerializedName

data class BodyData(
    @SerializedName("lang_from")
    val langFrom: String,
    @SerializedName("lang_to")
    val langTo: String,
    val text: String
)
