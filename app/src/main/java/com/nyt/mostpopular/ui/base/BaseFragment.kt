package com.nyt.mostpopular.ui.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
@AndroidEntryPoint
open class BaseFragment : Fragment() {

    companion object {

        const val TOP_TITLE = "top_title"
    }
}
