package com.demo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MARVEL_CHARACTER")
class MarvelCharacterDB(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "NAME") var name: String,
    @ColumnInfo(name = "DESCRIPTION") var description: String,
    @ColumnInfo(name = "MODIFIED") var modified: String,
    @ColumnInfo(name = "THUMBNAIL_PATH") var thumbnailPath: String,
    @ColumnInfo(name = "THUMBNAIL_EXTENSION") var thumbnailExtension: String,
    @ColumnInfo(name = "RESOURCE_URI") var resourceURI: String
)