package com.pcforgeek.pdfviewer


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import kotlinx.android.synthetic.main.fragment_pdf.*
import android.webkit.WebViewClient


class PDFFragment : Fragment() {

    private val filePath = "https://www.tutorialspoint.com/android/android_tutorial.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pdf, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pdfWebView.settings.javaScriptEnabled = true
        //pdfWebView.settings.allowUniversalAccessFromFileURLs = true
        //pdfWebView.settings.allowFileAccessFromFileURLs = true
        pdfWebView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                progress_circular?.visibility = View.GONE
                super.onPageFinished(view, url)
            }
        }
        pdfWebView.settings.builtInZoomControls = true
        pdfWebView.loadUrl("file:///android_asset/pdf/web/viewer.html?file=$filePath")
    }


    companion object {
        @JvmStatic
        fun newInstance() =
                PDFFragment()
    }
}
