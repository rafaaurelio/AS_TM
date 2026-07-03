package com.example.as_tm.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.as_tm.model.Meal

class MealRepository {
    private val api: MealApi = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealApi::class.java)

    suspend fun getMeals(): List<Meal> {
        val response = api.getMeals()
        // Retorna a lista convertida usando toMeal(), ou uma lista vazia caso seja nulo
        return response.meals?.map { it.toMeal() } ?: emptyList()
    }
}