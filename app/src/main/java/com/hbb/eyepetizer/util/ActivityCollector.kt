package com.hbb.eyepetizer.util

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.Stack

/**
 * Activity管理类
 */
object ActivityCollector {

    private val activitys = Stack<WeakReference<Activity>>()

    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    fun pushTask(task: WeakReference<Activity>?){
        activitys.push(task)
    }

    /**
     * 将Activity从栈中移除
     */
    fun removeTask(task:WeakReference<Activity>?){
        activitys.remove(task)
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    fun removeTask(taskIndex: Int) {
        if (activitys.size > taskIndex) activitys.removeAt(taskIndex)
    }


    /**
     * 只保留栈顶数据
     */
    fun removeToTop(){
        val end = activitys.size
        val start = 1
        for(i in end - 1 downTo start){
            val activity = activitys[i].get()
            if(null != activity && !activity.isFinishing){
                activity.finish()
            }
        }
    }

    /**
     * 移除栈中所有数据
     */
    fun removeAll(){
        for(task in activitys){
            val activity = task.get()
            if(null != activity && !activity.isFinishing){
                activity.finish()
            }
        }
    }

}