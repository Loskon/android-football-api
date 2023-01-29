package com.loskon.sportapi.matchinfo.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.loskon.base.viewbinding.viewBinding
import com.loskon.cryptocoins.base.extension.coroutines.observe
import com.loskon.sportapi.R
import com.loskon.sportapi.databinding.FragmentMatchInfoBinding
import com.loskon.sportapi.utils.ImageLoader
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchInfoFragment : Fragment(R.layout.fragment_match_info) {

    private val binding by viewBinding(FragmentMatchInfoBinding::bind)
    private val viewModel by viewModel<MatchInfoViewModel>()
    private val args by navArgs<MatchInfoFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) viewModel.setMatch(args.match)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.incMatchCard.tvMatchCardDate.isVisible = false
        installObserver()
        setupViewListener()
    }

    private fun installObserver() {
        viewModel.getMatchInfoState.observe(viewLifecycleOwner) { match ->
            with(binding) {
                ImageLoader.load(incMatchCard.ivMatchCardHome, match.homeTeamLogo)
                ImageLoader.load(incMatchCard.ivMatchCardAway, match.awayTeamLogo)
                incMatchCard.tvMatchCardHomeName.text = match.eventHomeTeam
                incMatchCard.tvMatchCardAwayName.text = match.eventAwayTeam
                tvDate.text = match.eventDate
                tvLeagueName.text = match.leagueName
                tvLeagueRound.text = match.leagueRound
                tvCountryName.text = match.countryName
                tvStadium.text = match.eventStadium
            }
        }
    }

    private fun setupViewListener() {
        binding.bottomBarMatchInfo.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}