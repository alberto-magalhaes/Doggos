package com.albertomagalhaes.doggos.data.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(breedList: List<BreedModel>)

    @Query("SELECT * FROM table_breed ORDER BY name ASC")
    fun getAll(): Flow<List<BreedModel>>

    @Query("SELECT * FROM table_breed WHERE id = :id LIMIT 1")
    fun get(id: String): Flow<BreedModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(breed: BreedModel)

    @Update
    suspend fun update(breed: BreedModel)

}