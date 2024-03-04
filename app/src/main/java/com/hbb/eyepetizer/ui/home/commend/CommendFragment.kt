package com.hbb.eyepetizer.ui.home.commend

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hbb.eyepetizer.databinding.FragmentRefreshLayoutBinding
import com.hbb.eyepetizer.ui.common.base.BaseFragment

class CommendFragment: BaseFragment<FragmentRefreshLayoutBinding>() {

    override fun initDataBinding(container: ViewGroup?): FragmentRefreshLayoutBinding {
        return FragmentRefreshLayoutBinding.inflate(layoutInflater,container,false).also {
            _binding = it
        }
    }

    override fun init() {
    }


    companion object{
        fun onInstance() = CommendFragment()
    }
}