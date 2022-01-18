package com.example.templateapp01.data.repository.impl

import com.example.templateapp01.data.SafeResult
import com.example.templateapp01.data.api.UnsplashService
import com.example.templateapp01.data.repository.UnsplashRepository
import com.example.templateapp01.data.api.response.toModel
import com.example.templateapp01.data.safeApiCall
import com.example.templateapp01.di.IoDispatcher
import com.example.templateapp01.model.UnSplashPhoto
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

internal class UnsplashRepositoryImpl @Inject constructor(
    private val api: UnsplashService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : UnsplashRepository {
    override suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int
    ): SafeResult<List<UnSplashPhoto>> {
        return safeApiCall(dispatcher) {
            api.searchPhotos(query, page, perPage).results.map { it.toModel() }
        }
    }
}