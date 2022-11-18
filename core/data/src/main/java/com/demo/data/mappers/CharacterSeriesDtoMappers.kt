package com.demo.data.mappers

import com.demo.model.CharacterSeries
import com.demo.network.model.CharacterSeriesDto

fun CharacterSeries.toDtoModel(): CharacterSeriesDto {
    return CharacterSeriesDto(
        id,
        title,
        description,
        modified,
        startYear,
        endYear,
        hashMapOf(
            Pair("path", thumbnailPath),
            Pair("extenstion", thumbnailExtension),
        ),
        rating,
    )
}

fun CharacterSeriesDto.toEntityModel(): CharacterSeries {
    return CharacterSeries(
        id,
        title,
        description,
        modified,
        startYear,
        endYear,
        thumbnail["path"]?:"",
        thumbnail["extension"]?:"",
        rating,
    )
}