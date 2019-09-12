package com.wfranciscon.form_mvvm.act001

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wfranciscon.form_mvvm.R

class MainActivityViewModel: ViewModel() {

    var responseError = MutableLiveData<Int>()
    var responseNav = MutableLiveData<Boolean>()

    fun processLogin(name: String, password: String){

        if (name.trim().isEmpty()){
            responseError.value= R.string.msg_erro_nome

            return
        }
        if (password.trim().isEmpty()){
            responseError.value= R.string.msg_erro_email

            return
        }

        responseNav.value = true
    }
}