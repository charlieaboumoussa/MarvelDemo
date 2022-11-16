package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterEventDto(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var start: String,
    var end: String,
    var thumbnail: Map<String, String>,
    var rating: String,
)