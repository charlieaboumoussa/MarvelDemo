package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterStoryDto(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var resourceURI: String,
    var thumbnail: HashMap<String, String>,
    var type: String,
)