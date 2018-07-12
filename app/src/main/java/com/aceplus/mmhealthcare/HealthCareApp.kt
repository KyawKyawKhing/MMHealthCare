package com.aceplus.mmhealthcare

import android.app.Application
import com.aceplus.mmhealthcare.data.model.HealthCareModel

/**
 * Created by kkk on 7/11/2018.
 */
class HealthCareApp : Application() {
    override fun onCreate() {
        super.onCreate()
        HealthCareModel.initHealthCareModel(applicationContext)
    }
}