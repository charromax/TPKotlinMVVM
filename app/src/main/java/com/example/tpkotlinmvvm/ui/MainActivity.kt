package com.example.tpkotlinmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tpkotlinmvvm.DAO.TareaRepository
import com.example.tpkotlinmvvm.DAO.TareasPendientsDB
import com.example.tpkotlinmvvm.R
import com.example.tpkotlinmvvm.databinding.MainactivityBinding
import com.example.tpkotlinmvvm.ui.viewmodel.TareaViewModel
import com.example.tpkotlinmvvm.ui.viewmodel.TareaViewModelFactory
import com.example.tpkotlinmvvm.util.Constantes.Companion.DB_NAME

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainactivityBinding
    private lateinit var tareaViewModel: TareaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mainactivity)

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

        mostrarTareasList()

        val fab: View= findViewById(R.id.addTareaFab)
        fab.setOnClickListener(View.OnClickListener {
            intent= Intent(application, AgregarTarea::class.java)
            startActivity(intent)
        }
        )

    }


    private fun mostrarTareasList(){
        binding.listTareas.layoutManager = LinearLayoutManager(this)
        tareaViewModel.listaDeTareas.observe(this, Observer {
            Log.i(DB_NAME, it.toString())
            binding.listTareas.adapter= TareaListAdapter(it)
        })
    }
}
