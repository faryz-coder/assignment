package com.example.task_1

import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        getFilm() // display film on opening

        swipeToRefresh.setOnRefreshListener { // re display when refresh initiated
            getFilm()
        }

    }
    
    // setting up function to get recall back for refresh and first time open
    private fun getFilm() {

        // set up retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllFilms().enqueue(object : Callback<List<Film>> {

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                swipeToRefresh.isRefreshing = false
                d("Faris", "onFailure")
            }

            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                swipeToRefresh.isRefreshing = false
                showData(response.body())
//                d("Faris", "onResponse ${response.body()!![0].title}")
            }

        })
    }

    private fun showData(films: List<Film>?) {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(films!!)
        }
    }
}
