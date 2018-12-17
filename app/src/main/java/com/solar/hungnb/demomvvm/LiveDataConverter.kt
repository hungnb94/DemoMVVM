package com.solar.hungnb.demomvvm

import android.arch.lifecycle.MutableLiveData

object LiveDataConverter {
    @JvmStatic
    fun toString(data: MutableLiveData<Int>) = "${data.value}"
}