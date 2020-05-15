package com.example.tpkotlinmvvm.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tpkotlinmvvm.util.Constantes
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tareas")
data class Tarea(@PrimaryKey val id : String = "",
                 @ColumnInfo(name = Constantes.COL_TITULO) val titulo : String="",
                 @ColumnInfo(name = Constantes.COL_MATERIA) val materia : String="",
                 @ColumnInfo(name = Constantes.COL_DESC) val descripcion : String="",
                 @ColumnInfo(name = Constantes.COL_FECHA_CREACION) val fechaCreacion : String="",
                 @ColumnInfo(name = Constantes.COL_FECHA_ENTREGA) val fechaEntrega : String="",
                 @ColumnInfo(name = Constantes.COL_DONE) val done : Boolean=false):Parcelable
{
}
