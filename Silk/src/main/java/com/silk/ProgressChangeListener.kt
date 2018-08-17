package com.silk

data class ProgressChangeListener(private val listener: (newProgress: Int) -> Unit?)

class ProgressChangeListenerBuilder {

    var listener: (newProgress: Int) -> Unit? = {}

    fun build() : ProgressChangeListener = ProgressChangeListener(listener)
}