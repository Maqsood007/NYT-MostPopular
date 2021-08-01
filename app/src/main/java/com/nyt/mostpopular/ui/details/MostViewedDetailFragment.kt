package com.nyt.mostpopular.ui.details

import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.nyt.mostpopular.R
import com.nyt.mostpopular.ui.base.BaseFragment

/**
 * Created by Muhammad Maqsood on 01/08/2021.
 */
class MostViewedDetailFragment : BaseFragment() {

    companion object {
        const val URL_TO_BROWSE = "url_to_browse"
    }

    private var webViewer: WebView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_most_viewed_detail, container, false)

        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                view.findViewById<WebView>(R.id.webViewer).settings.forceDark =
                    WebSettings.FORCE_DARK_ON
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews(view)

        webViewer?.webViewClient = webVieClient
        webViewer?.settings?.javaScriptEnabled = true

        webViewer?.loadUrl(
            arguments?.getString(URL_TO_BROWSE)
            ?: "https://www.google.com/")

        // Intercept the device back button
        webViewer?.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (webViewer?.canGoBack() == true) {
                    webViewer?.goBack()
                    true
                } else false
            } else {
                false
            }
        }
    }

    private fun initViews(view: View) {
        webViewer = view.findViewById(R.id.webViewer)
        progressBar = view.findViewById(R.id.progressBar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        webViewer?.stopLoading()
    }

    private val webVieClient = object : WebViewClient() {

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progressBar?.let {
                it.visibility = View.VISIBLE
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progressBar?.let {
                it.visibility = View.GONE
            }
        }
    }
}
