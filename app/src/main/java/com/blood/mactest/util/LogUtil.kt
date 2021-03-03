package com.blood.mactest.util

import android.util.Log

class LogUtil {

    companion object {

        private const val TAG = "LogUtil"

        fun log(msg: String) {
            Log.i(TAG, ">>> $msg")
        }
    }

}