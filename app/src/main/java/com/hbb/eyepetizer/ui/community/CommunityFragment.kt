package com.hbb.eyepetizer.ui.community

import android.view.ViewGroup
import com.hbb.eyepetizer.databinding.FragmentMainContainerBinding
import com.hbb.eyepetizer.ui.common.base.BaseFragment

class CommunityFragment:BaseFragment<FragmentMainContainerBinding>() {

    override fun initDataBinding(container: ViewGroup?): FragmentMainContainerBinding {
        return FragmentMainContainerBinding.inflate(layoutInflater, container, false).also {
            _binding = it
        }
    }

    override fun init() {

    }


    companion object{
        fun newInstance() = CommunityFragment()
    }
}