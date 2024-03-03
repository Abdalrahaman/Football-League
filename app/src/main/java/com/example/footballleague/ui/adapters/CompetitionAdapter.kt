package com.example.footballleague.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballleague.data.model.pojo.Competition
import com.example.footballleague.databinding.ItemCompetitionBinding

class CompetitionAdapter(private val clickListener: OnClickListener) :
    ListAdapter<Competition, CompetitionAdapter.CompetitionViewHolder>(
        CompetitionDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }

    class CompetitionViewHolder private constructor(private val binding: ItemCompetitionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: OnClickListener, competition: Competition) {
            binding.root.setOnClickListener {
                listener.onCompetitionClick(competition)
            }

            binding.competition = competition
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CompetitionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCompetitionBinding.inflate(layoutInflater, parent, false)

                return CompetitionViewHolder(binding)
            }
        }
    }

    class OnClickListener(
        val competitionClickListener: (Competition) -> Unit
    ) {
        fun onCompetitionClick(competition: Competition) = competitionClickListener(competition)
    }
}

class CompetitionDiffCallback : DiffUtil.ItemCallback<Competition>() {
    override fun areItemsTheSame(
        oldItem: Competition,
        newItem: Competition
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Competition,
        newItem: Competition
    ): Boolean {
        return oldItem == newItem
    }
}