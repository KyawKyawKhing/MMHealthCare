package com.aceplus.mmhealthcare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
import com.aceplus.mmhealthcare.persistence.Dao.HealthcareInfoDao

/**
 * Created by kkk on 7/11/2018.
 */
@Database(entities = arrayOf(HealthcareInfoVO::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun healthcareInfoDao(): HealthcareInfoDao

    companion object {
        private val DB_NAME = "Health_Care.DB"
        var INSATNCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSATNCE == null) {
                INSATNCE = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSATNCE
            return i!!
        }
    }
}