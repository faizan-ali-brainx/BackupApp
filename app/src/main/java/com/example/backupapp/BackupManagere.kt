package com.example.backupapp

import android.app.backup.BackupManager
import android.content.Context


class BackupManagere(private val context: Context) {

    private val PREFS_NAME = "MyPrefs"
    private val PREF_KEY = "data_backup_key_2"

    private val backupManager = BackupManager(context)

    fun backup() {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_KEY, "203030000").apply()
        backupManager.dataChanged()
    }

    fun restore(): String {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY, null) ?: ""
    }
}
