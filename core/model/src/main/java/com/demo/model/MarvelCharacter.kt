package com.demo.model

data class MarvelCharacter(
    var id: Int,
    var name: String,
    var description: String,
    var modified: String,
    var thumbnail: ThumbnailInfo,
    var resourceURI: String,
)