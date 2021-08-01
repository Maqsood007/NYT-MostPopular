package com.nyt.mostpopular.utils

import com.nyt.mostpopular.repository.models.Media

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
object DataParsingUtils {

    fun getThumbnail(mediaList: List<Media>): String? {

        return if (mediaList.isNotEmpty()) {
            val mediaMetaData = mediaList[0].mediaMetadata
            return if (mediaMetaData?.isNotEmpty() == true) mediaMetaData[0].url else null
        } else null
    }
}
