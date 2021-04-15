package com.example.appavaliacao

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var preferencias: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
        fun comprar(view: View) {
            val apiCachorros = ConexaoApiCachorros.criar()

            val etId: EditText = findViewById(R.id.et_id1)
            val etId2: EditText = findViewById(R.id.et_id2)
            val id = etId.text.toString().toInt()
            val id2 = etId2.text.toString().toInt()

            val edit = preferencias.edit()

            apiCachorros.get(id).enqueue(object : Callback<Cachorros> {
                override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                    val etCachorro1: TextView = findViewById(R.id.tv_descricao)
                    val cachorros = response.body()
                    if (cachorros != null) {
                        //edit.putString("raca", etCachorro1.text.toString())
                        //edit.commit()
                        etCachorro1.text = "Cachorro1: ${cachorros.raca}"
                    } else {
                        etCachorro1.text = "Id não encontrado!!!"
                    }
                }

                override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
                }
            })

            apiCachorros.get(id2).enqueue(object : Callback<Cachorros> {
                override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                    val etCachorro2: TextView = findViewById(R.id.tv_descricao2)
                    val cachorros = response.body()
                    if (cachorros != null) {
                        //edit.putString("raca", etCachorro2.text.toString())
                        //edit.commit()
                        etCachorro2.text = "Cachorro1: ${cachorros.raca}"
                    } else {
                        etCachorro2.text = "Id não encontrado!!!"
                    }
                }

                override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
                }
            })

            val tela2 = Intent(this, Tela_Sucesso::class.java)
            tela2.putExtra("raca", etId.text.toString())
            tela2.putExtra("raca", etId2.text.toString())
            startActivity(tela2)
        }

    }