package com.example.tpkotlinmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tpkotlinmvvm.R
import com.example.tpkotlinmvvm.databinding.ListItemLayoutBinding
import com.example.tpkotlinmvvm.model.Tarea

class TareaListAdapter(private val theList: ArrayList<Tarea>):
    RecyclerView.Adapter<TareaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding: ListItemLayoutBinding= DataBindingUtil.inflate(layoutInflater,
            R.layout.list_item_layout,
            parent, false)
        return TareaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return theList.size
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        holder.bind(theList[position])
    }

}

class TareaViewHolder(val binding:ListItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(tarea: Tarea) {
        binding.txtAsignatura.text = tarea.titulo
        binding.txtMateria.text = tarea.materia
        binding.txtFechaEntrega.text = tarea.fechaEntrega
    }

}