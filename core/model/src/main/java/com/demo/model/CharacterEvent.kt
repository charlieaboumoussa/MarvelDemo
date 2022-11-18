package com.demo.model

data class CharacterEvent(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var startDate: String,
    var endDate: String,
    var thumbnailPath: String,
    var thumbnailExtension: String,
    var rating: String,
)