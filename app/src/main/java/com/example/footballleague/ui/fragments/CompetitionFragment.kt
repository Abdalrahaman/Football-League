package com.example.footballleague.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.footballleague.R
import com.example.footballleague.databinding.FragmentCompetitionBinding
import com.example.footballleague.ui.adapters.CompetitionAdapter
import com.example.footballleague.ui.base.BaseFragment
import com.example.footballleague.ui.viewmodels.FootballViewModel
import com.example.footballleague.utils.NavigationCommand
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CompetitionFragment : BaseFragment() {

    private lateinit var binding: FragmentCompetitionBinding

    override val _viewModel by activityViewModels<FootballViewModel>()

    private lateinit var competitionAdapter: CompetitionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate<FragmentCompetitionBinding?>(
                inflater,
                R.layout.fragment_competition, container, false
            ).apply {
                viewModel = _viewModel
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        setupCompetitionAdapter()
        handleCompetitions()
    }

    private fun setupCompetitionAdapter() {
        competitionAdapter = CompetitionAdapter(
            CompetitionAdapter.OnClickListener {
                _viewModel.navigationCommand.postValue(
                    NavigationCommand.To(
                        CompetitionFragmentDirections.actionCompetitionFragmentToCompetitionDetailFragment(
                            it
                        )
                    )
                )
            })
        binding.competitionsRecyclerView.adapter = competitionAdapter
    }

    private fun handleCompetitions() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                _viewModel.competitionListResult.collectLatest {
                    competitionAdapter.submitList(it)
                }
            }
        }
    }
}