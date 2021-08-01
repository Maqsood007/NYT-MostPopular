package com.nyt.mostpopular.ui.mostviewed

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nyt.mostpopular.R
import com.nyt.mostpopular.databinding.FragmentMostViewedBinding
import com.nyt.mostpopular.repository.models.MostViewedResponse
import com.nyt.mostpopular.ui.base.BaseFragment
import com.nyt.mostpopular.ui.mostviewed.adapter.MostViewedArticlesListAdapter
import com.nyt.mostpopular.ui.mostviewed.viewmodel.MostViewedViewModel
import com.nyt.mostpopular.ui.mostviewed.viewmodel.RequestType
import com.nyt.mostpopular.utils.NetworkState

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */

class MostViewedFragment : BaseFragment() {

    private val mostViewedViewModel: MostViewedViewModel by viewModels()

    var fragmentMostViewedBinding: FragmentMostViewedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add Option menu to the fragment.
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMostViewedBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_most_viewed, container, false
        )
        fragmentMostViewedBinding?.viewModel = mostViewedViewModel
        fragmentMostViewedBinding?.setLifecycleOwner { lifecycle }
        return fragmentMostViewedBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentMostViewedBinding?.postList?.setHasFixedSize(true)

        setPullToRefreshListener()

        if (mostViewedViewModel.mostViewedList.value == null) {
            mostViewedViewModel.getMostViewedArticles(RequestType.LOAD)
        } else {
            setUpAdapter()
        }

        addStateObserver()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpAdapter() {

        MostViewedArticlesListAdapter().let {
            fragmentMostViewedBinding?.postList?.adapter = it
            it.updateMostViewedArticles(mostViewedViewModel.mostViewedList.value!!)
            it.notifyDataSetChanged()
        }
    }

    private fun setPullToRefreshListener() {
        // Pull to refresh
        fragmentMostViewedBinding?.pullToRefresh?.setOnRefreshListener {
            mostViewedViewModel.getMostViewedArticles(RequestType.PULL_TO_REFRESH)
        }
    }

    private fun addStateObserver() {

        mostViewedViewModel.mostViewedState.observe(viewLifecycleOwner) {

            when (it) {
                is NetworkState.Success -> {

                    mostViewedViewModel.onFetchMostViewedArticlesFinish()
                    mostViewedViewModel.handleResponse(it.data as MostViewedResponse)
                    setUpAdapter()
                }
                is NetworkState.Failure -> {
                    mostViewedViewModel.handleError(Throwable(it.error as String))
                }
                is NetworkState.Loading -> {
                    mostViewedViewModel.onFetchMostViewedArticlesStart(it.loadingType as RequestType)
                }
            }
        }
    }

    override fun onDestroyView() {
        fragmentMostViewedBinding?.postList?.adapter = null
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> {
                navigateToSettings()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToSettings() {

        findNavController().navigate(
            R.id.action_mostViewedFragment_to_settingFragment,
            Bundle().apply {
                putString(
                    TOP_TITLE,
                    getString(R.string.settings)
                )
            })
    }
}
