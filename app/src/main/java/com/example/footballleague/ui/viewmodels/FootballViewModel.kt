package com.example.footballleague.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.footballleague.data.model.pojo.Competition
import com.example.footballleague.data.repository.DefaultRepository
import com.example.footballleague.ui.base.BaseViewModel
import com.example.footballleague.utils.Result
import com.example.footballleague.utils.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FootballViewModel @Inject constructor(
    private val defaultRepository: DefaultRepository
) : BaseViewModel() {

    private val _competitionListResult = MutableStateFlow(emptyList<Competition>())
    val competitionListResult: StateFlow<List<Competition>> = _competitionListResult

    init {
        getCompetitions()
    }

    private fun getCompetitions() = viewModelScope.launch {
        defaultRepository.getCompetitions().asResult().collectLatest {
            when (it) {
                is Result.Loading -> {
                    showLoading.postValue(true)
                }

                is Result.Error -> {
                    showLoading.postValue(false)
                    showToast.postValue(it.message)
                    Timber.e(it.message)
                }

                is Result.Success -> {
                    showLoading.postValue(false)
                    _competitionListResult.value = it.data
                }
            }
        }
    }
}