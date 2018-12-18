package com.solar.hungnb.demomvvm

import android.arch.lifecycle.MutableLiveData

object LiveDataConverter {
    @JvmStatic
    fun toString(data: MutableLiveData<Int>) = if (data.value != null) "${data.value}" else "0"
}