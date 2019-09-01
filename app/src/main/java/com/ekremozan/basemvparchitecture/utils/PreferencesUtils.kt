package com.ekremozan.note.utils

import android.content.Context

object PreferencesUtils {
    private var PREFERENCE_NAME = "SharedPreferences"

    fun putString(context: Context, key: String, value: String): Boolean {
        val editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
        editor.putString(key, value)
        return editor.commit()
    }

    @JvmOverloads
    fun getString(context: Context, key: String, defaultValue: String? = null): String? =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getString(
            key,
            defaultValue
        )


    fun putInt(context: Context, key: String, value: Int): Boolean {
        val editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    @JvmOverloads
    fun getInt(context: Context, key: String, defaultValue: Int = -1): Int =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getInt(
            key,
            defaultValue
        )


    fun putLong(context: Context, key: String, value: Long): Boolean {
        val editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
        editor.putLong(key, value)
        return editor.commit()
    }

    @JvmOverloads
    fun getLong(context: Context, key: String, defaultValue: Long = -1): Long =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getLong(
            key,
            defaultValue
        )


    fun putFloat(context: Context, key: String, value: Float): Boolean {
        val editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
        editor.putFloat(key, value)
        return editor.commit()
    }

    @JvmOverloads
    fun getFloat(context: Context, key: String, defaultValue: Float = -1f): Float =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getFloat(
            key,
            defaultValue
        )


    fun putBoolean(context: Context, key: String, value: Boolean): Boolean {
        val editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    @JvmOverloads
    fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getBoolean(
            key,
            defaultValue
        )

}