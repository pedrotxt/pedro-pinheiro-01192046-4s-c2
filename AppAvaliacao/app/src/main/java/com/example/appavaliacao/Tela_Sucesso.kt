package com.example.appavaliacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Tela_Sucesso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sucesso)

        val raca = intent.getStringExtra("raca")

        val tvCachorroX:TextView = findViewById(R.id.tv_cachorrox)
        tvCachorroX.text = "Cachorro1: $raca"

        val tvCachorroY:TextView = findViewById(R.id.tv_cachorroy)
        tvCachorroY.text = "Cachorro2: $raca"
    }
}