package com.demo.common.extensions

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

//fun String.md5(): String? {
fun an(){
    String::class.java
}
//    try {
//        val md = MessageDigest.getInstance("MD5")
//        val array = md.digest(toByteArray(charset("UTF-8")))
//        val sb = StringBuffer()
//        for (i in array.indices) {
//            sb.append(Integer.toHexString((i and 0xFF) or 0x100).substring(1, 3))
//        }
//        return sb.toString()
//    } catch (e: NoSuchAlgorithmException) {
//    } catch (ex: UnsupportedEncodingException) {
//    }
//    return null
//}