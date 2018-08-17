package com.silk

data class JavaScriptInterface(private val jsInterface: Any, private val jsObject: String)

class JavaScriptInterfaceBuilder {

    var jsObject: String = ""
    var jsInterface: Any = {}

    fun build() : JavaScriptInterface = JavaScriptInterface(jsInterface, jsObject)

}