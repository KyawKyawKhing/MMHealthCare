package com.aceplus.mmhealthcare.persistence.TypeConvertor

import android.arch.persistence.room.TypeConverters
import com.aceplus.mmhealthcare.data.vo.Author
import com.google.gson.Gson

/**
 * Created by kkk on 7/11/2018.
 */
class AuthorTypeConvertor {
    @TypeConverters
    fun toString(author: Author): String {
        return Gson().toJson(author)
    }

    @TypeConverters
    fun toObject(json: String): Author {
        return Gson().fromJson(json, Author::class.java)
    }
}