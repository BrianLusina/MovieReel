package com.moviereel.cache.db

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moviereel.cache.db.models.movie.MovieNowPlayingCacheModel

/**
 * @author lusinabrian on 16/09/17.
 * @Notes Converter for database to enable storage of non primitive data types
 */
object DbConverters {
    /**
     * Converts the string value to an array list
     * @param value the value to get the converted strong, this will be used to convert to an ArrayList
     * */
    @JvmStatic
    @TypeConverter
    fun fromString(value: String): ArrayList<MovieNowPlayingCacheModel> {
        val listType = object : TypeToken<ArrayList<MovieNowPlayingCacheModel>>() {}.type
        return Gson().fromJson(value, listType)
    }

    /**
     * converts from an array list to a JSON string for easy storage to discover database
     * @param arrayList The array list to store to the database, Converts this to a JSON string
     * */
    @JvmStatic
    @TypeConverter
    fun fromArrayList(arrayList: ArrayList<MovieNowPlayingCacheModel>): String {
        val gson = Gson()
        return gson.toJson(arrayList)
    }

    /**
     * Converts the string value to an array list
     * @param value the value to get the converted strong, this will be used to convert to an ArrayList
     * */
    @JvmStatic
    @TypeConverter
    fun fromGenreIdString(value: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    /**
     * converts from an array list to a JSON string for easy storage to discover database
     * @param genreList The list to store to the database, Converts this to a JSON string
     * */
    @JvmStatic
    @TypeConverter
    fun fromGenreIdList(genreList: List<Int>): String {
        val gson = Gson()
        return gson.toJson(genreList)
    }
}