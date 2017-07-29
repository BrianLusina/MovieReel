package com.moviereel.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

import com.moviereel.data.db.models.movie.DaoMaster
import com.moviereel.di.AppContext
import com.moviereel.di.DatabaseInfo

import org.greenrobot.greendao.database.Database

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 */

@Singleton
class DbOpenHelper @Inject
constructor(@AppContext context: Context, @DatabaseInfo name: String) : DaoMaster.OpenHelper(context, name) {
    private val TAG = DbOpenHelper::class.java.simpleName

    override fun onCreate(db: Database?) {
        super.onCreate(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        super.onUpgrade(db, oldVersion, newVersion)
        Log.d(TAG, "onUpgrade: upgrading $db from $oldVersion to $newVersion")
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
        Log.d(TAG, "onDowngrade: downgrading $db from $newVersion to $oldVersion")
    }
}
