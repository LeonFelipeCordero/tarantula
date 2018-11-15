package com.ph.tarantula

fun String.regexUrl(domain: String): Boolean = this.matches(Regex("http(s)?://(www.)?$domain[^\\s]*"))
