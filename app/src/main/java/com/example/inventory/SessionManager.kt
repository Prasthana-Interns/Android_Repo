package com.example.inventory

import android.content.Context
import android.content.SharedPreferences
import com.example.inventory.Constants.PREFS_TOKEN_FILE
import com.example.inventory.Constants.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManager  @Inject constructor(@ApplicationContext context: Context) {
        private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_TOKEN_FILE , Context.MODE_PRIVATE)
//    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)


    //Function to save auth token
        fun saveAuthToken(token: String) {
            val editor = prefs.edit()
            editor.putString(USER_TOKEN, token)
            editor.apply()
        }
        //Function to fetch auth token
        fun fetchAuthToken(): String? {
            return prefs.getString(USER_TOKEN, null)
        }
}
