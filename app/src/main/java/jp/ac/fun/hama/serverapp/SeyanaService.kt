package jp.ac.`fun`.hama.serverapp

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import android.util.Log

class SeyanaService : Service() {
    private val tag: String = this::class.java.simpleName

    private val mBinder = object : ISeyanaService.Stub() {
        override fun returnFixedLetter(): String {
            Log.d(tag, "Seyana. return fixed letter implemented")
            return "Seyana."
        }

        override fun streamSeyana() {
            Log.d(tag, "streamSeyana")
            val uri = "https://www.youtube.com/watch?v=OVuYIMa5XBw&t=12s&ab_channel=GYARI"
//            val packageName = "com.google.android.youtube"
//            val className = "com.google.android.youtube.app.honeycomb.Shell\\\$HomeActivity"
            Intent(Intent.ACTION_VIEW).also { seyanaIntent ->
                seyanaIntent.data = Uri.parse(uri)
//                seyanaIntent.setClassName(packageName,className)
                seyanaIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(seyanaIntent)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }
}