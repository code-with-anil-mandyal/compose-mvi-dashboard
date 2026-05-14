package com.codewithmandyal.mviexample.data.dto.posts


import com.google.gson.annotations.SerializedName

data class PostResponseDto(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("posts")
    val posts: List<PostDto>?,
    @SerializedName("skip")
    val skip: Int?,
    @SerializedName("total")
    val total: Int?
)