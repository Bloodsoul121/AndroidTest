package com.blood.mactest.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.blood.mactest.R
import com.blood.mactest.databinding.LayoutItemMainActivityBinding
import java.util.*

class MainAdapter(
    private val context: Context,
    private val list: List<ActivityBean>,
    private val callback: BindingCallback<ActivityBean>
) :
    RecyclerView.Adapter<BindingViewHolder<LayoutItemMainActivityBinding>>(), View.OnClickListener {

    private val datas: MutableList<ActivityBean> = ArrayList<ActivityBean>()

    init {
        datas.clear()
        datas.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<LayoutItemMainActivityBinding> {
        val binding: LayoutItemMainActivityBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_item_main_activity,
            parent,
            false
        )
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<LayoutItemMainActivityBinding>,
        position: Int
    ) {
        val bean: ActivityBean = datas[position]
        holder.binding.content.tag = bean
        holder.binding.content.text = bean.content
        holder.binding.content.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onClick(v: View) {
        val bean: ActivityBean = v.tag as ActivityBean
        callback.onItemClick(bean)
    }

}