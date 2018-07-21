package com.aceplus.mmhealthcare.activity

import android.arch.lifecycle.Observer
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.aceplus.mmhealthcare.R
import com.aceplus.mmhealthcare.adapter.HealthInfoListAdapter
import com.aceplus.mmhealthcare.data.vo.HealthcareInfoVO
import com.aceplus.mmhealthcare.mvp.presenter.HomePresenter
import com.aceplus.mmhealthcare.mvp.view.HomeView
import kotlinx.android.synthetic.main.activity_main.*
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback

class MainActivity : AppCompatActivity(), HomeView {

    private lateinit var mAdapter: HealthInfoListAdapter
    private lateinit var mPresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = HomePresenter(this)
        mAdapter = HealthInfoListAdapter(applicationContext, mPresenter)
        rvHealthInfo.adapter = mAdapter
        rvHealthInfo.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = View.VISIBLE
        mPresenter.getAllHealthInfo().observe(this, Observer<List<HealthcareInfoVO>> { response ->
            if (response != null && response.isNotEmpty()) {
                displayHealthInfoList(response)
                progressBar.visibility = View.GONE
            }
        })
        mPresenter.getErrorMessage().observe(this, Observer<String> { message ->
            displayMessage(message!!)
            progressBar.visibility = View.GONE
        })
    }

    override fun displayHealthInfoList(dataList: List<HealthcareInfoVO>) {
        mAdapter.setNewList(dataList)
        emptyView.visibility = View.GONE
    }

    override fun displayMessage(message: String) {
        emptyView.visibility = View.VISIBLE
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayUrl(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(this.resources.getColor(R.color.colorPrimary))
                .setShowTitle(true)
                .build()
        CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent)
        CustomTabsHelper.openCustomTab(
                this, customTabsIntent,
                Uri.parse(url),
                WebViewFallback())
    }

}
