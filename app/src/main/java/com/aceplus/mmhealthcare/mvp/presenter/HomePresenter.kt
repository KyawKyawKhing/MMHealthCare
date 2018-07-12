package com.aceplus.mmhealthcare.mvp.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.aceplus.mmhealthcare.data.model.HealthCareModel
import com.aceplus.mmhealthcare.data.vo.GetHealthInfoResponse
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo
import com.aceplus.mmhealthcare.mvp.view.HomeView

/**
 * Created by kkk on 7/10/2018.
 */
class HomePresenter(view: HomeView) : BasePresenter<HomeView>(view) {
    var liveData: MutableLiveData<GetHealthInfoResponse>? = null
    private var healthcareModel: HealthCareModel? = null

    init {
        liveData = MutableLiveData()
        healthcareModel = HealthCareModel.getInstance()
        loadAllData()
    }

    fun loadAllData() {
        healthcareModel!!.fetchDataFromNetwork()
    }

    fun getAllHealthInfo(): LiveData<List<HealthcareInfo>> {
        return healthcareModel!!.getAllHealthInfo()
    }

}
