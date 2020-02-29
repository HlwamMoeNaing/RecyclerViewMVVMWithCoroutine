package com.hmn.recyclerviewmvvmwithcoroutine

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(),RecyclerViewListener {

private lateinit var viewModel:MoviesViewModel
private lateinit var factory:ViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository = MoviesRepository(api)
        factory = ViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer {movies->
            val data = movies.results
            recyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(activity!!,data,this)
            }

        })
    }

    override fun onRecyclerViewItemClick(view: View, result: Result) {
       when(view.id){
           R.id.textViewRating->{
               Toast.makeText(requireContext(),"TV Rating Click",Toast.LENGTH_LONG).show()
           }
           R.id.layout_like->{
               Toast.makeText(requireContext(),"TV Like Click",Toast.LENGTH_LONG).show()
           }
       }
    }

}
