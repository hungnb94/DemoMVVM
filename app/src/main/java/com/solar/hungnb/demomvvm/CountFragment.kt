package com.solar.hungnb.demomvvm

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solar.hungnb.demomvvm.databinding.FragmentCountBinding


class CountFragment : Fragment() {
    private val TAG = CountFragment::class.java.simpleName
    lateinit var viewModel: CountViewModel
    private var listener: View.OnClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(CountViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCountBinding>(inflater, R.layout.fragment_count, container, false)
        binding.setLifecycleOwner(this)
        binding.countViewModel = viewModel

        binding.btnAdd.setOnClickListener { increase() }
        binding.btnSub.setOnClickListener { decrease() }
        binding.btnNextFragment.setOnClickListener(listener)

        return binding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is View.OnClickListener) listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    private fun nextFragment() {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(android.R.id.content, ShowValueFragment())
                ?.addToBackStack(ShowValueFragment::class.java.simpleName)
                ?.commit()

//        startActivity(Intent(activity, SecondActivity::class.java))
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
