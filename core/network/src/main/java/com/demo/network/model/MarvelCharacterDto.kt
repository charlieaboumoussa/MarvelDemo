package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MarvelCharacterDto(
    var name: String,
    var description : String,
    var resourceURI  : String,
)