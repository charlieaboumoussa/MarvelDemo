package com.demo.database.mappers

import com.demo.database.model.CharacterComicDB
import com.demo.model.CharacterComic

fun CharacterComic.toDbModel(): CharacterComicDB{
    return CharacterComicDB(
        id,
        digitalId,
        title,
        issueNumber,
        description,
        variantDescription,
        modified,
        upc,
        diamondCode,
        format,
    )
}

fun CharacterComicDB.toEntityModel(): CharacterComic {
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
        format,
    )
}