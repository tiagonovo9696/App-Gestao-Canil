package com.canil.gestorcanil.ui

import android.app.AlertDialog // <-- IMPORT QUE FALTAVA
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
            onMensagem = { agendamento ->
                val input = EditText(requireContext()).apply {
                    hint = "Escreve a mensagem para ${agendamento.cliente}..."
                    setSingleLine(false)
                    maxLines = 4
                }

                val dialog = AlertDialog.Builder(requireContext())
                    .setTitle("Enviar Mensagem")
                    .setView(input)
                    .setPositiveButton("Enviar") { _, _ ->
                        val mensagem = input.text.toString().trim()
                        if (mensagem.isNotEmpty()) {
                            Toast.makeText(
                                requireContext(),
                                "Mensagem enviada para ${agendamento.cliente}: $mensagem",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "A mensagem está vazia!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .setNegativeButton("Cancelar") { dialogInterface, _ ->
                        dialogInterface.dismiss()
                    }
                    .create()

                dialog.show()
            }
        )

        binding.recyclerAgendamentos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAgendamentos.adapter = adapter

        return binding.root
    }
}
