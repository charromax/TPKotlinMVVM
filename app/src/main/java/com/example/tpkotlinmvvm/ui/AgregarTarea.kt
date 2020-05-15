package com.example.tpkotlinmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tpkotlinmvvm.DAO.TareaRepository
import com.example.tpkotlinmvvm.DAO.TareasPendientsDB
import com.example.tpkotlinmvvm.R
import com.example.tpkotlinmvvm.databinding.ActivityAgregarTareaBinding
import com.example.tpkotlinmvvm.ui.viewmodel.TareaViewModel
import com.example.tpkotlinmvvm.ui.viewmodel.TareaViewModelFactory

class AgregarTarea : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarTareaBinding
    private lateinit var tareaViewModel: TareaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agregar_tarea)

        val dao= TareasPendientsDB.getInstance(application).trabajoDAO()
        val repository= TareaRepository(dao)
        val factory =
            TareaViewModelFactory(
                repository,
                application
            )
        tareaViewModel = ViewModelProvider(this, factory).get(TareaViewModel::class.java)

        binding.myViewModel = tareaViewModel
        binding.lifecycleOwner= this

    }


}
