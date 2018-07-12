package com.aceplus.mmhealthcare.data.model

import android.arch.lifecycle.LiveData
import android.content.Context
import com.aceplus.mmhealthcare.AppConstants
import com.aceplus.mmhealthcare.data.vo.GetHealthInfoResponse
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by kkk on 7/10/2018.
 */
class HealthCareModel(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANCE: HealthCareModel? = null

        fun getInstance(): HealthCareModel {
            if (INSTANCE == null) {
                throw RuntimeException("HealthCareModel is being invoked before initializing.")
            }
            val i = INSTANCE
            return i!!
        }

        fun initHealthCareModel(context: Context) {
            INSTANCE = HealthCareModel(context)
        }
    }

    fun fetchDataFromNetwork() {
        mApiService!!.getHealthInfo(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthInfoResponse> {
                    override fun onComplete() {

                    }

                    override fun onNext(response: GetHealthInfoResponse) {
                        if (response.healthcareInfo != null && response.healthcareInfo!!.isNotEmpty())
                            saveIntoDB(response.healthcareInfo)
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                })
    }

    private fun saveIntoDB(list: List<HealthcareInfo>?) {
        mAppDatabase!!.healthcareInfoDao().insertAll(list!!)
    }

    fun getAllHealthInfo(): LiveData<List<HealthcareInfo>> {
        return mAppDatabase!!.healthcareInfoDao().getAllData()
    }
}