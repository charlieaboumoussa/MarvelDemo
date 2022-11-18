package com.demo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTER_EVENT")
class CharacterEventDB(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "TITLE") var title: String,
    @ColumnInfo(name = "DESCRIPTION") var description: String,
    @ColumnInfo(name = "MODIFIED") var modified: String,
    @ColumnInfo(name = "START") var startDate: String,
    @ColumnInfo(name = "END") var endDate: String,
    @ColumnInfo(name = "THUMBNAIL_PATH") var thumbnailPath: String,
    @ColumnInfo(name = "THUMBNAIL_EXTENSION") var thumbnailExtension: String,
    @ColumnInfo(name = "TYPE") var rating: String
)
