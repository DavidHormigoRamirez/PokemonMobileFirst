package com.alanturing.cpifp.pokemonroom.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import com.alanturing.cpifp.pokemonroom.data.repository.Pokemon
import com.alanturing.cpifp.pokemonroom.databinding.PokemonListItemBinding


class PokemonListAdapter(private val context: Context): ListAdapter<Pokemon,PokemonListAdapter.PokemonViewHolder >(PokemonDiffCallback) {

    inner class PokemonViewHolder(private val binding:PokemonListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon:Pokemon) {
            binding.pokemonName.text = pokemon.name
            //binding.pokemonSprite.load(pokemon.frontImageUrl)
            val imageRequest = ImageRequest.Builder(context)
                .data(pokemon.frontImageUrl)
                .crossfade(true)
                .target(binding.pokemonSprite)
                .build()

            context.imageLoader.enqueue(imageRequest)

        }
    }

    private object PokemonDiffCallback:DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.name == newItem.name
        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder = PokemonViewHolder(PokemonListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bind(getItem(position))

}