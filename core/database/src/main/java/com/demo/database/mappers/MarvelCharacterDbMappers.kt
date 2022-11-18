package com.demo.database.mappers

import com.demo.database.model.MarvelCharacterDB
import com.demo.model.MarvelCharacter

fun MarvelCharacter.toDbModel() : MarvelCharacterDB {
    return MarvelCharacterDB(
        this.id,
        this.name,
        this.description,
        this.modified,
        this.thumbnailPath,
        this.thumbnailExtension,
        this.resourceURI
    )
}

fun MarvelCharacterDB.toEntityModel() : MarvelCharacter {
    return MarvelCharacter(
        this.id,
        this.name,
        this.description,
        this.modified,
        this.thumbnailPath,
        this.thumbnailExtension,
        this.resourceURI
    )
}