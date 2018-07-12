package com.aceplus.mmhealthcare.persistence.Dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo

/**
 * Created by kkk on 7/11/2018.
 */
@Dao
interface HealthcareInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dataList: List<HealthcareInfo>)

    @Query("select * from health_care_info")
    fun getAllData(): LiveData<List<HealthcareInfo>>

//    @get:Query("SELECT * FROM health_care_info")
//    val getAllData: LiveData<List<HealthcareInfo>>

}