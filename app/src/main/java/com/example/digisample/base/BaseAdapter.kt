package com.example.digisample.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by DTFKAYMAZ on 27.09.2022.
 */

abstract class BaseAdapter<Object, ViewHolder : RecyclerView.ViewHolder> : RecyclerView.Adapter<ViewHolder>() {

    private var items: List<Object?>? = null
    private var recyclerView: RecyclerView? = null

    open fun configureItemSize(holder: ViewHolder, position: Int, item: Object) {}
    abstract fun bindView(holder: ViewHolder, position: Int, item: Object)
    abstract fun createView(context: Context, parent: ViewGroup, inflater: LayoutInflater, viewType: Int): ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return createView(parent.context, parent, LayoutInflater.from(parent.context), viewType)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items?.getOrNull(position)?.let {
            configureItemSize(holder, position, it)
            bindView(holder, position, it)
        }
    }

    override fun getItemCount(): Int {
        return this.items?.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun set(items: List<Object>?) {
        this.items = items
        this.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        this.items = arrayListOf()
        this.notifyDataSetChanged()
    }
}