package com.aceplus.mmhealthcare.data.model

import android.content.Context
import com.aceplus.mmhealthcare.utils.AppConstants
import com.aceplus.mmhealthcare.network.ApiService
import com.aceplus.mmhealthcare.persistence.AppDatabase
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by kkk on 7/10/2018.
 */
abstract class BaseModel(context: Context) {
    protected var mApiService: ApiService
    protected var mAppDatabase: AppDatabase

    init {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.base_url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        mApiService = retrofit.create(ApiService::class.java)
        mAppDatabase = AppDatabase.getInstance(context)
    }
}