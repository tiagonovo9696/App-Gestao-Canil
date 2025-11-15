package com.canil.gestorcanil.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.canil.gestorcanil.databinding.FragmentHomeBinding
import com.canil.gestorcanil.ui.animais.AdicionarAnimalFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Ações dos botões
        binding.btnAdicionarAnimal.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.canil.gestorcanil.R.id.fragment_container, AdicionarAnimalFragment())
                .addToBackStack(null)
                .commit()
        }



        binding.btnEditarAnimal.setOnClickListener {
            Toast.makeText(requireContext(), "Editar Animal", Toast.LENGTH_SHORT).show()
            // TODO: Aqui podes abrir uma lista de animais para editar
        }
        binding.btnApagarAnimal.setOnClickListener {
            Toast.makeText(requireContext(), "Apagar Animal", Toast.LENGTH_SHORT).show()
            // TODO: Aqui podes abrir uma lista de animais para editar
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
