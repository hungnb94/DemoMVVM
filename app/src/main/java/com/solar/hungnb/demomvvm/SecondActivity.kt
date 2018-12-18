package com.solar.hungnb.demomvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.solar.hungnb.demomvvm.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySecondBinding>(this, R.layout.activity_second)
        val viewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        binding.countViewModel = viewModel
    }
}
