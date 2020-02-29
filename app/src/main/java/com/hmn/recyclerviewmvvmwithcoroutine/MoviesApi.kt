package com.hmn.recyclerviewmvvmwithcoroutine

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {
@GET("popular?api_key=c11dcb567483000f07d05199bf19ef01")
suspend fun getMovies():Response<Movies>

    companion object{
        operator fun invoke():MoviesApi{
            val gson = GsonBuilder().setLenient().create()
            val okCli = OkHttpClient.Builder()
            val inteceptor = HttpLoggingInterceptor()
            inteceptor.level = HttpLoggingInterceptor.Level.BODY
            okCli.interceptors().add(inteceptor)
            val okclient =okCli.build()
            return Retrofit.Builder().client(okclient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}