package com.demo.model

data class CharacterComic(
    var id: Int,
    var digitalId: Int,
    var title: String,
    var issueNumber: Int,
    var description: String,
    var variantDescription: String,
    var modified: String,
    var upc: String,
    var diamondCode: String,
    var textObjects: List<String>,
    var format: String,
)