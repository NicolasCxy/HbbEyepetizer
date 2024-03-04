package com.hbb.eyepetizer.util

import com.hbb.eyepetizer.MyApplication

object GlobalUtil {


    /**
     * 获取应用程序名称
     */
    val appName:String
        get() = MyApplication.context.resources.getString(MyApplication.context.applicationInfo.labelRes)

    /**
     * 获取资源中的字符串
     */
    fun getString(resId: Int): String = MyApplication.context.resources.getString(resId)
}