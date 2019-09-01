package com.ekremozan.note.utils

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.activeNetworkInfo
        return info != null && info.isConnected
    }

    fun isWifiAvailable(context: Context): Boolean {
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

        return mWifi.isConnected
    }

    fun isOnline(context: Context):Boolean{
        return if(isNetworkConnected(context)) {
            isNetworkAvailable(context ) || isWifiAvailable(context)
        } else false

    }
}