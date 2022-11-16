package com.demo.model

data class CharacterStory(
    var id: Int,
    var title: String,
    var description: String,
    var modified: String,
    var resourceURI: String,
    var thumbnail: ThumbnailInfo,
    var type: String,
)