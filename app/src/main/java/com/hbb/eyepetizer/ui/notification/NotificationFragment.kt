package com.hbb.eyepetizer.ui.notification

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.hbb.eyepetizer.data.TabEntity
import com.hbb.eyepetizer.databinding.FragmentMainContainerBinding
import com.hbb.eyepetizer.ui.common.base.BaseViewPagerFragment
import com.hbb.eyepetizer.util.GlobalUtil
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.ui.common.base.BaseFragment
import com.hbb.eyepetizer.ui.mine.MineFragment

class NotificationFragment : BaseFragment<FragmentMainContainerBinding>(){

    //    override val createTitles = ArrayList<CustomTabEntity>().apply {
//        add(TabEntity(GlobalUtil.getString(R.string.push)))
//        add(TabEntity(GlobalUtil.getString(R.string.interaction)))
//        add(TabEntity(GlobalUtil.getString(R.string.inbox)))
//    }
//
//    override val createFragments: Array<Fragment> = arrayOf(PushFragment.newInstance(), InteractionFragment.newInstance(), InboxFragment.newInstance())
//
//    override fun initDataBinding(container: ViewGroup?): FragmentMainContainerBinding {
//        TODO("Not yet implemented")
//    }
//
//    override fun init() {
//        TODO("Not yet implemented")
//    }
    override fun initDataBinding(container: ViewGroup?): FragmentMainContainerBinding {
        return FragmentMainContainerBinding.inflate(layoutInflater, container, false).also {
            _binding = it
        }
    }

    override fun init() {
    }


    companion object{
        fun newInstance() = NotificationFragment()
    }

}