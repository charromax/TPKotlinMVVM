package com.example.tpkotlinmvvm.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tpkotlinmvvm.model.Tarea
import com.example.tpkotlinmvvm.util.Constantes.Companion.DELETE_ALL_QUERY
import com.example.tpkotlinmvvm.util.Constantes.Companion.SELECT_QUERY

@Dao
interface TrabajoDAO {

    @Query(SELECT_QUERY)
    fun getAllTareas() : LiveData<ArrayList<Tarea>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tarea: Tarea): Long

    @Update
    suspend fun update(tarea: Tarea)

    @Delete
    suspend fun deleteTarea(tarea: Tarea)

    @Query(DELETE_ALL_QUERY)
    suspend fun deleteAllTareas()


}