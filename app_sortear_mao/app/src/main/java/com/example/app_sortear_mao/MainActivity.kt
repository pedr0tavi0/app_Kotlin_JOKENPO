package com.example.app_sortear_mao

import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var buttonPedra : ImageButton
    lateinit var buttonPapel : ImageButton
    lateinit var buttonTesoura : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonJogarNovamente)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

         buttonPedra = findViewById(R.id.buttonPedra)
         buttonPapel = findViewById(R.id.buttonPapel)
         buttonTesoura = findViewById(R.id.buttonTessoura)

        // Definindo os listeners de clique para os botões
        buttonPedra.setOnClickListener {
            startGameActivity(R.drawable.pedra_removebg_preview)
        }

        buttonPapel.setOnClickListener {
            startGameActivity(R.drawable.papel_removebg_preview)
        }

        buttonTesoura.setOnClickListener {
            startGameActivity(R.drawable.tesoura_removebg_preview)
        }


    }
    private fun startGameActivity(escolha: Int) {
        val intent = Intent(this, Tela_result::class.java)
        intent.putExtra("escolha", escolha)
        startActivity(intent)
    }




}