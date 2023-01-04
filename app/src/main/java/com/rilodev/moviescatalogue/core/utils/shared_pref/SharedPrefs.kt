package com.rilodev.moviescatalogue.core.utils.shared_pref

import android.content.Context
import com.rilodev.moviescatalogue.core.utils.Constants.PREFS_APPS

class SharedPrefs(context: Context) {
    private val preferences: android.content.SharedPreferences = context.getSharedPreferences(PREFS_APPS, Context.MODE_PRIVATE)

    fun setValueString(KEY_NAME: String, string: String){
        val editor = preferences.edit()
        editor.putString(KEY_NAME, string)
        editor.apply()
    }
    fun getValueString(KEY_NAME: String, defaultValue: String): String {
        return preferences.getString(KEY_NAME, defaultValue).toString()
    }

    fun clearSharedPref() {
        preferences.edit().clear().apply()
    }
}