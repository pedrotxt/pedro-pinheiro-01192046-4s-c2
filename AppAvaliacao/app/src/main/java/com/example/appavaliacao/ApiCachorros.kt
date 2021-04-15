package com.example.appavaliacao

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorros {

    // Método HTTP "Get" e a URI é "/filmes"
    @GET("/cachorros")
    fun get(): Call<List<Cachorros>>
    // O retorno (corpo da resposta) desse EndPoint, em caso de sucesso é uma List de Filme

    // Método HTTP "Get" e a URI é "/cachorros/{id}"
    @GET("/cachorros/{id}")
    fun get(@Path("id") id:Int): Call<Cachorros>
    // O retorno (corpo da resposta) desse EndPoint, em caso de sucesso é um Cachorro


}