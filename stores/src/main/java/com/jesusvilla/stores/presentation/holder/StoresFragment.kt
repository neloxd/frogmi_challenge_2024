package com.jesusvilla.stores.presentation.holder

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jesusvilla.base.ui.BaseFragment
import com.jesusvilla.base.ui.getInsetDividerItemDecoration
import com.jesusvilla.stores.R
import com.jesusvilla.stores.databinding.FragmentStoresBinding
import com.jesusvilla.stores.domain.model.AnyStore
import com.jesusvilla.stores.domain.model.BaseStore
import com.jesusvilla.stores.presentation.adapter.StoresAdapter
import com.jesusvilla.stores.viewModel.StoresViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class StoresFragment: BaseFragment<FragmentStoresBinding>(FragmentStoresBinding::inflate) {

    private val viewModel: StoresViewModel by hiltNavGraphViewModels(R.id.stores_graph)
    override fun getBaseViewModel() = viewModel

    private val adapter by lazy {
        setupAdapter()
    }

    private val scrollListener by lazy {
        setupRvScrollListener()
    }


    override fun setupUI() {
        super.setupUI()
        with(binding) {
            list.adapter = adapter
            list.addItemDecoration(getInsetDividerItemDecoration())
            list.addOnScrollListener(scrollListener)
        }
        viewModel.getStores()
        //viewModel.getLocalList(requireContext())
    }

    override fun setUpObservers() {
        super.setUpObservers()
        viewModel.getStoresList().observe(viewLifecycleOwner) { setItems(it) }
    }

    private fun setupAdapter() = StoresAdapter(requireContext())

    private fun setupRvScrollListener() = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            recyclerView.layoutManager?.let {
                //if (mIsLoading) return
                val visibleItemCount: Int = it.childCount
                val totalItemCount: Int = it.getItemCount()
                val pastVisibleItems: Int = (it as LinearLayoutManager).findFirstVisibleItemPosition()
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    //End of list
                    if(adapter.getItems().last() is AnyStore && !viewModel.getShowMoreLoading()) {
                        viewModel.getStores(showMore = true)
                    }
                }
            }
        }
    }

    private fun setItems(items: List<BaseStore>) {
        adapter.updateData(items)
    }
}