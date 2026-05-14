package com.codewithmandyal.mviexample.data.dto.posts


import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("dislikes")
    val dislikes: Int?,
    @SerializedName("likes")
    val likes: Int?
)