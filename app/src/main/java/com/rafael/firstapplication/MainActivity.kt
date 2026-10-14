package com.rafael.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declaração do ViewBinding para acessar os componentes do layout XML
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o ViewBinding e define a visualização raiz da tela
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        // Ajusta o espaçamento da tela para respeitar as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências aos campos de e-mail, senha e ao botão via ViewBinding
        val editTextEmail = binding.editText
        val editTextSenha = binding.editTextSenha
        val button = binding.button

        // Configura o evento de clique do botão "Entrar"
        button.setOnClickListener {
            // Obtém os textos digitados nos campos de e-mail e senha
            val emailDigitado = editTextEmail.text.toString()
            val senhaDigitada = editTextSenha.text.toString()

            // Formata a mensagem no padrão solicitado pelo exercício
            val mensagem = "Email: $emailDigitado\nSenha: $senhaDigitada"

            // Cria e exibe o Toast na tela com as informações preenchidas
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }
}
