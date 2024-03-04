package com.hbb.eyepetizer.exension

import android.widget.Toast
import com.hbb.eyepetizer.MyApplication

fun CharSequence.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(MyApplication.context, this, duration).show()
}