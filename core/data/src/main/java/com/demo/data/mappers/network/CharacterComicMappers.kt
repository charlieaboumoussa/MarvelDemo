package com.demo.data.mappers

import com.demo.model.CharacterComic
import com.demo.network.model.CharacterComicDto

fun CharacterComic.toDtoModel(): CharacterComicDto {
    return CharacterComicDto(
        id,
        digitalId,
        title,
        issueNumber,
        description,
        variantDescription,
        modified,
        upc,
        diamondCode,
        textObjects,
        format,
    )
}

fun CharacterComicDto.toEntityModel(): CharacterComic {
    return CharacterComic(
        id,
        digitalId,
        title,
        issueNumber,
        description,
        variantDescription,
        modified,
        upc,
        diamondCode,
        textObjects,
        format,
    )
}