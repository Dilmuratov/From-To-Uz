package com.example.fromtouzdemo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "body")
data class Body(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val langFrom: String,
    val langTo: String,
    val text: String
)
