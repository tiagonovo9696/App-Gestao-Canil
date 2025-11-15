package com.canil.gestorcanil.ui.animais

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.canil.gestorcanil.databinding.FragmentAdicionarAnimalBinding

class AdicionarAnimalFragment : Fragment() {

    private var _binding: FragmentAdicionarAnimalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdicionarAnimalBinding.inflate(inflater, container, false)

        // Botão de upload (por agora apenas Toast)
        binding.btnUploadImagem.setOnClickListener {
            Toast.makeText(requireContext(), "Upload de imagem (futuro)", Toast.LENGTH_SHORT).show()
        }

        // Botão de guardar (por agora apenas Toast)
        binding.btnGuardarAnimal.setOnClickListener {
            Toast.makeText(requireContext(), "Animal guardado (simulação)", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
