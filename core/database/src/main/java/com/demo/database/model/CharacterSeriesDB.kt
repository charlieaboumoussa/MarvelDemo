package com.demo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTER_STORY")
class CharacterSeriesDB {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

    @ColumnInfo(name = "DESCRIPTION")
    var description: String = ""

    @ColumnInfo(name = "MODIFIED")
    var modified: String = ""

    @ColumnInfo(name = "TITLE")
    var title: String = ""

    @ColumnInfo(name = "START_YEAR")
    var startYear: String = ""

    @ColumnInfo(name = "END_YEAR")
    var endYear: String = ""

    @ColumnInfo(name = "THUMBNAIL_PATH")
    var thumbnailPath: String = ""

    @ColumnInfo(name = "THUMBNAIL_EXTENSION")
    var thumbnailExtension: String = ""

    @ColumnInfo(name = "TYPE")
    var rating: String = ""

}
