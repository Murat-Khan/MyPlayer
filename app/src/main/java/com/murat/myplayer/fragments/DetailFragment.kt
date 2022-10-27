package com.murat.myplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.murat.myplayer.R
import com.murat.myplayer.databinding.FragmentDetailBinding
import com.murat.myplayer.model.MusicData


class DetailFragment : Fragment() {


    lateinit var musicData: MusicData
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicData = arguments?.getSerializable(MUSIC_BUNDLE_KEY) as MusicData
        binding.author.text = musicData.author
        binding.song.text = musicData.songName
        Glide.with(binding.image).load(musicData.image).into(binding.image)








    }


}