package com.aceplus.mmhealthcare.mvp.view

import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO

/**
 * Created by kkk on 7/10/2018.
 */
interface HomeView : BaseView {
    fun displayHealthInfoList(dataList: List<HealthcareInfoVO>)
    fun displayMessage(messagae: String)
    fun displayUrl(url: String)
}