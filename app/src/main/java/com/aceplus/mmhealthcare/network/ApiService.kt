package com.aceplus.mmhealthcare.network

import com.aceplus.mmhealthcare.network.response.GetHealthInfoResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by kkk on 7/11/2018.
 */
interface ApiService {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun getHealthInfo(@Field("access_token") accessToken: String): Observable<GetHealthInfoResponse>
}