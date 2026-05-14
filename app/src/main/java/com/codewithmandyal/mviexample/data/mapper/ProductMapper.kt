package com.codewithmandyal.mviexample.data.mapper


import com.codewithmandyal.mviexample.data.dto.products.ProductDto
import com.codewithmandyal.mviexample.domain.model.products.Product

fun ProductDto.toDomain() : Product {
   return Product(
        id = id?:0,
       name = title?:"",
       image = images?.get(0) ?: ""
    )
}