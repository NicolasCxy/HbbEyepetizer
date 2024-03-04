package com.hbb.eyepetizer.ui.common.base

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.exension.setOnClickListener
import com.hbb.eyepetizer.exension.showToast

abstract class BaseViewPagerFragment<VB : ViewBinding> : BaseFragment<VB>() {

    protected var ivCalendar: ImageView? = null

    protected var ivSearch: ImageView? = null

    protected var viewPager: ViewPager2? = null

    protected var tabLayout: CommonTabLayout? = null

    protected var offscreenPageLimit = 1

    protected val adapter: VpAdapter by lazy { VpAdapter(requireActivity()).apply { addFragments(createFragments) } }

    abstract val createTitles: ArrayList<CustomTabEntity>

    abstract val createFragments: Array<Fragment>

    protected var pageChangeCallBack: PageChangeCallBack? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        //title相关按钮点击事件
        ivCalendar = rootView?.findViewById(R.id.ivCalendar)
        ivSearch = rootView?.findViewById(R.id.ivSearch)

        setOnClickListener(ivCalendar, ivSearch) {
            setOnClickListener(ivCalendar, ivSearch) {
                if (this == ivCalendar) {
                    R.string.currently_not_supported.showToast()
                } else if (this == ivSearch) {
//                    SearchFragment.switchFragment(activity)
                }
            }
        }
        initViewPager()

    }

    private fun initViewPager() {
        viewPager = rootView?.findViewById(R.id.viewPager)
        tabLayout = rootView?.findViewById(R.id.tabLayout)

        viewPager?.offscreenPageLimit = offscreenPageLimit
        viewPager?.adapter = adapter
        //设置监听，和titleLayout关联
        tabLayout?.setTabData(createTitles)
        tabLayout?.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                viewPager?.currentItem = position
            }

            override fun onTabReselect(position: Int) {
            }

        })

        pageChangeCallBack = PageChangeCallBack(tabLayout)
        viewPager?.registerOnPageChangeCallback(pageChangeCallBack!!)
    }


    class PageChangeCallBack(val tabLayout: CommonTabLayout?) : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            tabLayout?.currentTab = position
        }
    }


    class VpAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        private val fragments = mutableListOf<Fragment>()

        fun addFragments(fragment: Array<Fragment>) {
            fragments.addAll(fragment)
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        pageChangeCallBack?.run { viewPager?.unregisterOnPageChangeCallback(this) }
        pageChangeCallBack = null
    }

}