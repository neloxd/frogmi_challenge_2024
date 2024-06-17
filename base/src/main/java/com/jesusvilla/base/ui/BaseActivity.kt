package com.jesusvilla.base.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.jesusvilla.base.extension.makeToastLong
import com.jesusvilla.base.viewModel.BaseViewModel
import com.jesusvilla.core.network.data.AuthenticationListener
import com.jesusvilla.core.network.data.Session
import timber.log.Timber

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    //region override region
    abstract fun getBaseViewModel(): BaseViewModel

    abstract fun getViewBinding(): VB

    protected fun setupObservers() {
    }

    abstract fun initNavController()

    //temp
    abstract fun initViews()
    //endregion

    //region Sesion
    private fun initSessionListener() {
        Session.authenticationListener = object : AuthenticationListener {
            override fun onUserLoggedOut() {
                //viewModel.logOut()
                revokeSession()
            }
        }
    }

    private fun revokeSession() {
        runOnUiThread {
            try {
                makeToastLong("SESSION EXPIRADA VALIDAR VALORES EN CABECERA")
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = getViewBinding()
        setContentView(_binding!!.root)
        initViews()
        setupObservers()
        initNavController()
        initSessionListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}