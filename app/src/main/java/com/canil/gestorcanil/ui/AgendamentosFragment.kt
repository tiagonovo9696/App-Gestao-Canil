package com.canil.gestorcanil.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.canil.gestorcanil.databinding.FragmentAgendamentosBinding
import com.canil.gestorcanil.model.Agendamento
import com.canil.gestorcanil.ui.agendamentos.AgendamentoAdapter

class AgendamentosFragment : Fragment() {

    private lateinit var binding: FragmentAgendamentosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgendamentosBinding.inflate(inflater, container, false)

        val listaFalsa = listOf(
            Agendamento(1, "Maria Silva", "maria@exemplo.com", "912345678", "10/11/2025 - 10h"),
            Agendamento(2, "João Costa", "joao@exemplo.com", "934567890", "11/11/2025 - 15h")
        )

        val adapter = AgendamentoAdapter(
            listaFalsa,
            onAceitar = {
                Toast.makeText(
                    requireContext(),
                    "Aceite: ${it.cliente}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onRecusar = {
                Toast.makeText(
                    requireContext(),
                    "Recusado: ${it.cliente}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onMensagem = {
                Toast.makeText(
                    requireContext(),
                    "Mensagem a: ${it.cliente}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )

        binding.recyclerAgendamentos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAgendamentos.adapter = adapter

        return binding.root
    }
}
