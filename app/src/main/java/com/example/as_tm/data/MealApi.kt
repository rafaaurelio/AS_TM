package com.example.as_tm.data

import retrofit2.http.GET

interface MealApi {
    @GET("search.php?s=") // Busca receitas aleatórias/gerais pra nossa api
    suspend fun getMeals(): MealApiResponse
}