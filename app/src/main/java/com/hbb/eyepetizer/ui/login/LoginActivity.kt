package com.hbb.eyepetizer.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hbb.eyepetizer.R
import com.hbb.eyepetizer.databinding.ActivityLoginBinding
import com.hbb.eyepetizer.databinding.ActivityMainBinding
import com.hbb.eyepetizer.ui.common.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(block = { inflater ->
    ActivityLoginBinding.inflate(inflater)
}) {

    override fun setUpView() {
        super.setUpView()

    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context,LoginActivity::class.java))
        }
    }
}