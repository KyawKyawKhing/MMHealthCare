package com.aceplus.mmhealthcare.data.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthorVO {

    @SerializedName("author-id")
    @Expose
    var authorId: Int? = null
    @SerializedName("author-name")
    @Expose
    var authorName: String? = null
    @SerializedName("author-picture")
    @Expose
    var authorPicture: String? = null

}