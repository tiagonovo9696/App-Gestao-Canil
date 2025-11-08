package com.canil.gestorcanil

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.canil.gestorcanil.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Ligação ao layout via ViewBinding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // “Infla” o layout XML (activity_login.xml)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔹 Botão de login (temporariamente comentado até API estar pronta)
        binding.btnLogin.setOnClickListener {
            // ---------------------------------------------
            // 🚧 Código de login temporariamente desativado
            // ---------------------------------------------
            // val email = binding.etEmail.text.toString().trim()
            // val password = binding.etPassword.text.toString().trim()
            //
            // if (email.isEmpty() || password.isEmpty()) {
            //     Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            //     return@setOnClickListener
            // }
            //
            // val url = "https://teu_dominio.com/api/login.php" // TODO: substituir mais tarde
            //
            // val params = HashMap<String, String>()
            // params["email"] = email
            // params["password"] = password
            //
            // val request = object : StringRequest(
            //     Method.POST, url,
            //     { response ->
            //         if (response.contains("success")) {
            //             Toast.makeText(this, "Login efetuado!", Toast.LENGTH_SHORT).show()
            //
            //             // Guardar dados do utilizador
            //             val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            //             val editor = sharedPref.edit()
            //             editor.putString("email", email)
            //             editor.putString("cargo", "admin") // valor retornado pela API
            //             editor.apply()
            //
            //             startActivity(Intent(this, MainActivity::class.java))
            //             finish()
            //         } else {
            //             Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            //         }
            //     },
            //     { error ->
            //         Toast.makeText(this, "Erro: ${error.message}", Toast.LENGTH_SHORT).show()
            //     }) {
            //     override fun getParams(): MutableMap<String, String> = params
            // }
            //
            // // Enviar pedido para o servidor
            // VolleySingleton.getInstance(this).addToRequestQueue(request)
            // ---------------------------------------------
            // 🚧 Fim do código temporariamente desativado
            // ---------------------------------------------

            // Apenas mensagem visual temporária
            Toast.makeText(this, "Login desativado (modo layout)", Toast.LENGTH_SHORT).show()
        }

        // 🔹 Botão de TESTE LOGIN (avança sem verificar credenciais)
        binding.btnTestLogin.setOnClickListener {
            Toast.makeText(this, "Login simulado!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}
