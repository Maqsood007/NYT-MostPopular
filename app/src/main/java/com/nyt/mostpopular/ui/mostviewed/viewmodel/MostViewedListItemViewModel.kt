package com.nyt.mostpopular.ui.mostviewed.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nyt.mostpopular.repository.models.Media
import com.nyt.mostpopular.repository.models.Result
import com.nyt.mostpopular.utils.DataParsingUtils.getThumbnail
import com.nyt.mostpopular.utils.DateTimeUtils.getParsedDate
import com.squareup.picasso.Picasso

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class MostViewedListItemViewModel : ViewModel() {

    private val avatar = MutableLiveData<String?>()
    private val title = MutableLiveData<String>()
    private val authorName = MutableLiveData<String>()
    private val category = MutableLiveData<String>()
    private val date = MutableLiveData<String>()

    fun bind(articles: Result?) {

        val mediaList: List<Media>? = articles?.media

        mediaList?.let {
            avatar.value = getThumbnail(mediaList = mediaList)
        }

        title.value = articles?.title ?: ""
        authorName.value = articles?.byline ?: ""

        val desFacet: Any? = articles?.desFacet

        if (desFacet is ArrayList<*>) {

            val desFacetList: List<String> = desFacet.filterIsInstance<String>()

            if (desFacetList.isNotEmpty()) {
                category.value = desFacetList[0]
            }
        }

        articles?.publishedDate?.let {
            date.value = getParsedDate(articles.publishedDate)
        }
    }

    fun getAvatar(): MutableLiveData<String?> {
        return avatar
    }

    fun getTitle(): MutableLiveData<String> {
        return title
    }

    fun getAuthorName(): MutableLiveData<String> {
        return authorName
    }

    fun getCategory(): MutableLiveData<String> {
        return category
    }

    fun getDate(): MutableLiveData<String> {
        return date
    }
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .into(view)
}
