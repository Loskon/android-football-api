package com.loskon.sportapi.matchlist.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
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
                val fromDate = LocalDateTime.now().toFormatString()
                val toDate = LocalDateTime.now().plusDays(RANGE_DAYS).toFormatString()

                viewModel.getMatchList(fromDate, toDate)
            } else {
                viewModel.setMatches(matches.toList())
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        installObserver()

        matchListAdapter.setOnItemClickListener { match ->
            Toast.makeText(requireContext(), "Hi", Toast.LENGTH_LONG).show()
        }
    }

    private fun configureRecyclerView() {
        with(binding.rv) {
            (itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(requireContext())
            adapter = matchListAdapter
            setHasFixedSize(true)
        }
    }

    private fun installObserver() {
        viewModel.getMatchListState.observe(viewLifecycleOwner) {
            matchListAdapter.setItems(it)
        }
    }

    companion object {
        private const val RANGE_DAYS = 15L
    }
}