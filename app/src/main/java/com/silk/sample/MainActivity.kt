package com.silk.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        }
    }
}
