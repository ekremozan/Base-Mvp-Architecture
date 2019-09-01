package com.ekremozan.note.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object ScreenUtils {

    fun getScreenWidth(context: Context): Int {
        val windowManager = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        return dm.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources
            .getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun convertDpToPixel(dp: Float, context: Context): Float =
         dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)


    fun convertPixelsToDp(px: Float, context: Context): Float =
         px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)

}