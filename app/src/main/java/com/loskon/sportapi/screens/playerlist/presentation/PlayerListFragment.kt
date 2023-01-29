package com.loskon.sportapi.screens.playerlist.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.google.android.material.snackbar.Snackbar
import com.loskon.base.viewbinding.viewBinding
import com.loskon.cryptocoins.base.extension.coroutines.observe
import com.loskon.sportapi.R
import com.loskon.sportapi.databinding.FragmentPlayerListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerListFragment : Fragment(R.layout.fragment_player_list) {

    private val binding by viewBinding(FragmentPlayerListBinding::bind)
    private val viewModel by viewModel<PlayerListViewModel>()
    private val args by navArgs<PlayerListFragmentArgs>()

    private val matchListAdapter = PlayerListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) viewModel.getPlayerList(args.team)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTeamName.text = args.team
        configureRecyclerView()
        installObserver()
        setupViewListeners()
    }

    private fun configureRecyclerView() {
        with(binding.rvPlayerList) {
            (itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(requireContext())
            adapter = matchListAdapter
            setHasFixedSize(true)
        }
    }

    private fun installObserver() {
        viewModel.getPlayerListState.observe(viewLifecycleOwner) {
            when (it) {
                is PlayerListState.Loading -> {
                    binding.indicatorPlayerList.isVisible = true
                }
                is PlayerListState.Success -> {
                    binding.indicatorPlayerList.isVisible = false
                    binding.tvPlayerListEmpty.isVisible = it.players.isEmpty()
                    matchListAdapter.setItems(it.players)
                }
                is PlayerListState.Failure -> {
                    binding.indicatorPlayerList.isVisible = false
                    showSnackbar(getString(R.string.error_loading))
                }
            }
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setAnchorView(binding.bottomBarPlayerList)
            .show()
    }

    private fun setupViewListeners() {
        binding.swPlayerList.setOnRefreshListener {
            binding.swPlayerList.isRefreshing = false
            viewModel.getPlayerList(args.team)
        }
        matchListAdapter.setOnItemClickListener { player ->
            showSnackbar(player.playerName)
        }
        binding.bottomBarPlayerList.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}