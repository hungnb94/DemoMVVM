package com.solar.hungnb.demomvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    var count: MutableLiveData<Int> = MutableLiveData()

    init {
        count.value = 0
    }
}