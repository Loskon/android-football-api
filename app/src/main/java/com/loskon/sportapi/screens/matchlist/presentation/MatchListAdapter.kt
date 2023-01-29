package com.loskon.sportapi.screens.matchlist.presentation

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loskon.base.extension.view.setDebounceClickListener
import com.loskon.base.viewbinding.viewBinding
import com.loskon.sportapi.databinding.ItemMatchCardBinding
import com.loskon.sportapi.model.MatchModel
import com.loskon.sportapi.utils.ImageLoader

@SuppressLint("NotifyDataSetChanged")
class MatchListAdapter : RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder>() {

    private var list: List<MatchModel> = emptyList()

    private var onItemClick: ((MatchModel) -> Unit)? = null

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListViewHolder {
        return MatchListViewHolder(parent.viewBinding(ItemMatchCardBinding::inflate))
    }

    override fun onBindViewHolder(holder: MatchListViewHolder, position: Int) {
        val item = list[position]

        with(holder.binding) {
            item.apply {
                ImageLoader.load(ivMatchCardHome, homeTeamLogo)
                ImageLoader.load(ivMatchCardAway, awayTeamLogo)
                tvMatchCardHomeName.text = eventHomeTeam
                tvMatchCardAwayName.text = eventAwayTeam
                tvMatchCardDate.text = eventDate
                root.setDebounceClickListener { onItemClick?.invoke(this) }
            }
        }
    }

    fun setItems(list: List<MatchModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClick: ((MatchModel) -> Unit)?) {
        this.onItemClick = onItemClick
    }

    class MatchListViewHolder(val binding: ItemMatchCardBinding) : RecyclerView.ViewHolder(binding.root)
}