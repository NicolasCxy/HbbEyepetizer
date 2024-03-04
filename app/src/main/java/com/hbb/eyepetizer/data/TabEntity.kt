package com.hbb.eyepetizer.data

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(private val title: String, private val selectedIcon: Int = 0, private val unSelectedIcon: Int = 0):CustomTabEntity{
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}