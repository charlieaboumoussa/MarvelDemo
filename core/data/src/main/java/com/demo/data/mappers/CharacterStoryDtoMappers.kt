package com.demo.data.mappers

import com.demo.model.CharacterStory
import com.demo.network.model.CharacterStoryDto

fun CharacterStory.toDtoModel(): CharacterStoryDto {
    return CharacterStoryDto(
        id,
        title,
        description,
        modified,
        resourceURI,
        hashMapOf(
            Pair("path", thumbnailPath),
            Pair("extenstion", thumbnailExtension),
        ),
        type,
    )
}

fun CharacterStoryDto.toEntityModel(): CharacterStory {
    return CharacterStory(
        id,
        title,
        description,
        modified,
        resourceURI,
        thumbnail["path"]?:"",
        thumbnail["extension"]?:"",
        type,
    )
}