package com.hbb.eyepetizer.ui.mine

import android.view.ViewGroup
import com.hbb.eyepetizer.databinding.FragmentMineBinding
import com.hbb.eyepetizer.ui.common.base.BaseFragment

class MineFragment: BaseFragment<FragmentMineBinding>() {

    override fun initDataBinding(container: ViewGroup?): FragmentMineBinding {
        return FragmentMineBinding.inflate(layoutInflater,container,false).also {
            _binding = it
        }
    }

    override fun init() {

    }

    companion object{
        fun newInstance() = MineFragment()
    }
}