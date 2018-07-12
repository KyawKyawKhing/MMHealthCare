package com.aceplus.mmhealthcare.viewholder

import android.view.View
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo
import com.aceplus.mmhealthcare.delegate.HomeDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.healthinfo_listitem.view.*

/**
 * Created by kkk on 7/10/2018.
 */
class HealthInfoViewHolder(itemView: View, private val delegate: HomeDelegate) : BaseViewHolder<HealthcareInfo>(itemView), View.OnClickListener {
    private var data: HealthcareInfo? = null
    override fun setData(data: HealthcareInfo) {
        this.data = data
        Glide.with(itemView.context)
                .load(data.author!!.authorPicture)
                .into(itemView.ivAuthor)
        itemView.tvAuthorName.text = data.author!!.authorName
        itemView.tvPublishedDate.text = data.publishedDate

        Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.ivHealthInfo)
        itemView.tvHealthInfoTitle.text = data.title
        itemView.tvHealthInfoDesp.text = data.shortDescription
        itemView.tvFileUrl.text = data.completeUrl

        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        delegate.onTapItemList(data!!.completeUrl!!)
    }

}