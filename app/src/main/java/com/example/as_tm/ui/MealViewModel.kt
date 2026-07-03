package com.example.as_tm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.as_tm.data.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {
    private val repository = MealRepository()

    private val _uiState = MutableStateFlow(MealUiState())
    val uiState: StateFlow<MealUiState> = _uiState.asStateFlow()

    init {
        fetchMeals()
    }

    fun fetchMeals() {
        viewModelScope.launch {
            // Ativa o loading e limpa erros antigos
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            try {
                val result = repository.getMeals()
                // Desativa o loading e popula a lista
                _uiState.update { it.copy(isLoading = false, meals = result) }
            } catch (e: Exception) {
                // Em caso de erro (sem internet), exibe o erro na tela
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = "Erro ao buscar receitas: ${e.message}")
                }
            }
        }
    }
}