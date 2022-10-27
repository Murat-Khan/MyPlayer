package com.murat.myplayer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.murat.myplayer.databinding.ActivityMainBinding
import com.murat.myplayer.databinding.ItemMusicBinding
import com.murat.myplayer.model.MusicData

class MusicAdapter(
    private val musicList: List<MusicData>,
    val onClick: (position : Int) -> Unit
    ) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
      return MusicViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position], position)
    }

    override fun getItemCount() = musicList.size

     inner class MusicViewHolder(private val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root) {

         fun bind(musicData: MusicData, position: Int){
             itemView.setOnClickListener {
                 onClick(position)
             }
             binding.tvMusic.text = musicData.songName
             binding.tvName.text = musicData.author
             binding.tvDuration.text = musicData.duration
             binding.tvRank.text = (position + 1).toString()
             Glide.with(binding.image).load(musicData.image).into(binding.image)



         }

     }
}