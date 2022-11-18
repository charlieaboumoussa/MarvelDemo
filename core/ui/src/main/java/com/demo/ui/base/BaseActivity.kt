package com.demo.ui.base

import android.app.Dialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope

import com.demo.common.state.Resource
import com.demo.ui.R
import kotlinx.coroutines.launch

open class BaseActivity : ComponentActivity() {

    private lateinit var _loadingDialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            attachViewModel()?.uiBaseState?.collect {
                it?.let {
                    when(it) {
                        is Resource.Loading->{
                            it.data?.let { isLoading->
                                if(isLoading){
                                    showLoading()
                                }else{
                                    hideLoading()
                                }
                            }
                        }
                        is Resource.Error->{
                            it.message?.let {
                                when(it){
                                    "0"->{
                                        showError(getString(R.string.error_default_service))
                                    }
                                    else->{
                                        showError(it)
                                    }
                                }
                            }
                        }
                        else->{

                        }
                    }
                }
            }
        }
    }

    fun showLoading() {
        _loadingDialog.show()
    }

    fun hideLoading() {
        _loadingDialog.hide()
    }

    fun showError(errorMessage : String) {
        // TODO[11/17/2022]: Show Error
    }

    fun attachViewModel() : BaseViewModel? = null
}