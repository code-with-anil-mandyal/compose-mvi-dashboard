package com.codewithmandyal.mviexample.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.mviexample.domain.model.categories.Category

@Composable
fun CategorySection(
    categories: List<Category>
) {

    Column {

        Text(
            text = "Categories",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {

            items(categories) { category ->

                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .background(
                            Color.LightGray,
                            RoundedCornerShape(20.dp)
                        )
                        .padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        )
                ) {

                    Text(text = category.name?:"")
                }
            }
        }
    }
}