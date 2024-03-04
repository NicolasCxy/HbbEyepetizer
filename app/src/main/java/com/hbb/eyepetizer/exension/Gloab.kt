package com.hbb.eyepetizer.exension

import android.view.View

/**
 * 点击事件监听
 */
fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
    val listener = View.OnClickListener { it.block() }
    v.forEach { view -> view?.setOnClickListener(listener) }

}