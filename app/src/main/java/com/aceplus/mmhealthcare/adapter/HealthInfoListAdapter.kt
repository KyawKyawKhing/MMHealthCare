package com.aceplus.mmhealthcare.adapter

import android.content.Context
import android.view.ViewGroup
import com.aceplus.mmhealthcare.R
import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
import com.aceplus.mmhealthcare.delegate.HomeDelegate
import com.aceplus.mmhealthcare.viewholder.HealthInfoViewHolder

/**
 * Created by kkk on 7/10/2018.
 */
class HealthInfoListAdapter(context: Context, private val delegate: HomeDelegate) : BaseRecyclerAdapter<HealthcareInfoVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInfoViewHolder {
        val view = mLayoutInflater!!.inflate(R.layout.healthinfo_listitem, parent, false)
        return HealthInfoViewHolder(view,delegate)
    }
}