package com.demo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTER_STORY")
class CharacterStoryDB(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "TITLE") var title: String,
    @ColumnInfo(name = "DESCRIPTION") var description: String,
    @ColumnInfo(name = "MODIFIED") var modified: String,
    @ColumnInfo(name = "RESOURCE_URI") var resourceURI: String,
    @ColumnInfo(name = "THUMBNAIL_PATH") var thumbnailPath: String,
    @ColumnInfo(name = "THUMBNAIL_EXTENSION") var thumbnailExtension: String,
    @ColumnInfo(name = "TYPE") var type: String
)
