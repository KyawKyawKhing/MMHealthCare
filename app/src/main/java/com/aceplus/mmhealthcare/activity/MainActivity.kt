package com.aceplus.mmhealthcare.activity

import android.arch.lifecycle.Observer
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.aceplus.mmhealthcare.R
import com.aceplus.mmhealthcare.adapter.HealthInfoListAdapter
import com.aceplus.mmhealthcare.data.vo.HealthcareInfo
import com.aceplus.mmhealthcare.delegate.HomeDelegate
import com.aceplus.mmhealthcare.mvp.presenter.HomePresenter
import com.aceplus.mmhealthcare.mvp.view.HomeView
import kotlinx.android.synthetic.main.activity_main.*
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback

class MainActivity : AppCompatActivity(), HomeView, HomeDelegate {

    private var mAdapter: HealthInfoListAdapter? = null
    private var mPresenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = HealthInfoListAdapter(applicationContext, this)
        rvHealthInfo.adapter = mAdapter
        rvHealthInfo.layoutManager = LinearLayoutManager(this)
        mPresenter = HomePresenter(this)
        mPresenter!!.getAllHealthInfo().observe(this, Observer<List<HealthcareInfo>> { response -> displayHealthInfoList(response!!) })
        mPresenter!!.getErrorMessage().observe(this, Observer<String> { message -> displayMessage(message!!) })
    }

    override fun displayHealthInfoList(dataList: List<HealthcareInfo>) {
        mAdapter!!.setNewList(dataList)
    }

    override fun displayMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onTapItemList(url: String) {
        displayUrl(url)
    }

    private fun displayUrl(url: String) {
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
