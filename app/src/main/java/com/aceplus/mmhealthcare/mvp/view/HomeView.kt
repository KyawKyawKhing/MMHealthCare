package com.aceplus.mmhealthcare.mvp.view

import com.aceplus.mmhealthcare.data.vo.HealthcareInfo

/**
 * Created by kkk on 7/10/2018.
 */
interface HomeView : BaseView {
    fun displayHealthInfoList(dataList: List<HealthcareInfo>)
    fun displayMessage(messagae: String)
}