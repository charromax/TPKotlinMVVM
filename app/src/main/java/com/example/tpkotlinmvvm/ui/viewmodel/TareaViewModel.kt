package com.example.tpkotlinmvvm.ui.viewmodel

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tpkotlinmvvm.DAO.TareaRepository
import com.example.tpkotlinmvvm.model.Tarea
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class TareaViewModel(private val repository: TareaRepository, application: Application): AndroidViewModel(application), Observable {

    val listaDeTareas = repository.tareas

    @Bindable
    val inputTitulo = MutableLiveData<String>()
    @Bindable
    val inputFechaEntrega = MutableLiveData<String>()
    @Bindable
    val inputDescripcion = MutableLiveData<String>()
    @Bindable
    val inputMateria = MutableLiveData<String>()

    val clicksListener = object: OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            inputMateria.value = p0?.getItemAtPosition(p2) as String
        }

    }

    fun saveTarea() {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val titulo = inputTitulo.value!!
        val materia = inputMateria.value!!
        val fechaEntrega = inputFechaEntrega.value!!
        val descripcion = inputDescripcion.value!!
        val fechaCreacion = sdf.format(Date())
        val done = false

        insert(Tarea(
            UUID.randomUUID().toString(),
            titulo,
            materia,
            descripcion,
            fechaCreacion,
            fechaEntrega,
            done
        ))
        inputTitulo.value = null
        inputMateria.value = null
        inputFechaEntrega.value = null
        inputDescripcion.value = null
    }

    fun insert(tarea: Tarea) = viewModelScope.launch{
            repository.insert(tarea)
        }
    fun update(tarea: Tarea) = viewModelScope.launch{
        repository.update(tarea)
    }
    fun delete(tarea: Tarea) = viewModelScope.launch{
        repository.deleteOne(tarea)
    }
    fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}