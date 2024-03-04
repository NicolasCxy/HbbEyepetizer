package com.hbb.eyepetizer.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.hbb.eyepetizer.ui.common.base.BaseViewPagerFragment
import com.hbb.eyepetizer.util.GlobalUtil
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.data.TabEntity
import com.hbb.eyepetizer.databinding.FragmentMainContainerBinding
import com.hbb.eyepetizer.event.MessageEvent
import com.hbb.eyepetizer.ui.home.commend.CommendFragment
import com.hbb.eyepetizer.ui.home.daily.DailyFragment
import com.hbb.eyepetizer.ui.home.discovery.DiscoveryFragment

class HomePageFragment : BaseViewPagerFragment<FragmentMainContainerBinding>() {

    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity(GlobalUtil.getString(R.string.discovery)))
        add(TabEntity(GlobalUtil.getString(R.string.commend)))
        add(TabEntity(GlobalUtil.getString(R.string.daily)))
    }

    override val createFragments: Array<Fragment> = arrayOf(
        DiscoveryFragment.newInstance(), DailyFragment.newInstance(), CommendFragment.onInstance()
    )

    override fun initDataBinding(container: ViewGroup?): FragmentMainContainerBinding {
        return FragmentMainContainerBinding.inflate(layoutInflater, container, false).also {
            _binding = it
        }
    }

    override fun init() {
        //初始化操作
        binding.titleBar.ivCalendar.visibility = View.VISIBLE
        viewPager?.currentItem = 1
    }


    override fun onMessageEvent(messageEvent: MessageEvent) {
        super.onMessageEvent(messageEvent)

    }


    companion object{
        fun newInstance() = HomePageFragment()
    }






}