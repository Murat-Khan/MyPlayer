package com.murat.myplayer.model

import java.io.Serializable

data class MusicData(
    var author : String?= "Не известный исполнитель",
    val songName : String,
    var duration : String,
    var image : String
    ) : Serializable
