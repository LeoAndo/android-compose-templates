package com.example.templateapp01.ui.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.templateapp01.data.Result
import com.example.templateapp01.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {

    var uiState = mutableStateOf<UiState>(UiState.NoPhotos)
        private set

    init {
        Log.d(LOG_TAG, "init: " + hashCode())
        uiState.value = UiState.Loading // start loading.

        viewModelScope.launch {
            when (val ret = repository.searchPhotos("dogs")) {
                is Result.Success -> {
                    uiState.value = UiState.Photos(results = ret.data) // stop loading.
                }
                Result.BadRequestError, is Result.Error, Result.NotFoundError, Result.UnAuthorizedError -> {
                    uiState.value = UiState.Error // stop loading.
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(LOG_TAG, "onCleared" + hashCode())
    }

    companion object {
        const val LOG_TAG = "HomeViewModel"
    }
}