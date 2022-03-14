package com.akpinar.dictionary

import android.annotation.SuppressLint

class Wordsdao {

    @SuppressLint("Range")
    fun allWords(vt:DataBaseHelper) : ArrayList<Words> {
        val wordsList = ArrayList<Words>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM Dictionary", null)

        while (c.moveToNext()){
            val word = Words(c.getInt(c.getColumnIndex("word_id")),
                c.getString(c.getColumnIndex("english")),
                c.getString(c.getColumnIndex("turkish")))
            wordsList.add(word)
        }

        return wordsList
    }

    @SuppressLint("Range")
    fun doSearch(vt:DataBaseHelper, searchWord:String) : ArrayList<Words> {
        val wordsList = ArrayList<Words>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM Dictionary WHERE english like '%$searchWord%'", null)

        while (c.moveToNext()){
            val word = Words(c.getInt(c.getColumnIndex("word_id")),
                c.getString(c.getColumnIndex("english")),
                c.getString(c.getColumnIndex("turkish")))
            wordsList.add(word)
        }

        return wordsList
    }
}