package com.iamquan.exambroacastreceiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iamquan.exambroacastreceiver.databinding.ActivityReceiveBinding

class ReceiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}