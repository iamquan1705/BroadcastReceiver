package com.iamquan.exambroacastreceiver

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.iamquan.exambroacastreceiver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var testBroadcast: TestBroadcast
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        testBroadcast = TestBroadcast(useText = {
            Log.d("iamquan1705", it.toString())
            binding.tvEnd.text = it
        })
        binding.btnSent.setOnClickListener {
            clickSentBroadCast()
        }

        val intentWifi = IntentFilter("android.net.wifi.WIFI_STATE_CHANGED")
        registerReceiver(testBroadcast, intentWifi)


        //Đăng kí nhận
        val intentText = IntentFilter("MY_ACTION")
        registerReceiver(testBroadcast,intentText)


//        //Đăng kí nhận khi dùng  localBroadcastReceiver
//        val filter = IntentFilter("MY_ACTION")
//        LocalBroadcastManager.getInstance(this).registerReceiver(testBroadcast, filter);
//
//        //Đăng kí nhận với quyền
//        val intentT = IntentFilter("MY_ACTION")
//        registerReceiver(testBroadcast, intentT, Manifest.permission.ACCESS_NETWORK_STATE, null)
    }

    private fun clickSentBroadCast() {
        // Gửi broadcast
        val intent = Intent("MY_ACTION")
        intent.putExtra("TEXT_SENT", "Hello Iam Quan")
        sendBroadcast(intent)
//        // Gửi broadcast với localBroadcastReceiver
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//        // Gửi broadcast với permisstion
//        sendBroadcast(intent, Manifest.permission.ACCESS_NETWORK_STATE)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(testBroadcast)
    }
}