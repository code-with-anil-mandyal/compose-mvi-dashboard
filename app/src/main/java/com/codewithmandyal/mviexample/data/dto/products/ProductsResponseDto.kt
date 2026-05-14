package com.codewithmandyal.mviexample.data.dto.products


import com.google.gson.annotations.SerializedName

data class ProductsResponseDto(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("products")
    val products: List<ProductDto>?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("total")
    val total: Int?
)