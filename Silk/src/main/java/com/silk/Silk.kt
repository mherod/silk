package com.silk

import android.webkit.WebView

class Silk (
        val webView: WebView,
        val urlInterceptor: List<UrlChangeInterceptor>?
) {

    private constructor(builder: Builder) : this(builder.webView, builder.urlInterceptors)

    companion object {
        inline fun createSilk(webView: WebView, block: Builder.() -> Unit) = Builder(webView).apply(block).build()
    }

    class Builder(val webView: WebView) {

        var urlInterceptors = mutableListOf<UrlChangeInterceptor>()

        fun addUrlChangeInterceptor(urlChangeInterceptor: UrlChangeInterceptor) {
            urlInterceptors.add(urlChangeInterceptor)
        }

        fun build() = Silk(this)
    }
}