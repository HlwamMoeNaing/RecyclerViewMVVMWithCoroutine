package com.hmn.recyclerviewmvvmwithcoroutine

class MoviesRepository(
    private val api:MoviesApi
):SafeApiRequest() {
    suspend fun getMovies() =apiRequest { api.getMovies() }
}