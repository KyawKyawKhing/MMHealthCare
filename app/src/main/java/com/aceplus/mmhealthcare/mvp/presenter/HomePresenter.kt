package com.aceplus.mmhealthcare.mvp.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.aceplus.mmhealthcare.data.model.HealthCareModel
import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
import com.aceplus.mmhealthcare.delegate.HomeDelegate
import com.aceplus.mmhealthcare.mvp.view.HomeView

/**
 * Created by kkk on 7/10/2018.
 */
class HomePresenter(view: HomeView) : BasePresenter<HomeView>(view), HomeDelegate {
    private var healthcareModel: HealthCareModel = HealthCareModel.getInstance()

    init {
        loadAllData()
    }

    private fun loadAllData() {
        healthcareModel.fetchDataFromNetwork(mErrorLiveData)
    }

    override fun onTapItemList(url: String) {
        mView!!.displayUrl(url)
    }

    fun getAllHealthInfo(): LiveData<List<HealthcareInfoVO>> {
        return healthcareModel.getAllHealthInfo()
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return mErrorLiveData
    }

}
