package com.demo.database.mappers

import com.demo.database.model.CharacterStoryDB
import com.demo.model.CharacterStory

fun CharacterStory.toDbModel(): CharacterStoryDB {
    return CharacterStoryDB(
        id,
        title,
        description,
        modified,
        resourceURI,
        thumbnailPath,
        thumbnailExtension,
        type,
    )
}

fun CharacterStoryDB.toEntityModel(): CharacterStory {
    return CharacterStory(
        id,
        title,
        description,
        modified,
        resourceURI,
        thumbnailPath,
        thumbnailExtension,
        type,
    )
}