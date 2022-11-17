package com.demo.data.mappers

import com.demo.model.MarvelCharacter
import com.demo.network.model.MarvelCharacterDto

fun MarvelCharacter.toDtoModel() : MarvelCharacterDto {
    return MarvelCharacterDto(
        this.id,
        this.name,
        this.description,
        this.modified,
        hashMapOf(
            Pair("path", this.thumbnailPath),
            Pair("extension", this.thumbnailExtension)
        ),
        this.resourceURI
    )
}

fun MarvelCharacterDto.toEntityModel() : MarvelCharacter {
    return MarvelCharacter(
        this.id,
        this.name,
        this.description,
        this.modified,
        this.thumbnail["path"]?:"",
        this.thumbnail["extension"]?:"",
        this.resourceURI
    )
}