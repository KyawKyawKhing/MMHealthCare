package com.aceplus.mmhealthcare.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.aceplus.mmhealthcare.viewholder.BaseViewHolder

/**
 * Created by kkk on 7/10/2018.
 */
abstract class BaseRecyclerAdapter<in V, O>(context: Context) : RecyclerView.Adapter<BaseViewHolder<O>>() {
    private var mDataList: List<O>? = null
    protected var mLayoutInflater: LayoutInflater? = null

    init {
        mDataList = ArrayList()
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<O>, position: Int) {
        holder.setData(mDataList!![position])
    }

    override fun getItemCount(): Int {
        return mDataList!!.size
    }

    fun setNewList(newList: List<O>) {
        mDataList = newList
        notifyDataSetChanged()
    }
}