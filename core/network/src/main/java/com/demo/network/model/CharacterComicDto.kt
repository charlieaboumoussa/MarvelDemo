package com.demo.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterComicDto(
    var id: Int,
    var digitalId: Int,
    var title: String,
    var issueNumber: Int,
    var description: String,
    var variantDescription: String,
    var modified: String,
    var upc: String,
    var diamondCode: String,
    var format: String,
)