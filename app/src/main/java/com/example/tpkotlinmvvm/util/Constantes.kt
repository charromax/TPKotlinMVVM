package com.example.tpkotlinmvvm.util

class Constantes {
    companion object {
        const val DB_NAME = "tpDatabase"
        const val TBL_TAREAS = "tareas"
        const val COL_TITULO = "titulo"
        const val COL_DESC = "descripcion"
        const val COL_MATERIA = "materia"
        const val COL_FECHA_CREACION = "fecha_creacion"
        const val COL_FECHA_ENTREGA = "fecha_entrega"
        const val COL_DONE = "entregada"

        const val SELECT_QUERY = "SELECT * FROM $TBL_TAREAS " +
                                 "order by $COL_FECHA_ENTREGA DESC " +
                                 "group by $COL_DONE"

        const val DELETE_ALL_QUERY = "DELETE FROM $TBL_TAREAS"
    }
}