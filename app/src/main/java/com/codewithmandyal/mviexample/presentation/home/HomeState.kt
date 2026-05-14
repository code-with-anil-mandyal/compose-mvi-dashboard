package com.codewithmandyal.mviexample.presentation.home

import com.codewithmandyal.mviexample.domain.model.categories.Category
import com.codewithmandyal.mviexample.domain.model.posts.Posts
import com.codewithmandyal.mviexample.domain.model.products.Product



data class HomeState(

    val isLoading: Boolean = false,

    val products: List<Product> = emptyList(),

    val categories: List<Category> = emptyList(),

    val posts: List<Posts> = emptyList(),

    val error: String? = null
)