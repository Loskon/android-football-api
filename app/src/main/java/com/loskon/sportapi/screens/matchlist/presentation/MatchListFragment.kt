package com.loskon.sportapi.screens.matchlist.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.google.android.material.snackbar.Snackbar
import com.loskon.base.datetime.toFormatString
import com.loskon.base.viewbinding.viewBinding
import com.loskon.cryptocoins.base.extension.coroutines.observe
import com.loskon.sportapi.R
import com.loskon.sportapi.databinding.FragmentMatchListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime

class MatchListFragment : Fragment(R.layout.fragment_match_list) {

    private val binding by viewBinding(FragmentMatchListBinding::bind)
    private val viewModel by viewModel<MatchListViewModel>()
    private val args by navArgs<MatchListFragmentArgs>()

    private val matchListAdapter = MatchListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val matches = args.matches

            if (matches == null) {
                getMatchList()
            } else {
                viewModel.setMatches(matches.toList())
            }
        }
    }

    private fun getMatchList() {
        val fromDate = LocalDateTime.now().toFormatString()
        val toDate = LocalDateTime.now().plusDays(RANGE_DAYS).toFormatString()

        viewModel.getMatchList(fromDate, toDate)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        installObserver()
        setupViewListeners()
    }

    private fun configureRecyclerView() {
        with(binding.rvMatchList) {
            (itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(requireContext())
            adapter = matchListAdapter
            setHasFixedSize(true)
        }
    }

    private fun installObserver() {
        viewModel.getMatchListState.observe(viewLifecycleOwner) {
            when (it) {
                is MatchListState.Loading -> {
                    binding.indicatorMatchList.isVisible = true
                }
                is MatchListState.Success -> {
                    binding.indicatorMatchList.isVisible = false
                    matchListAdapter.setItems(it.matches)
                }
                is MatchListState.Failure -> {
                    binding.indicatorMatchList.isVisible = false
                    showWarningSnackbar()
                }
            }
        }
    }

    private fun showWarningSnackbar() {
        Snackbar.make(binding.root, getString(R.string.error_loading), Snackbar.LENGTH_LONG)
            .setAnchorView(binding.bottomBarMatchList)
            .show()
    }

    private fun setupViewListeners() {
        binding.swMatchList.setOnRefreshListener {
            binding.swMatchList.isRefreshing = false
            getMatchList()
        }
        matchListAdapter.setOnItemClickListener { match ->
            findNavController().navigate(MatchListFragmentDirections.openMatchInfoList(match))
        }
        binding.bottomBarMatchList.setNavigationOnClickListener {
            findNavController().navigate(MatchListFragmentDirections.openWebFragment())
        }
    }

    companion object {
        private const val RANGE_DAYS = 15L
    }
}