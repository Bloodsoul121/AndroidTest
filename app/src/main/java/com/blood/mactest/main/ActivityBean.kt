package com.blood.mactest.main

import android.app.Activity
import android.content.Context
import android.content.Intent

class ActivityBean(
    var context: Context,
    var content: String,
    var clazz: Class<out Activity?>
) {
    fun skip() {
        val intent = Intent(context, clazz)
        context.startActivity(intent)
    }
}