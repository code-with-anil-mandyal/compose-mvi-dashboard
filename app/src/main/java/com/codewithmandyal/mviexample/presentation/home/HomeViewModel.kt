package com.codewithmandyal.mviexample.presentation.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewithmandyal.mviexample.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {
        private val _state = MutableStateFlow(HomeState())
        val state = _state.asStateFlow()

    init {
            processIntent(HomeIntent.LoadHomeData)
    }

    fun processIntent(intent: HomeIntent){
        when(intent){
            is HomeIntent.LoadHomeData ->{
                loadHomeData()
            }
            is HomeIntent.Refresh ->{
                loadHomeData()
            }
        }
    }

    private fun loadHomeData(){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {

                val productDeferred = async {
                    homeRepository.getProducts()
                }

                val categoryDeferred = async {
                    homeRepository.getCategories()
                }

                val postsDeferred = async {
                    homeRepository.getPosts()
                }

                val products = productDeferred.await()
                val categories = categoryDeferred.await()
                val posts = postsDeferred.await()

                _state.update {
                    it.copy(
                        isLoading = false,
                        products = products,
                        categories = categories,
                        posts = posts
                    )
                }

            }catch (e: Exception){
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message?: "Something went wrong"
                    )
                }
            }
        }
    }
}