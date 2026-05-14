package com.codewithmandyal.mviexample.data.mapper

import com.codewithmandyal.mviexample.data.dto.categories.CategoryResponseItem
import com.codewithmandyal.mviexample.domain.model.categories.Category

fun CategoryResponseItem.toDomain() : Category {
    return Category(
        name = name,
        slug = slug
    )
}