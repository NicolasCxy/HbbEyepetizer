package com.hbb.eyepetizer.ui.daliy

import android.view.ViewGroup
import com.hbb.eyepetizer.databinding.FragmentRefreshLayoutBinding
import com.hbb.eyepetizer.ui.common.base.BaseFragment

class DailyFragment: BaseFragment<FragmentRefreshLayoutBinding>() {

    override fun initDataBinding(container: ViewGroup?): FragmentRefreshLayoutBinding {
        return FragmentRefreshLayoutBinding.inflate(layoutInflater,container,false).also {
            _binding = it
        }
    }

    override fun init() {
    }


    companion object{
        fun newInstance() = DailyFragment()
    }
}