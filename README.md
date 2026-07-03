# 🍲 Cardápio de Receitas - Android App

![Status do Projeto](https://img.shields.io/badge/Status-Concluído-success)
![Linguagem](https://img.shields.io/badge/Linguagem-Kotlin-purple)
![UI](https://img.shields.io/badge/UI-Jetpack_Compose-blue)

## 📱 Sobre o Projeto
Este projeto foi desenvolvido como **Avaliação Semestral (AS)**. O objetivo principal é criar um aplicativo Android nativo, com tela única, capaz de consumir uma API REST pública e exibir os dados em uma lista fluida, aplicando conceitos modernos de desenvolvimento mobile.

Para este projeto, escolhemos o tema de Culinária, consumindo a API pública **[TheMealDB](https://www.themealdb.com/api.php)** para listar diversas receitas.

## ✨ Funcionalidades
* **Consumo de API REST** para busca de dados em tempo real.
* **Gerenciamento de Estado de UI (UiState)** completo, tratando três cenários:
  * ⏳ Carregamento (*Loading*).
  * ❌ Falha na conexão (*Erro* com botão de tentar novamente).
  * ✅ Sucesso (Exibição da lista).
* **Carregamento Assíncrono de Imagens**, garantindo que a rolagem da tela não trave enquanto as fotos dos pratos são baixadas.
* **Interface Reativa e Declarativa** construída 100% com código Kotlin.

## 🛠️ Tecnologias Utilizadas
O aplicativo foi construído utilizando o que há de mais moderno no ecossistema Android:
* **[Kotlin](https://kotlinlang.org/):** Linguagem de programação oficial.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Kit de ferramentas moderno para construção de UI nativa.
* **[Retrofit 2](https://square.github.io/retrofit/):** Cliente HTTP type-safe para Android.
* **[Gson](https://github.com/google/gson):** Biblioteca para conversão de objetos Java/Kotlin para JSON e vice-versa.
* **[Coil](https://coil-kt.github.io/coil/compose/):** Biblioteca de carregamento de imagens rápida, leve e otimizada para Kotlin e Compose.
* **ViewModel & StateFlow:** Para gerenciamento de estado e sobrevivência a mudanças de configuração (como rotação de tela).

## 🏗️ Arquitetura do Projeto
O projeto foi estruturado seguindo o padrão **MVVM (Model-View-ViewModel)**, garantindo a separação de responsabilidades. O código está dividido nos seguintes pacotes:

* `model/`: Contém a entidade de domínio (`Meal`), limpa e voltada apenas para o que a interface precisa.
* `data/`: Responsável pela camada de dados. Contém a interface do Retrofit (`MealApi`), o espelho do JSON (`MealResponse`) e o Repositório (`MealRepository`) que gerencia a chamada de rede.
* `ui/`: Contém a lógica de apresentação e a interface gráfica. Abriga a `MealViewModel`, a classe de estado `MealUiState`, e os componentes visuais (`MealScreen` e `MealCard`).
