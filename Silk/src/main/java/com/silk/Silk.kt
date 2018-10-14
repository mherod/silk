package com.silk

import android.content.Context
import android.webkit.WebSettings
import android.webkit.WebView

typealias WebViewTitleChangeListener = (title: String) -> Unit

class Silk (
        val webView: WebView,
        val urlInterceptor: List<UrlChangeInterceptor>?,
        val titleChangeListeners: List<TitleChangeListener>?,
        val javascriptInterfaces: List<JavaScriptInterface>?,
        val progressChangeListeners: List<ProgressChangeListener>?,
        val headers: HashMap<String, String>,
        val userAgent: String,
        val webSettings: WebSettings,
        val isDebuggable: Boolean
) {

    init {
        //modify web view here
    }

    private constructor(builder: Builder) : this(builder.webView,
            builder.urlInterceptors,
            builder.titleChangeListeners,
            builder.javascriptInterfaces,
            builder.progressChangeListeners,
            builder.requestHeaders,
            builder.userAgent,
            builder.webSettings,
            builder.enableDebugging)

    companion object {
        inline fun createSilk(webView: WebView, block: Builder.() -> Unit) = Builder(webView).apply(block).build()
    }

    class Builder(val webView: WebView) {

        val context: Context get() = webView.context
        var urlInterceptors = mutableListOf<UrlChangeInterceptor>()
        var titleChangeListeners = mutableListOf<TitleChangeListener>()
        var javascriptInterfaces = mutableListOf<JavaScriptInterface>()
        var progressChangeListeners = mutableListOf<ProgressChangeListener>()
        var requestHeaders = hashMapOf<String, String>()
        var userAgent = ""
        var enableDebugging = false
        var webSettings: WebSettings = webView.settings

        fun urlChangeInterceptor(block: UrlChangeInterceptorBuilder.() -> Unit) {
            urlInterceptors.add(UrlChangeInterceptorBuilder().apply(block).build())
        }

        fun titleChangeListener(block: TitleChangeListenerBuilder.() -> Unit) {
            titleChangeListeners.add(TitleChangeListenerBuilder().apply(block).build())
        }

        fun progressChangeListener(block: ProgressChangeListenerBuilder.() -> Unit) {
            progressChangeListeners.add(ProgressChangeListenerBuilder().apply(block).build())
        }

        fun javascriptInterface(block: JavaScriptInterfaceBuilder.() -> Unit) {
            javascriptInterfaces.add(JavaScriptInterfaceBuilder().apply(block).build())
        }

        fun webViewSettings(function: WebSettings.() -> Unit) {
             function.invoke(webSettings)
        }

        fun build() = Silk(this)

    }
}