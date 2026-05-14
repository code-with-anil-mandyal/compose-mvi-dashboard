package com.codewithmandyal.mviexample.data.repository

import com.codewithmandyal.mviexample.data.mapper.toDomain
import com.codewithmandyal.mviexample.data.remote.ApiService
import com.codewithmandyal.mviexample.domain.model.categories.Category
import com.codewithmandyal.mviexample.domain.model.posts.Posts
import com.codewithmandyal.mviexample.domain.model.products.Product
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getProducts(): List<Product>{
        return apiService.getProducts().products?.map {
            it.toDomain()
        }?: emptyList()
    }

    suspend fun getCategories(): List<Category>{
        return apiService.getCategories().map {
            it.toDomain()
        }
    }


    suspend fun getPosts(): List<Posts>{
        return apiService.getPosts().posts?.map {
            it.toDomain()
        }?:emptyList()
    }


}