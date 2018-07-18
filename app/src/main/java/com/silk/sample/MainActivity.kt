package com.silk.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sample.R
import com.silk.Silk
import com.silk.UrlChangeInterceptor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Silk.using(webView) { urlInterceptor = UrlChangeInterceptor()}
    }
}
