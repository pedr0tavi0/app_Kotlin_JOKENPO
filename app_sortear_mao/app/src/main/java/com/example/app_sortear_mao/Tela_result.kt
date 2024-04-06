package com.example.app_sortear_mao

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tela_result : AppCompatActivity() {

    lateinit var Jogador  : ImageView
    lateinit var imageViewComputador : ImageView
    lateinit var textViewResultado : TextView
    lateinit var buttonJogarNovamente : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonJogarNovamente)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         Jogador = findViewById(R.id.Jogador)
         imageViewComputador = findViewById(R.id.imageViewComputador)
         textViewResultado = findViewById(R.id.textViewResultado)
         buttonJogarNovamente = findViewById(R.id.buttonJogarNovamente)

        // Obtendo a escolha do jogador da intent
        val escolha = intent.getIntExtra("escolha", R.drawable.pedra_removebg_preview)

        // Exibindo a escolha do jogador na tela
        Jogador.setImageResource(escolha)

        // Gerando uma escolha aleatória para o computador
        val escolhaComputador = listOf(R.drawable.pedra_removebg_preview, R.drawable.papel_removebg_preview, R.drawable.tesoura_removebg_preview).random()

        // Exibindo a escolha do computador na tela
        imageViewComputador.setImageResource(escolhaComputador)

        // Obtendo e exibindo o resultado do jogo
        val resultado = getResultado(escolha, escolhaComputador)
        textViewResultado.text = resultado

        buttonJogarNovamente.setOnClickListener {
            finish() // Finaliza a atividade atual
        }
    }
    private fun getResultado(escolhaJogador: Int, escolhaComputador: Int): String {
        return when {
            escolhaJogador == escolhaComputador -> "Empate!"
            escolhaJogador == R.drawable.pedra_removebg_preview && escolhaComputador == R.drawable.tesoura_removebg_preview ||
                    escolhaJogador == R.drawable.papel_removebg_preview && escolhaComputador == R.drawable.pedra_removebg_preview ||
                    escolhaJogador == R.drawable.tesoura_removebg_preview && escolhaComputador == R.drawable.papel_removebg_preview -> "Você ganhou!"
            else -> "A máquina ganhou!"
        }
    }
}