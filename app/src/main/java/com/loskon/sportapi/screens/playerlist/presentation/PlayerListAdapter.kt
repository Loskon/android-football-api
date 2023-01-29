package com.loskon.sportapi.screens.playerlist.presentation

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loskon.base.extension.view.setDebounceClickListener
import com.loskon.base.viewbinding.viewBinding
import com.loskon.sportapi.R
import com.loskon.sportapi.databinding.ItemPlayerCardBinding
import com.loskon.sportapi.model.PlayerModel

@SuppressLint("NotifyDataSetChanged")
class PlayerListAdapter : RecyclerView.Adapter<PlayerListAdapter.PlayerListViewHolder>() {

    private var list: List<PlayerModel> = emptyList()

    private var onItemClick: ((PlayerModel) -> Unit)? = null

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerListViewHolder {
        return PlayerListViewHolder(parent.viewBinding(ItemPlayerCardBinding::inflate))
    }

    override fun onBindViewHolder(holder: PlayerListViewHolder, position: Int) {
        val item = list[position]

        with(holder.binding) {
            item.apply {
                tvPlayerCardName.text = playerName
                tvPlayerCardNumber.text = root.context.getString(R.string.player_number, playerNumber)
                tvPlayerCardType.text = root.context.getString(R.string.player_type, playerType)
                tvPlayerCardAge.text = root.context.getString(R.string.player_age, playerAge)
                tvPlayerCardMatchPlayed.text = root.context.getString(R.string.player_match_played, playerMatchPlayed)
                tvPlayerCardGoals.text = root.context.getString(R.string.player_goals, playerGoals)
                root.setDebounceClickListener { onItemClick?.invoke(this) }
            }
        }
    }

    fun setItems(list: List<PlayerModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClick: ((PlayerModel) -> Unit)?) {
        this.onItemClick = onItemClick
    }

    class PlayerListViewHolder(val binding: ItemPlayerCardBinding) : RecyclerView.ViewHolder(binding.root)
}