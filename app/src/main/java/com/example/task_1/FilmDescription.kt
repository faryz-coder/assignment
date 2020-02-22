package com.example.task_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.film_description.*

class FilmDescription: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_description)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        title_film.text = title
        film_description.text = description
    }
}