package com.codewithmandyal.mviexample.data.mapper

import com.codewithmandyal.mviexample.data.dto.posts.PostDto
import com.codewithmandyal.mviexample.domain.model.posts.Posts

fun PostDto.toDomain(): Posts{
    return Posts(
        id = id,
        body = body,
        title = title
    )
}
