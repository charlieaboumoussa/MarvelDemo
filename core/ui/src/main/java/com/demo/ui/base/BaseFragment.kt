package com.demo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.demo.common.state.Resource
import com.demo.ui.R
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

abstract class BaseFragment : Fragment() {

    protected var hasInitializedRootView = AtomicBoolean(false)
    private var _rootView: View? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        onViewCreatedBase(view, savedInstanceState)
    }

    fun showLoading() {
        (requireActivity() as BaseActivity).showLoading()
    }

    fun hideLoading() {
        (requireActivity() as BaseActivity).hideLoading()
    }

    fun showError(errorMessage : String) {
//        MaterialAlertDialogBuilder(requireContext(), R.style.Lovoo_Style_NativeDialog)
//            .setTitle(getString(R.string.service_error))
//            .setMessage(errorMessage)
//            .setCancelable(true)
//            .setPositiveButton(android.R.string.ok, object : DialogInterface.OnClickListener {
//                override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
//                    dialogInterface?.dismiss()
//                }
//            }).show()
    }

    fun getPersistentView(layout: Int, inflater: LayoutInflater, container: ViewGroup?): View {
        if (_rootView == null) {
            // Inflate the layout for this fragment
            _rootView = inflater.inflate(layout, container,false)
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (_rootView?.getParent() as? ViewGroup)?.removeView(_rootView)
        }

        return _rootView!!
    }

    fun getBindingPersistentView(view : View): View {
        if (_rootView == null) {
            _rootView = view
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (_rootView?.getParent() as? ViewGroup)?.removeView(_rootView)
        }

        return _rootView!!
    }

    abstract fun attachViewModel() : BaseViewModel?

    abstract fun onViewCreatedBase(view: View, savedInstanceState: Bundle?)
}