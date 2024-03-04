package com.hbb.eyepetizer.ui.common.callback

interface RequestLifecycle {
    fun startLoading()

    fun loadFinished()

    fun loadFailed()
}