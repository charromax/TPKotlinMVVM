package com.example.tpkotlinmvvm.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tpkotlinmvvm.model.Tarea
import com.example.tpkotlinmvvm.util.Constantes.Companion.DB_NAME

@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareasPendientsDB : RoomDatabase() {
    abstract fun trabajoDAO(): TrabajoDAO

    companion object {
        @Volatile // <---- hace que INSTANCE sea visible en todos los hilos
        private var INSTANCE: TareasPendientsDB? = null

        fun getInstance(context: Context): TareasPendientsDB{


            synchronized(this){          //<-------- chequear que NO se importe de coroutines api
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext,
                                                    TareasPendientsDB::class.java,
                                                    DB_NAME).build()

                }
                return instance
            }
        }
    }
}