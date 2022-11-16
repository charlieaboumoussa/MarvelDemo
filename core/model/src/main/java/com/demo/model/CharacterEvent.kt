package com.demo.model

data class CharacterEvent(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var start: String,
    var end: String,
    var thumbnail: ThumbnailInfo,
    var rating: String,
)