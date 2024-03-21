package com.alikhalil.demo1.data.model

import com.google.gson.annotations.SerializedName

data class ExhibitionResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("short_description") var shortDescription: String? = null
)