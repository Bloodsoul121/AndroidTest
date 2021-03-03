package com.blood.mactest.main

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.blood.mactest.R
import com.blood.mactest.databinding.ActivityMainBinding
import com.blood.mactest.test.Test1Activity
import com.blood.mactest.util.ToastUtil
import com.tbruyelle.rxpermissions3.RxPermissions
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

class MainActivity : AppCompatActivity(), BindingCallback<ActivityBean> {

    private lateinit var binding: ActivityMainBinding
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
        requestPermissions()
    }

    private fun requestPermissions() {
        val rxPermissions = RxPermissions(this)
        disposable = rxPermissions.request(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
            .subscribe { aBoolean -> ToastUtil.toast(if (aBoolean) "accept" else "deny") }
    }

    private fun init() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MainAdapter(this, prepareActivityList(), this)
    }

    private fun prepareActivityList(): List<ActivityBean> {
        val list: MutableList<ActivityBean> = ArrayList<ActivityBean>()
        list.add(ActivityBean(this, "测试 示例", Test1Activity::class.java))
        return list
    }

    override fun onItemClick(t: ActivityBean) {
        t.skip()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }

}