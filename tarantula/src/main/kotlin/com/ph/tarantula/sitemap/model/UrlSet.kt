package com.ph.tarantula.sitemap.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("urlset")
data class UrlSet(
    @set:JsonProperty("url")
    var urls: List<Url> = ArrayList()
)
