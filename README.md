# Compose MVI Dashboard

A modern Android application demonstrating MVI (Model View Intent) architecture using Jetpack Compose, StateFlow, Retrofit, Hilt, Coroutines, and multiple API calls on a single screen.

---

# Preview

<p align="center">
  <img src="./demo.gif" width="300" />
</p>

---

# Features

- MVI Architecture
- Jetpack Compose UI
- Multiple API calls on a single screen
- Parallel API calls using Coroutines async-await
- StateFlow state management
- Retrofit networking
- Hilt Dependency Injection
- Clean and scalable project structure
- Immutable UI state updates
- Feature-based architecture

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Main programming language |
| Jetpack Compose | Modern declarative UI |
| MVI | Predictable state management |
| StateFlow | Reactive UI state updates |
| Retrofit | API networking |
| Hilt | Dependency Injection |
| Coroutines | Asynchronous operations |
| Coil | Image loading |

---

# APIs Used

This project uses free public APIs from DummyJSON.

## Products API

```text
https://dummyjson.com/products
```

Used for:
- Product banners
- Horizontal product section

---

## Categories API

```text
https://dummyjson.com/products/categories
```

Used for:
- Categories section

---

## Posts API

```text
https://dummyjson.com/posts
```

Used for:
- Feed section
- Posts listing

---

# Architecture Overview

This project follows MVI architecture.

```text
UI Action
   ↓
Intent
   ↓
ViewModel
   ↓
Repository
   ↓
API Calls
   ↓
New State
   ↓
Compose Recomposition
```

---

# Why MVI?

MVI provides:

- Single source of truth
- Predictable UI state
- Unidirectional data flow
- Better scalability for complex screens
- Easier debugging and state management

In this project, the entire Home screen is controlled using a single immutable HomeState object.

---

# Project Structure

```text
mviexample/
│
├── data/
│   ├── dto/
│   ├── mapper/
│   ├── remote/
│   └── repository/
│
├── di/
│   └── NetworkModule
│
├── domain/
│   └── model/
│       ├── categories/
│       ├── posts/
│       └── products/
│
├── presentation/
│   └── home/
│       ├── components/
│       ├── HomeIntent
│       ├── HomeScreen
│       ├── HomeState
│       └── HomeViewModel
│
├── ui/
├── MainActivity
└── MyApplication
```

---

# HomeState Example

```kotlin
data class HomeState(

    val isLoading: Boolean = false,

    val products: List<Product> = emptyList(),

    val categories: List<String> = emptyList(),

    val posts: List<Post> = emptyList(),

    val error: String? = null
)
```

The entire screen is controlled using one state object.

---

# Intent Example

```kotlin
sealed class HomeIntent {

    object LoadHomeData : HomeIntent()

    object Refresh : HomeIntent()
}
```

UI sends intents to the ViewModel instead of directly calling multiple methods.

---

# Parallel API Calls

This project uses async-await to execute multiple APIs in parallel.

```kotlin
val productsDeferred = async {
    repository.getProducts()
}

val categoriesDeferred = async {
    repository.getCategories()
}

val postsDeferred = async {
    repository.getPosts()
}
```

This improves performance because all APIs execute simultaneously.

---

# Why Repository Pattern?

Repository layer helps:

- Separate networking from UI
- Centralize API handling
- Simplify testing
- Handle DTO to Domain mapping
- Improve scalability

Flow:

```text
ViewModel
   ↓
Repository
   ↓
ApiService
```

---

# DTO to Domain Mapping

This project separates API models from UI models.

Example:

```text
ProductDto → Product
```

Benefits:

- API changes do not directly affect UI
- Cleaner architecture
- Better maintainability

---

# Setup Instructions

## Clone Repository

```bash
git clone <your_repo_url>
```

---

## Open in Android Studio

Use latest stable Android Studio.

---

## Run Project

Simply run the app.

No API key required.

---

# Future Improvements

Possible improvements:

- Pagination
- Offline caching using Room
- Search functionality
- Dark mode improvements
- Modularization
- Unit testing
- UI testing
- Pull to refresh
- Error retry handling

---

# Learning Goals

This project is useful for learning:

- MVI Architecture
- StateFlow
- Coroutines
- Parallel API calls
- Retrofit
- Hilt
- Compose state management
- Clean architecture basics

---

# License

This project is for learning and educational purposes.
