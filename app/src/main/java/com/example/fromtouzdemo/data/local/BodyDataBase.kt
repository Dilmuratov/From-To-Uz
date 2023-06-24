package com.example.fromtouzdemo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fromtouzdemo.app.App


@Database(
    entities = [Body::class],
    version = 1
)
abstract class BodyDataBase : RoomDatabase() {

    abstract fun getBodyDao(): BodyDao

    companion object {
        const val databaseName = "db_name"
    }
}