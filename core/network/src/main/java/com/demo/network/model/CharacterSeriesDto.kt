package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterSeriesDto(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var startYear: String,
    var endYear: String,
    var thumbnail: Map<String, String>,
    var rating: String,
)