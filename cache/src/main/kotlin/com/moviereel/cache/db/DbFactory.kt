package com.moviereel.cache.db

import android.arch.persistence.room.Room
import android.content.Context

/**
 * @author lusinabrian on 08/06/18.
 * @Notes
 */
object DbFactory {
    private const val DATABASE_NAME = "moviereel.db"

    fun makeAppDatabase(context: Context): MovieReelDatabase {
        return Room.databaseBuilder(context, MovieReelDatabase::class.java, DATABASE_NAME).build()
    }
}