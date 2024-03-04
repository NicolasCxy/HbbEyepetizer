package com.hbb.eyepetizer.ui.common.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hbb.eyepetizer.event.MessageEvent
import com.hbb.eyepetizer.exension.logD
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected var _binding: VB? = null

    protected val binding: VB
        get() = _binding!!


    /**
     * Fragment中inflate出来的布局。
     */
    protected var rootView: View? = null

    /**
     * 是否加载过数据
     */
    var mHasLoadedData: Boolean = false

    /**
     * 依附的activity
     */
    protected lateinit var activity: Activity

    /**
     * Fragment中显示加载等待的控件。
     */
    protected var loading: ProgressBar? = null

    /**
     * 日志TAG
     */
    protected val TAG: String = this.javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 缓存当前依附的activity
        activity = requireActivity()
        logD(TAG, "BaseFragment-->onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(TAG, "BaseFragment-->onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logD(TAG, "BaseFragment-->onCreateView()")
        _binding = initDataBinding(container)
        return onCreateView(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD(TAG, "BaseFragment-->onViewCreated()")
        init()
    }

    override fun onStart() {
        super.onStart()
        logD(TAG, "BaseFragment-->onStart()")
    }

    override fun onResume() {
        super.onResume()
        logD(TAG, "BaseFragment-->onResume()")
        //当Fragment在屏幕上可见并且没有加载过数据时调用
        if (!mHasLoadedData) {
            loadDataOnce()
            logD(TAG, "BaseFragment-->loadDataOnce()")
            mHasLoadedData = true
        }
    }

    /**
     * 页面可见时，加载数据（前提之前没加载过）
     */
    open fun loadDataOnce() {
    }

    override fun onPause() {
        super.onPause()
        logD(TAG, "BaseFragment-->onPause()")
    }

    override fun onStop() {
        super.onStop()
        logD(TAG, "BaseFragment-->onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logD(TAG, "BaseFragment-->onDestroyView()")
        EventBus.getDefault().unregister(this)
        _binding = null
        if (rootView?.parent != null) (rootView?.parent as ViewGroup).removeView(rootView)  //防止异常
    }

    override fun onDestroy() {
        super.onDestroy()
        logD(TAG, "BaseFragment-->onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        logD(TAG, "BaseFragment-->onDetach()")
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(messageEvent: MessageEvent) {
        logD(TAG, "BaseFragment-->onMessageEvent()")
    }

    fun onCreateView(view: View): View {
        logD(TAG, "BaseFragment-->onCreateView()")
        rootView = view
//        loading =  view.findViewById(R.id.loading)
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this)
        return view
    }


    protected abstract fun initDataBinding(container: ViewGroup?): VB

    protected abstract fun init()

}