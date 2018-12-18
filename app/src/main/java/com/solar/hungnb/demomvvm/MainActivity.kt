package com.solar.hungnb.demomvvm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, CountFragment())
                    .commit()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnNextFragment -> nextFragment()
        }
    }


    private fun nextFragment() {
        supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, ShowValueFragment())
                .addToBackStack(ShowValueFragment::class.java.simpleName)
                .commit()
    }
}
