package com.example.backupapp

import android.app.backup.*
import android.content.Context

import android.app.backup.BackupAgentHelper
import android.app.backup.SharedPreferencesBackupHelper
import android.os.ParcelFileDescriptor
import android.util.Log

class MyBackupAgent : BackupAgentHelper() {

    private val PREFS_NAME = "MyPrefs"
    private val PREF_KEY = "my_pref_key"

    override fun onCreate() {
        val helper = SharedPreferencesBackupHelper(this, PREFS_NAME)
        addHelper(PREF_KEY, helper)
    }

    override fun onBackup(
        oldState: ParcelFileDescriptor?,
        data: BackupDataOutput?,
        newState: ParcelFileDescriptor?
    ) {
        super.onBackup(oldState, data, newState)
    }

    override fun onRestore(
        data: BackupDataInput?,
        appVersionCode: Int,
        newState: ParcelFileDescriptor?
    ) {
        super.onRestore(data, appVersionCode, newState)
    }
}
