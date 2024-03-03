package com.example.footballleague.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.footballleague.R
import com.example.footballleague.databinding.FragmentCompetitionDetailBinding
import com.example.footballleague.ui.base.BaseFragment
import com.example.footballleague.ui.viewmodels.FootballViewModel

class CompetitionDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentCompetitionDetailBinding

    override val _viewModel by activityViewModels<FootballViewModel>()

    private val competitionDetailFragmentArgs by navArgs<CompetitionDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate<FragmentCompetitionDetailBinding?>(
                inflater,
                R.layout.fragment_competition_detail, container, false
            ).apply {
                competition = competitionDetailFragmentArgs.competition
            }
//        initActions()
        return binding.root
    }
}