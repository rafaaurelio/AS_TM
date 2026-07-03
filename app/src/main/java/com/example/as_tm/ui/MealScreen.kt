package com.example.as_tm.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealScreen(viewModel: MealViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cardápio de Receitas") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when {
                uiState.isLoading -> {
                    // Tratamento de loading
                    CircularProgressIndicator()
                }
                uiState.errorMessage != null -> {
                    // Tratamento dos erro
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = uiState.errorMessage!!,
                            color = MaterialTheme.colorScheme.error
                        )
                        Button(onClick = { viewModel.fetchMeals() }) {
                            Text("Tentar Novamente")
                        }
                    }
                }
                else -> {
                    // LazyColumn renderizando a lista
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(uiState.meals) { meal ->
                            MealCard(meal = meal)
                        }
                    }
                }
            }
        }
    }
}