package com.nyt.mostpopular.ui.mostviewed.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nyt.mostpopular.R
import com.nyt.mostpopular.databinding.MostViewedListItemBinding
import com.nyt.mostpopular.repository.models.Result
import com.nyt.mostpopular.ui.base.BaseFragment.Companion.TOP_TITLE
import com.nyt.mostpopular.ui.details.MostViewedDetailFragment
import com.nyt.mostpopular.ui.mostviewed.viewmodel.MostViewedListItemViewModel

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class MostViewedArticlesListAdapter :
    RecyclerView.Adapter<MostViewedArticlesListAdapter.ViewHolder>() {

    private lateinit var mostViewedArticlesList: List<Result?>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val mostViewedListItemBinding: MostViewedListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.most_viewed_list_item, parent, false
        )

        return ViewHolder(mostViewedListItemBinding)
    }

    override fun getItemCount(): Int {
        return if (::mostViewedArticlesList.isInitialized) mostViewedArticlesList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mostViewedArticlesRepo = mostViewedArticlesList[position]

        holder.bind(mostViewedArticlesRepo)

        holder.itemView.setOnClickListener {

            val bundle = bundleOf(
                MostViewedDetailFragment.URL_TO_BROWSE to mostViewedArticlesRepo?.url,
                TOP_TITLE to it.context.getString(R.string.new_details)
            )
            it.findNavController().navigate(
                R.id.action_mostViewedFragment_to_mostViewedDetailFragment,
                bundle
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMostViewedArticles(mostViewedArticlesRepo: List<Result?>) {
        this.mostViewedArticlesList = mostViewedArticlesRepo
        notifyDataSetChanged()
    }

    class ViewHolder(private val mostViewedListItemBinding: MostViewedListItemBinding) :
        RecyclerView.ViewHolder(mostViewedListItemBinding.root) {
        private val viewModel = MostViewedListItemViewModel()

        fun bind(result: Result?) {
            viewModel.bind(result)
            mostViewedListItemBinding.viewModel = viewModel
        }
    }
}
