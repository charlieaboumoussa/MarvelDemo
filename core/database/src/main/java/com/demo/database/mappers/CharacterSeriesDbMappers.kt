package com.demo.database.mappers

import com.demo.database.model.CharacterSeriesDB
import com.demo.model.CharacterSeries

fun CharacterSeries.toDbModel(): CharacterSeriesDB {
    return CharacterSeriesDB(
        id,
        title,
        description,
        modified,
        startYear,
        endYear,
        thumbnailPath,
        thumbnailExtension,
        rating,
    )
}

fun CharacterSeriesDB.toEntityModel(): CharacterSeries {
    return CharacterSeries(
        id,
        title,
        description,
        modified,
        startYear,
        endYear,
        thumbnailPath,
        thumbnailExtension,
        rating,
    )
}