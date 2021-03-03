package com.blood.mactest.util

import android.widget.Toast
import com.blood.mactest.main.MainApp

class ToastUtil {

    companion object {

        fun toast(msg: String?) {
            val toast = Toast.makeText(MainApp.context(), "", Toast.LENGTH_SHORT)
            toast.setText(msg)
            toast.show()
        }

    }

}