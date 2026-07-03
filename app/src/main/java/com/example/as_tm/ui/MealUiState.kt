package com.example.as_tm.ui

import com.example.as_tm.model.Meal

data class MealUiState(
    val isLoading: Boolean = false,
    val meals: List<Meal> = emptyList(),
    val errorMessage: String? = null
)
