package com.codewithmandyal.mviexample.presentation.home

import java.util.Objects

sealed class HomeIntent {
    object LoadHomeData : HomeIntent()
    object Refresh : HomeIntent()
}
