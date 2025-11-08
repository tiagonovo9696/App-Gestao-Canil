package com.canil.gestorcanil.ui.agendamentos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canil.gestorcanil.databinding.ItemAgendamentoBinding
import com.canil.gestorcanil.model.Agendamento

class AgendamentoAdapter(
    private val lista: List<Agendamento>,
    private val onAceitar: (Agendamento) -> Unit,
    private val onRecusar: (Agendamento) -> Unit,
    private val onMensagem: (Agendamento) -> Unit
) : RecyclerView.Adapter<AgendamentoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAgendamentoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAgendamentoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        with(holder.binding) {
            tvCliente.text = item.cliente
            tvEmail.text = item.email
            tvTelefone.text = item.telefone
            tvDataHora.text = item.dataHora

            btnAceitar.setOnClickListener { onAceitar(item) }
            btnRecusar.setOnClickListener { onRecusar(item) }
            btnMensagem.setOnClickListener { onMensagem(item) }
        }
    }

    override fun getItemCount() = lista.size
}
