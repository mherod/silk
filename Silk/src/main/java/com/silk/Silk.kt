package com.silk

import android.webkit.WebView

typealias WebViewTitleChangeListener = (title: String) -> Unit

class Silk (
        val webView: WebView,
        val urlInterceptor: List<UrlChangeInterceptor>?,
        val titleChangeListeners: List<WebViewTitleChangeListener>?,
        val headers: HashMap<String, String>,
        val enableJavascript: Boolean,
        val enableJavascriptToOpenNewWindows: Boolean,
        val isDebuggable: Boolean
) {

    private constructor(builder: Builder) : this(builder.webView,
            builder.urlInterceptors,
            builder.titleChangeListeners,
            builder.headers,
            builder.enableJavascript,
            builder.enableJavascriptToOpenNewWindows,
            builder.isDebuggable)

    companion object {
        inline fun createSilk(webView: WebView, block: Builder.() -> Unit) = Builder(webView).apply(block).build()
    }

    class Builder(val webView: WebView) {

        var urlInterceptors = mutableListOf<UrlChangeInterceptor>()
        var titleChangeListeners = mutableListOf<WebViewTitleChangeListener>()
        var headers = hashMapOf<String, String>()
        var enableJavascript = false
        var enableJavascriptToOpenNewWindows = false

        var isDebuggable = false

        fun addUrlChangeInterceptor(urlChangeInterceptor: UrlChangeInterceptor) {
            urlInterceptors.add(urlChangeInterceptor)
        }

        fun addTitleChangeListener(titleChangeListener: WebViewTitleChangeListener) {
            titleChangeListeners.add(titleChangeListener)
        }

        fun addHeadersToRequests(headers: HashMap<String, String>) {
            this.headers.putAll(headers)
        }

        fun enableJavascript() {
            enableJavascript = true
        }

        fun enableJavascriptToOpenNewWindows() {
            enableJavascriptToOpenNewWindows = true
        }

        fun enableDebugging(isDebuggable: Boolean) {
            this.isDebuggable = isDebuggable
        }

        fun build() = Silk(this)
    }
}