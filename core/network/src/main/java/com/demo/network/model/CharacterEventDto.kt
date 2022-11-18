package com.demo.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterEventDto(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,

    @SerializedName("start")
    var startDate: String,

    @SerializedName("end")
    var endDate: String,

    var thumbnail: Map<String, String>,
    var rating: String,
)