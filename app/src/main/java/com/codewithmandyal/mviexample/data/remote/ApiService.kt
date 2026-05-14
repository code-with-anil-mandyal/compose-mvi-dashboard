package com.codewithmandyal.mviexample.data.remote

import com.codewithmandyal.mviexample.data.dto.categories.CategoryResponseItem
import com.codewithmandyal.mviexample.data.dto.posts.PostResponseDto
import com.codewithmandyal.mviexample.data.dto.products.ProductsResponseDto
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductsResponseDto

    @GET("products/categories")
    suspend fun getCategories(): List<CategoryResponseItem>

    @GET("posts")
    suspend fun getPosts(): PostResponseDto
}