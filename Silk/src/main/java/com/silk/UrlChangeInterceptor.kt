package com.silk

data class UrlChangeInterceptor(private val url: String, private val callback: (url: String) -> Unit?)

class UrlChangeInterceptorBuilder {

    var url: String = ""
    var callback: (url: String) -> Unit? = {}

    fun build() : UrlChangeInterceptor = UrlChangeInterceptor(url, callback)
}