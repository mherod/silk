package com.silk.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sample.BuildConfig
import com.sample.R
import com.silk.Silk.Companion.createSilk
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSilk(webView) {

            addUrlChangeInterceptor(null)
            addUrlChangeInterceptor(null)

            addTitleChangeListener(::handleTitleChange)

            addHeadersToRequests(provideExtraHeaders())

            webViewSettings {

                javaScriptEnabled = true
                allowFileAccess = true
            }

            enableDebugging(isDebugabble())
        }
    }

    private fun handleTitleChange(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }

    private fun provideExtraHeaders(): HashMap<String, String> {
        return hashMapOf("" to "")
    }

    private fun isDebugabble(): Boolean {
        return BuildConfig.DEBUG
    }
}
