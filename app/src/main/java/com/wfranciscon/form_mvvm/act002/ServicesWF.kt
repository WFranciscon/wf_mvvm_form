package com.wfranciscon.form_mvvm.act002

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wfranciscon.form_mvvm.R

class ServicesWF : AppCompatActivity(){

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.services_wf)


        initVars()

        InitActions()


    }

    private fun initVars() {

        context = this@ServicesWF

    }

    private fun InitActions() {

    }
}