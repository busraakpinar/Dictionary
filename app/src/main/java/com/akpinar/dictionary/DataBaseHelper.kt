package com.akpinar.dictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, "dictionary.sqlite", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE IF NOT EXISTS \"Dictionary\" (\n" +
                "\t\"word_id\"\tINTEGER,\n" +
                "\t\"english\"\tTEXT,\n" +
                "\t\"turkish\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"word_id\" AUTOINCREMENT)\n" +
                ");")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS Dictionary")
        onCreate(p0)
    }
}