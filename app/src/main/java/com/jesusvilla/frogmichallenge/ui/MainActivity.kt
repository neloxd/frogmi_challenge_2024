package com.jesusvilla.frogmichallenge.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.jesusvilla.base.ui.BaseActivity
import com.jesusvilla.base.viewModel.BaseViewModel
import com.jesusvilla.frogmichallenge.R
import com.jesusvilla.frogmichallenge.databinding.ActivityMainBinding
import com.jesusvilla.frogmichallenge.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController
    private val viewModel: MainViewModel by viewModels()
    override fun getBaseViewModel(): BaseViewModel = viewModel
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initNavController() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment? ?: return
        navController = host.navController
        val mainGraph = navController.navInflater.inflate(R.navigation.main_graph)
        mainGraph.setStartDestination(com.jesusvilla.stores.R.id.stores_graph)
        navController.graph = mainGraph
    }

    override fun initViews() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}