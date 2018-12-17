package com.solar.hungnb.demomvvm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

class CountViewModel constructor(application: Application) : AndroidViewModel(application) {

    var count: MutableLiveData<Int> = MutableLiveData()

    init {
        count.value = 0
    }
}