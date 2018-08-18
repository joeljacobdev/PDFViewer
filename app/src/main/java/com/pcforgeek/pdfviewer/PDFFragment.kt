package com.pcforgeek.pdfviewer


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_pdf.*
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient


class PDFFragment : Fragment() {

    private val filePath = "https://www.tutorialspoint.com/android/android_tutorial.pdf"
    private val viewerPath = "https://pcforgeek.github.io/PDFViewer/web/viewer.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pdf, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        pdfWebView.settings.javaScriptEnabled = true
        pdfWebView.loadUrl("$viewerPath?file=$filePath")
        pdfWebView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                progress_circular.visibility = View.GONE
                super.onPageFinished(view, url)
            }
        }
        super.onActivityCreated(savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
                PDFFragment()
    }
}
