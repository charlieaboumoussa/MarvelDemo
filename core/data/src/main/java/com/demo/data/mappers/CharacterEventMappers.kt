package com.demo.data.mappers

import com.demo.model.CharacterEvent
import com.demo.network.model.CharacterEventDto

fun CharacterEvent.toDtoModel(): CharacterEventDto {
    return CharacterEventDto(
        id,
        title,
        description,
        modified,
        start,
        end,
        hashMapOf(
            Pair("path", thumbnailPath),
            Pair("extenstion", thumbnailExtension),
        ),
        rating,
    )
}

fun CharacterEventDto.toEntityModel(): CharacterEvent {
    return CharacterEvent(
        id,
        title,
        description,
        modified,
        start,
        end,
        thumbnail["path"]?:"",
        thumbnail["extension"]?:"",
        rating,
    )
}