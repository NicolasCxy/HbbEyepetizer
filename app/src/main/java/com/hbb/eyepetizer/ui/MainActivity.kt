package com.hbb.eyepetizer.ui

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.databinding.ActivityMainBinding
import com.hbb.eyepetizer.exension.setOnClickListener
import com.hbb.eyepetizer.exension.showToast
import com.hbb.eyepetizer.ui.common.base.BaseActivity
import com.hbb.eyepetizer.ui.community.CommunityFragment
import com.hbb.eyepetizer.ui.home.HomePageFragment
import com.hbb.eyepetizer.ui.login.LoginActivity
import com.hbb.eyepetizer.ui.mine.MineFragment
import com.hbb.eyepetizer.ui.notification.NotificationFragment
import com.hbb.eyepetizer.util.GlobalUtil

class MainActivity : BaseActivity<ActivityMainBinding>(block = { inflater ->
    ActivityMainBinding.inflate(inflater)
}) {

    private var backPressTime = 0L

    private var homePageFragment: HomePageFragment? = null

    private var communityFragment: CommunityFragment? = null

    private var notificationFragment: NotificationFragment? = null

    private var mineFragment: MineFragment? = null

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }


    override fun setUpView() {
        setOnClickListener(
            mBinding.navigationBar.btnHomePage,
            mBinding.navigationBar.btnCommunity,
            mBinding.navigationBar.btnNotification,
            mBinding.navigationBar.ivRelease,
            mBinding.navigationBar.btnMine
        ) {
            when (this) {
                mBinding.navigationBar.btnHomePage ->{
                    notificationUiRefresh(0)
                    setTabSelection(0)
                }
                mBinding.navigationBar.btnCommunity ->{
                    notificationUiRefresh(1)
                    setTabSelection(1)
                }
                mBinding.navigationBar.btnNotification ->{
                    notificationUiRefresh(2)
                    setTabSelection(2)
                }
                mBinding.navigationBar.ivRelease ->{
                    LoginActivity.start(this@MainActivity)
                }
                mBinding.navigationBar.btnMine ->{
                    notificationUiRefresh(3)
                    setTabSelection(3)
                }
            }
        }
        setTabSelection(0)

    }

    private fun setTabSelection(index: Int) {
        clearAllSelected()
        fragmentManager.beginTransaction().apply {
            hideFragments(this)
            when(index){
                0 -> {
                    mBinding.navigationBar.ivHomePage.isSelected = true
                    mBinding.navigationBar.tvHomePage.isSelected = true

                    if(homePageFragment == null){
                        homePageFragment =  HomePageFragment.newInstance()
                        add(R.id.mainActivityFragContainer,homePageFragment!!)
                    }else{
                        show(homePageFragment!!)
                    }
                }
                1 -> {
                    mBinding.navigationBar.ivCommunity.isSelected = true
                    mBinding.navigationBar.tvCommunity.isSelected = true
                    if (communityFragment == null) {
                        communityFragment = CommunityFragment.newInstance()
                        add(R.id.mainActivityFragContainer, communityFragment!!)
                    } else {
                        show(communityFragment!!)
                    }
                }
                2 -> {
                    mBinding.navigationBar.ivNotification.isSelected = true
                    mBinding.navigationBar.tvNotification.isSelected = true

                    if (notificationFragment == null) {
                        notificationFragment = NotificationFragment.newInstance()
                        add(R.id.mainActivityFragContainer, notificationFragment!!)
                    } else {
                        show(notificationFragment!!)
                    }
                }
                3 -> {
                    mBinding.navigationBar.ivMine.isSelected = true
                    mBinding.navigationBar.tvMine.isSelected = true
                    if (mineFragment == null) {
                        mineFragment = MineFragment.newInstance()
                        add(R.id.mainActivityFragContainer, mineFragment!!)
                    } else {
                        show(mineFragment!!)
                    }
                }
                else -> {
                    mBinding.navigationBar.ivHomePage.isSelected = true
                    mBinding.navigationBar.tvHomePage.isSelected = true

                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.mainActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }
            }

        }.commitAllowingStateLoss()
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        transaction.run {
            if (homePageFragment != null) hide(homePageFragment!!)
            if (communityFragment != null) hide(communityFragment!!)
            if (notificationFragment != null) hide(notificationFragment!!)
            if (mineFragment != null) hide(mineFragment!!)
        }
    }

    private fun clearAllSelected() {
        mBinding.navigationBar.ivHomePage.isSelected = false
        mBinding.navigationBar.tvHomePage.isSelected = false
        mBinding.navigationBar.ivCommunity.isSelected = false
        mBinding.navigationBar.tvCommunity.isSelected = false
        mBinding.navigationBar.ivNotification.isSelected = false
        mBinding.navigationBar.tvNotification.isSelected = false
        mBinding.navigationBar.ivMine.isSelected = false
        mBinding.navigationBar.tvMine.isSelected = false
    }

    private fun notificationUiRefresh(selectionIndex: Int) {
        when(selectionIndex){
            0 -> {}
            1 -> {}
            2 -> {}
            3 -> {}
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val now = System.currentTimeMillis()
        if (now - backPressTime > 2000L) {
            String.format(GlobalUtil.getString(R.string.press_again_to_exit), GlobalUtil.appName)
                .showToast()
            backPressTime = now
        } else {
            super.onBackPressed()
        }

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}