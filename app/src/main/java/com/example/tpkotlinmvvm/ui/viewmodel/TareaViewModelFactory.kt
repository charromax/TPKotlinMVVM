package com.example.tpkotlinmvvm.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.tpkotlinmvvm.DAO.TareaRepository
import java.lang.IllegalArgumentException

class TareaViewModelFactory(private val repository: TareaRepository, private val application: Application): Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TareaViewModel::class.java)) {
            return TareaViewModel(
                repository,
                application
            ) as T
        }
        throw IllegalArgumentException("View Model desconocido")
    }
}