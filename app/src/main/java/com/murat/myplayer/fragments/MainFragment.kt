package com.murat.myplayer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.viewbinding.ViewBinding
import com.murat.myplayer.MainActivity
import com.murat.myplayer.R
import com.murat.myplayer.adapter.MusicAdapter
import com.murat.myplayer.databinding.FragmentMainBinding
import com.murat.myplayer.model.MusicData


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val musList = arrayListOf<MusicData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musList.clear()
        loadData()
        val adapter = MusicAdapter(musList, this::onClick)
        binding.recycle.adapter = adapter
    }

    private fun loadData() {
        musList.add(MusicData("Regard", "Ride It", "3:04","https://avatars.yandex.net/get-music-content/42108/10510516.a.4205-1/400x400"))
        musList.add(MusicData("Imanbek, BYOR","Belly Dancer","2:34","https://avatars.yandex.net/get-music-content/108289/c7071da5.a.6319414-1/400x400"))
        musList.add(MusicData(" The Black Eyed Peas","Bad Boys for Life","3:01","https://avatars.yandex.net/get-music-content/2433207/2856015d.a.12864225-1/400x400"))
        musList.add(MusicData(" Edmofo, FILV","LUX","3:54","https://avatars.yandex.net/get-music-content/34131/436d3796.a.59523-1/400x400"))
        musList.add(MusicData("Аарон Смит","Dancin","4:00","https://avatars.yandex.net/get-music-content/33216/077459dc.a.67292-1/400x400"))
        musList.add(MusicData("Miss Mary","Shot a Friend","3:06","https://avatars.yandex.net/get-music-content/108289/c7071da5.a.6319414-1/400x400"))
        musList.add(MusicData(" Давид Гетта"," On Repeat On Repeat","3:06","https://avatars.yandex.net/get-music-content/99892/100b3f0b.a.5400781-1/400x400"))
        musList.add(MusicData("Оливия Аддамс","Fool Me Once","3:23","https://avatars.yandex.net/get-music-content/33216/98a90c87.a.3837950-1/400x400"))
        musList.add(MusicData("Triplo Max","Shadow","3:12","https://avatars.yandex.net/get-music-content/6201394/d43c8863.a.11644078-3/400x400"))

    }

    private fun onClick(position: Int) {
        val bundle = Bundle()
        bundle.putSerializable(MUSIC_BUNDLE_KEY, musList[position])
        val fragment = DetailFragment()
        fragment.arguments = bundle
       /* requireActivity().supportFragmentManager.findFragmentById(R.id.second_fragment)?.view?.isGone =
            true*/

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment, fragment).addToBackStack(null).commit()
    }
}