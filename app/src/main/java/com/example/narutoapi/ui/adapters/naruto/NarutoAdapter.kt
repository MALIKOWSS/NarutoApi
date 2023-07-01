package com.example.narutoapi.ui.adapters.naruto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.narutoapi.data.models.naruto.CharactersItem
import com.example.rickandmortyapi.databinding.ItemNarutoBinding

class NarutoAdapter(private val onClickListener: (id: String) -> Unit) :
    ListAdapter<CharactersItem, NarutoAdapter.DetailFilmsViewHolder>(diffUtil) {

    inner class DetailFilmsViewHolder(private val binding: ItemNarutoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: CharactersItem) {
            binding.name.text = model.name
            if (model.images?.isEmpty() == false) {
                binding.image.load(model.images[0])
            }
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { onClickListener(id.toString()) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailFilmsViewHolder = DetailFilmsViewHolder(
        ItemNarutoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: DetailFilmsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CharactersItem>() {
            override fun areItemsTheSame(
                oldItem: CharactersItem,
                newItem: CharactersItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CharactersItem,
                newItem: CharactersItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
