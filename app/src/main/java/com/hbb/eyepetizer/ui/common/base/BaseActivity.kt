package com.hbb.eyepetizer.ui.common.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ImmersionBar
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.event.MessageEvent
import com.hbb.eyepetizer.exension.logD
import com.hbb.eyepetizer.util.ActivityCollector
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

/**
 * 1、定义DataBinding
 * 2、添加到栈中，方便管理
 * 3、EventBus注册
 */
open class BaseActivity<VB : ViewBinding>(
    val block: (LayoutInflater) -> VB,
    val autoSetUpView: Boolean = true
) : AppCompatActivity() {

    private var _binding: VB? = null

    protected val mBinding: VB
        get() = _binding!!

    /**
     * 判断当前Activity是否在前台。
     */
    protected var isActive: Boolean = false

    /**
     * 当前activity
     */
    protected var activity: Activity? = null;

    private var activityWR: WeakReference<Activity>? = null

    /**
     * 日志输出标识
     */
    protected val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity = this;
        activityWR = WeakReference(activity!!)
        ActivityCollector.pushTask(activityWR)
        EventBus.getDefault().register(this)

        _binding = block(layoutInflater)
        setContentView(mBinding.root)
    }


    override fun setContentView(layoutView: View?) {
        super.setContentView(layoutView)
        setStatusBarBackground(R.color.colorPrimaryDark)
        if (autoSetUpView)
            setUpView()
    }

    protected open fun setUpView() {
        //标题和返回键
        Log.d(TAG, "setUpView: ")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logD(TAG, "BaseActivity-->onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logD(TAG, "BaseActivity-->onRestoreInstanceState()")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        logD(TAG, "BaseActivity-->onNewIntent()")
    }

    override fun onRestart() {
        super.onRestart()
        logD(TAG, "BaseActivity-->onRestart()")
    }

    override fun onStart() {
        super.onStart()
        logD(TAG, "BaseActivity-->onStart()")
    }

    override fun onResume() {
        super.onResume()
        logD(TAG, "BaseActivity-->onResume()")
        isActive = true
//        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        logD(TAG, "BaseActivity-->onPause()")
        isActive = false
//        MobclickAgent.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        logD(TAG, "BaseActivity-->onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logD(TAG, "BaseActivity-->onDestroy()")
        _binding = null
        activity = null
        ActivityCollector.removeTask(activityWR)
        EventBus.getDefault().unregister(this)
    }


    /**
     * 设置状态栏背景色
     */
    open fun setStatusBarBackground(@ColorRes statusBarColor: Int) {
        ImmersionBar.with(this).autoStatusBarDarkModeEnable(true, 0.2f)
            .statusBarColor(statusBarColor).fitsSystemWindows(true).init()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(event: MessageEvent) {

    }


}