package com.demo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.demo.database.base.db.BaseDao
import com.demo.database.model.MarvelCharacterDB
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharacterDao : BaseDao<MarvelCharacterDB> {

    @Query("SELECT * FROM MARVEL_CHARACTER")
    suspend fun getAllCharacters() : List<MarvelCharacterDB>

    @Query("SELECT * FROM MARVEL_CHARACTER")
    fun liveCharacters(): LiveData<List<MarvelCharacterDB>>

    @Query("SELECT * FROM MARVEL_CHARACTER")
    fun flowCharacters(): Flow<List<MarvelCharacterDB>>

    @Query("SELECT * FROM MARVEL_CHARACTER WHERE ID = :id")
    fun flowCharacterById(id : String): Flow<List<MarvelCharacterDB>>

    @Query("DELETE FROM MARVEL_CHARACTER")
    suspend fun nuke()

}