package com.ProiectSI

import android.content.res.Resources

class KotlinUtils {
    companion object {
        val Int.dP: Int
            get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

        val Float.dP: Int
            get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

        val Double.dP:Int
            get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

        val Int?.toBoolean: Boolean
            get() = this?.let { it != 0 } ?: false
    }
}