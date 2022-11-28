package com.iamquan.exambroacastreceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class TestBroadcast(val useText: (String?) -> Unit ={}) : BroadcastReceiver() {
    private var textSent: String? = ""

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == "android.net.wifi.WIFI_STATE_CHANGED") {
            Toast.makeText(p0, "wifi change", Toast.LENGTH_SHORT).show()
        }

        if (p1?.action == "MY_ACTION") {
            textSent = p1.getStringExtra("TEXT_SENT")
            Toast.makeText(p0, textSent, Toast.LENGTH_SHORT).show()
            useText(textSent)
        }
    }
}