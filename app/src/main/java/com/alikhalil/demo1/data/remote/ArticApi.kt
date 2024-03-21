package com.alikhalil.demo1.data.remote

import com.alikhalil.demo1.data.model.ExhibitionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ArticApi {
    @GET
    suspend fun getExhibitions(
        @Url url: String = "https://api.artic.edu/api/v1/exhibitions",
        @Query("page") pageNumber: Int = 1,
        @Query("limit") pageSize: Int = 100
    ): Response<ExhibitionResponse>

}




