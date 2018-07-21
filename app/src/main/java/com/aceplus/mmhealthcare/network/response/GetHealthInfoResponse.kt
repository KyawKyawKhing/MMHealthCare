package com.aceplus.mmhealthcare.network.response

import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetHealthInfoResponse {

    @SerializedName("code")
    @Expose
    var code: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("healthcare-info")
    @Expose
    var healthcareInfo: List<HealthcareInfoVO>? = null

}