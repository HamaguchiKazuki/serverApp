package jp.ac.`fun`.hama.serverapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SeyanaService : Service() {
    private val tag: String = this::class.java.simpleName

    private val mBinder = object : ISeyanaService.Stub() {
        override fun returnFixedLetter(): String {
            Log.d(tag, "Seyana. return fixed letter implemented")
            return "Seyana."
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }
}