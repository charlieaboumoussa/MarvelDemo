package com.demo.data.mappers

import com.demo.model.CharacterEvent
import com.demo.network.model.CharacterEventDto

fun CharacterEvent.toDtoModel(): CharacterEventDto {
    return CharacterEventDto(
        id,
        title,
        description,
        modified,
        startDate,
        endDate,
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
        startDate,
        endDate,
        thumbnail["path"]?:"",
        thumbnail["extension"]?:"",
        rating,
    )
}