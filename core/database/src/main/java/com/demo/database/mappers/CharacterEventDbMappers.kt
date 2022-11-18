package com.demo.database.mappers

import com.demo.database.model.CharacterEventDB
import com.demo.model.CharacterEvent

fun CharacterEvent.toDbModel(): CharacterEventDB {
    return CharacterEventDB(
        id,
        title,
        description,
        modified,
        startDate,
        endDate,
        thumbnailPath,
        thumbnailExtension,
        rating,
    )
}

fun CharacterEventDB.toEntityModel(): CharacterEvent {
    return CharacterEvent(
        id,
        title,
        description,
        modified,
        startDate,
        endDate,
        thumbnailPath,
        thumbnailExtension,
        rating,
    )
}