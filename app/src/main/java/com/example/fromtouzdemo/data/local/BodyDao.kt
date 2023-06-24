package com.example.fromtouzdemo.data.local

import androidx.room.*

@Dao
interface BodyDao {

    @Query("SELECT * from body")
    suspend fun getAllBodies(): MutableList<Body>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBody(body: Body)

    @Delete
    suspend fun deleteBody(body: Body)
}