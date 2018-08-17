package com.silk

data class TitleChangeListener(private val listener: (title: String) -> Unit?)

class TitleChangeListenerBuilder {

    var listener: (url: String) -> Unit? = {}

    fun build() : TitleChangeListener = TitleChangeListener(listener)
}