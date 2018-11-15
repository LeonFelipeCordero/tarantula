package com.ph.tarantula.sitemap.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import java.util.*

@JsonRootName("sitemap")
data class Sitemap(
    @set:JsonProperty("loc")
    var loc: String? = null,

    @set:JsonProperty("lastmod")
    var lastModification: String? = null
)
