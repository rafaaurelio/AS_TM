package com.example.as_tm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.as_tm.ui.MealScreen
import com.example.as_tm.ui.MealViewModel
import com.example.as_tm.ui.theme.AS_TMTheme


class MainActivity : ComponentActivity() {

    // Instancia a ViewModel delegando o ciclo de vida para a Activity
    private val viewModel: MealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AS_TMTheme() {
                MealScreen(viewModel = viewModel)
            }
        }
    }
}