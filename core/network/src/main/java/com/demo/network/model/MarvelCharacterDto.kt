package com.demo.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MarvelCharacterDto(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("description")
    var description: String = "",

    @SerializedName("modified")
    var modified: String = "",

    @SerializedName("thumbnail")
    var thumbnail: Map<String, String> = hashMapOf(),

    @SerializedName("resourceURI")
    var resourceURI: String = "",
)