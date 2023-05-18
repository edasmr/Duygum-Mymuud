package com.intersonik.duygum.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.intersonik.duygum.R
import com.intersonik.duygum.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var webView: WebView
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webView)


        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.apply {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
        }
        CookieManager.getInstance().removeAllCookies(null)
        CookieManager.getInstance().setAcceptCookie(true)
        val cookies = "lang=tr;access_token=${viewModel.getToken()}"
        val cookiesList = cookies.split(";")
        cookiesList.forEach { item ->
            CookieManager.getInstance().setCookie("http://mymuud.co/dashboard", item)
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        webView.loadUrl("http://mymuud.co")

    }


}