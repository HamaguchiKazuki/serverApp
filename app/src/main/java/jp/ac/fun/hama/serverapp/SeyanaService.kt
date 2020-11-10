package jp.ac.`fun`.hama.serverapp

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import android.os.Process
import android.util.Log

class SeyanaService : Service() {
    private val tag: String = this::class.java.simpleName

    private val mBinder = object : ISeyanaService.Stub() {
        override fun returnFixedLetter(): String {
            val seyanaGachaList: Array<String> = arrayOf("Seyana", "Sorena" , "Wakaru")
            val seyanaOnePick: String = seyanaGachaList.get((0..2).shuffled().first())
            Log.d(tag, "${seyanaOnePick} return fixed letter implemented")
            return seyanaOnePick
        }

        override fun streamSeyana() {
            Log.d(tag, "streamSeyana")
            val uri = "https://www.youtube.com/watch?v=OVuYIMa5XBw&t=12s&ab_channel=GYARI"
            Intent(Intent.ACTION_VIEW).also { seyanaIntent ->
                seyanaIntent.data = Uri.parse(uri)
                seyanaIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(seyanaIntent)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(tag, "bind")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(tag, "unbind")
        return super.onUnbind(intent)
    }
}