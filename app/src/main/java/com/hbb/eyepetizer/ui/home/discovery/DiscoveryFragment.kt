package com.hbb.eyepetizer.ui.home.discovery

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hbb.eyepetizer.databinding.FragmentRefreshLayoutBinding
import com.hbb.eyepetizer.ui.common.base.BaseFragment

class DiscoveryFragment : BaseFragment<FragmentRefreshLayoutBinding>() {

    override fun initDataBinding(container: ViewGroup?): FragmentRefreshLayoutBinding {
        return FragmentRefreshLayoutBinding.inflate(layoutInflater,container,false).also {
            _binding = it
        }
    }

    override fun init() {

    }


    companion object {
        fun newInstance() = DiscoveryFragment()
    }
}