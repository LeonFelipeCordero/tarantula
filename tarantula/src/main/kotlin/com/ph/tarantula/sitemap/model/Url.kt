package com.ph.tarantula.sitemap.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import org.jetbrains.annotations.Nullable

@JsonRootName("url")
data class Url(
    @set:JsonProperty("loc")
    var loc: String? = null,

    @set:JsonProperty("lastmod")
    var lastModification: String? = null,

    @set:JsonProperty("changefreq")
    @Nullable
    var changeFrequency: String? = null,

    @set:JsonProperty("priority")
    @Nullable
    var priority: Int? = null
)
