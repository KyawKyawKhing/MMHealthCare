package com.aceplus.mmhealthcare.data.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.aceplus.mmhealthcare.utils.AppConstants
import com.aceplus.mmhealthcare.network.response.GetHealthInfoResponse
import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
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

    fun fetchDataFromNetwork(mErrorLiveData: MutableLiveData<String>?) {
        mApiService.getHealthInfo(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthInfoResponse> {
                    override fun onComplete() {

                    }

                    override fun onNext(response: GetHealthInfoResponse) {
                        if (response.code == 200) {
                            if (response.healthcareInfo != null && response.healthcareInfo!!.isNotEmpty()) {
                                saveIntoDB(response.healthcareInfo)
                            } else mErrorLiveData!!.value = "No Data to display"
                        } else if (response.code == 403) {
                            mErrorLiveData!!.value = response.message
                        }
                    }

                    override fun onError(e: Throwable) {
                        mErrorLiveData!!.value = e.message
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                })
    }

    private fun saveIntoDB(list: List<HealthcareInfoVO>?) {
        mAppDatabase.healthcareInfoDao().insertAll(list!!)
    }

    fun getAllHealthInfo(): LiveData<List<HealthcareInfoVO>> {
        return mAppDatabase.healthcareInfoDao().getAllData()
    }
}