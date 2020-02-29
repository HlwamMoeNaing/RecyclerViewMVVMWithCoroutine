package com.hmn.recyclerviewmvvmwithcoroutine

import android.view.View

interface RecyclerViewListener {
    fun onRecyclerViewItemClick(view: View, result:Result)
}