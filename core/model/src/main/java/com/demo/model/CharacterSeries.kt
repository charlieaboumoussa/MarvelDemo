package com.demo.model

data class CharacterSeries(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var startYear: String,
    var endYear: String,
    var thumbnailPath: String,
    var thumbnailExtension: String,
    var rating: String,
)