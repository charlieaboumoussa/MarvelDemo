package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MarvelCharacterDto(
    var id: Int,
    var name: String,
    var description: String,
    var modified: String,
    var thumbnail: HashMap<String, String>,
    var resourceURI: String,
)