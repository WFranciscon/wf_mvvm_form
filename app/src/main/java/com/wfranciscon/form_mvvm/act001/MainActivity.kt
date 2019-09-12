package com.wfranciscon.form_mvvm.act001

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wfranciscon.form_mvvm.R
import com.wfranciscon.form_mvvm.act002.ServicesWF
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var context: Context

private lateinit var mViewModel: MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()

        InitActions()


    }

    private fun initVars() {

        context = this

        mViewModel = ViewModelProviders
            .of(this)
            .get(MainActivityViewModel::class.java)


        mViewModel.responseError.observe(this, Observer {
            val alerta = AlertDialog.Builder(context)
            alerta.setTitle("Atenção")
            alerta.setMessage(it!!)
            alerta.setCancelable(false)
            alerta.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            })
            alerta.show()
            limparFormula()
        })

        mViewModel.responseNav.observe(this, Observer {
            val mIntent = Intent (
                context,
                ServicesWF::class.java)
            startActivity(mIntent)
        })
    }


    private fun InitActions() {

        act001_btnvalidar.setOnClickListener {
            mViewModel.processLogin(
                act001_etname.text.toString(),
                act001_etemail.text.toString()
            )
        }

    }

    private fun limparFormula() {
        act001_etname.setText("")
        act001_etemail.setText("")

        act001_etname.requestFocus()
    }
}
