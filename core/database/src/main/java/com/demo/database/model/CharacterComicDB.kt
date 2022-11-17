package com.demo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CHARACTER_COMIC")
class CharacterComicDB {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

    @ColumnInfo(name = "DIGITAL_ID")
    var digitalId: Int  = 0

    @ColumnInfo(name = "DESCRIPTION")
    var description: String = ""

    @ColumnInfo(name = "MODIFIED")
    var modified: String = ""

    @ColumnInfo(name = "TITLE")
    var title: String = ""

    @ColumnInfo(name = "ISSUE_NUMBER")
    var issueNumber: Int = 0

    @ColumnInfo(name = "VARIANT_DESCRIPTION")
    var variantDescription: String = ""

    @ColumnInfo(name = "UPC")
    var upc: String = ""

    @ColumnInfo(name = "DIAMOND_CODE")
    var diamondCode: String = ""

    @ColumnInfo(name = "TEXT_OBJECTS")
    var textObjects: ArrayList<String> = arrayListOf()

    @ColumnInfo(name = "FORMAT")
    var format: String = ""

}
