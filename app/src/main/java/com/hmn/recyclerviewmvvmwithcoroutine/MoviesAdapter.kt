package com.hmn.recyclerviewmvvmwithcoroutine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hmn.recyclerviewmvvmwithcoroutine.databinding.RecyclerviewMovieBinding

class MoviesAdapter(val ctx:Context,private val movies:List<Result>,private val listener: RecyclerViewListener):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {





    inner class MoviesViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding)
        :RecyclerView.ViewHolder(recyclerviewMovieBinding.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MoviesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.recyclerview_movie,parent,false))

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.root.setOnClickListener {
            Toast.makeText(ctx,"The Whole Click",Toast.LENGTH_LONG).show()
        }
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            Toast.makeText(ctx,"Button Click",Toast.LENGTH_LONG).show()
        }

       holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
           listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.layoutLike,movies[position])
       }
        holder.recyclerviewMovieBinding.textViewRating.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.textViewRating,movies[position])
        }
    }
}