package com.aceplus.mmhealthcare.data.vo

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

/**
 * Created by kkk on 7/10/2018.
 */
@Entity(tableName = "health_care_info")
class HealthcareInfoVO {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("author")
    @Expose
    @Embedded
    var author: AuthorVO? = null

    @SerializedName("short-description")
    @Expose
    var shortDescription: String? = null

    @SerializedName("published-date")
    @Expose
    var publishedDate: String? = null

    @SerializedName("complete-url")
    @Expose
    var completeUrl: String? = null

    @SerializedName("info-type")
    @Expose
    var infoType: String? = null
}
