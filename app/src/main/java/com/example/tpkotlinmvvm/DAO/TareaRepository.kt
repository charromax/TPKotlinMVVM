package com.example.tpkotlinmvvm.DAO

import com.example.tpkotlinmvvm.model.Tarea

class TareaRepository(private val dao: TrabajoDAO) {

    val tareas = dao.getAllTareas()

    suspend fun insert(tarea: Tarea) {
        dao.insert(tarea)
    }

    suspend fun update(tarea: Tarea) {
        dao.update(tarea)
    }

    suspend fun deleteAll() {
        dao.deleteAllTareas()
    }

    suspend fun deleteOne(tarea: Tarea) {
        dao.deleteTarea(tarea)
    }

}