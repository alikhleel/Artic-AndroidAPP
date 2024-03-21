package com.alikhalil.demo1.data.repo

import com.alikhalil.demo1.common.UIState
import com.alikhalil.demo1.data.model.ExhibitionResponse
import com.alikhalil.demo1.data.remote.ArticApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExhibitionRepository @Inject constructor(
    val articApi: ArticApi
) {
    suspend fun getExhibition(): UIState<ExhibitionResponse> {
        val response = articApi.getExhibitions()
        return try {
            if (response.isSuccessful && response.body() != null) {
                UIState.Success(response.body())
            } else {
                UIState.Empty(message = response.message().orEmpty())
            }
        } catch (e: Exception) {
            return UIState.Error(e.message.toString())
        }
    }
}