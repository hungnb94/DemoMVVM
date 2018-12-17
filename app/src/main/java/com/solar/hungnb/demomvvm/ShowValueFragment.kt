package com.solar.hungnb.demomvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solar.hungnb.demomvvm.databinding.FragmentShowValueBinding

class ShowValueFragment : Fragment() {
    private val TAG = ShowValueFragment::class.java.simpleName

    lateinit var viewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(CountViewModel::class.java)
        Log.e(TAG, "${viewModel.count.value}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentShowValueBinding>(inflater, R.layout.fragment_show_value, container, false)
        binding.setLifecycleOwner(this)

        binding.countViewModel = viewModel
        return binding.root
    }
}
