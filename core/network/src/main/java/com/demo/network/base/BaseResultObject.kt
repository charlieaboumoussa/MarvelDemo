package com.demo.network.base

class BaseResultObject<T> {
    var offset : Int = 0
    var limit : Int = 0
    var total : Int = 0
    var count : Int = 0
    var results : T? = null
}