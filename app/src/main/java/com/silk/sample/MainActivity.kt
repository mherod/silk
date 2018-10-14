package com.silk.sample

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast
import com.sample.BuildConfig
import com.sample.R
import com.silk.JavaScriptInterface
import com.silk.Silk.Companion.createSilk
import com.silk.UrlChangeInterceptor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSilk(webView) {

            urlChangeInterceptor {

                url = "http://google.com"
                callback = { url -> Toast.makeText(context, "Found $url", Toast.LENGTH_SHORT).show() }
            }

            javascriptInterface {

                jsObject = "JSOBJECT"
                jsInterface = WebAppInterface(context)
            }

            javascriptInterface {

                jsObject = "ANOTHER_JSOBJECT"
                jsInterface = WebAppInterface(context)
            }

            titleChangeListener {
                listener = ::handleTitleChange
            }

            progressChangeListener {
                listener = ::handleProgressUpdate
            }

            webViewSettings {

                javaScriptEnabled = true
                allowFileAccess = true
            }

            requestHeaders = hashMapOf("" to "")
            userAgent = "FooUserAgent"
            enableDebugging = isDebugabble()
        }
    }

    private fun handleProgressUpdate(newProgress: Int) {
        Toast.makeText(this, newProgress, Toast.LENGTH_SHORT).show()
    }

    private fun handleTitleChange(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }

    private fun isDebugabble(): Boolean {
        return BuildConfig.DEBUG
    }

    class WebAppInterface(private val mContext: Context) {

        /** Show a toast from the web page  */
        @JavascriptInterface
        fun showToast(toast: String) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
        }
    }
}
