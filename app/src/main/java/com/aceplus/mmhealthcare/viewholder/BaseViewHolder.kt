package com.aceplus.mmhealthcare.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by kkk on 7/10/2018.
 */
abstract class BaseViewHolder<in O>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun setData(data: O)

}