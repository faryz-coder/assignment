package com.example.task_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.film_row.view.*

class UsersAdapter(private val films: List<Film>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = films.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film = films[position]
        holder.filmName.text = film.title
        holder.filmYear.text = "Year: "+film.release_date
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmName: TextView = itemView.filmName
        val filmYear: TextView = itemView.filmYear
    }

}
