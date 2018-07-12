package com.aceplus.mmhealthcare.mvp.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.aceplus.mmhealthcare.data.model.HealthCareModel
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo
import com.aceplus.mmhealthcare.mvp.view.HomeView

/**
 * Created by kkk on 7/10/2018.
 */
class HomePresenter(view: HomeView) : BasePresenter<HomeView>(view) {
    private var healthcareModel: HealthCareModel? = null

    init {
        healthcareModel = HealthCareModel.getInstance()
        loadAllData()
    }

    private fun loadAllData() {
        healthcareModel!!.fetchDataFromNetwork(mErrorLiveData)
    }

    fun getAllHealthInfo(): LiveData<List<HealthcareInfo>> {
        return healthcareModel!!.getAllHealthInfo()
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return mErrorLiveData!!
    }

}
