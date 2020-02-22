package com.example.task_1

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/films")
    fun fetchAllFilms(): Call<List<Film>>
}