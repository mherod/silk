package com.silk

import android.webkit.WebView

class Silk (
        val webView: WebView,
        val urlInterceptor: UrlChangeInterceptor?
) {

    private constructor(builder: Builder) : this(builder.webView, builder.urlInterceptor)

    companion object {
        inline fun using(webview: WebView, block: Builder.() -> Unit) = Builder(webview).apply(block).build()
    }

    class Builder(
            val webView: WebView
    ) {
        var urlInterceptor: UrlChangeInterceptor? = null

        fun build() = Silk(this)
    }
}