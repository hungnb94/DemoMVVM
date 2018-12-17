package com.solar.hungnb.demomvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.solar.hungnb.demomvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var viewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.countViewModel = viewModel

        binding.btnAdd.setOnClickListener { increase() }
        binding.btnSub.setOnClickListener { decrease() }
        binding.btnNextFragment.setOnClickListener { nextFragment() }
    }

    private fun nextFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.llRootMain, ShowValueFragment())
                .addToBackStack(ShowValueFragment::class.java.simpleName)
                .commit()
    }

    private fun increase() {
        viewModel.count.value = viewModel.count.value!! + 1
//        viewModel.count.set(viewModel.count.get()!! + 1)
        Log.e(TAG, "Value ${viewModel.count.value}")
    }

    private fun decrease() {
        viewModel.count.value = viewModel.count.value!! - 1
//        viewModel.count.set(viewModel.count.get()!! - 1)
        Log.e(TAG, "Value ${viewModel.count.value}")
    }
}
