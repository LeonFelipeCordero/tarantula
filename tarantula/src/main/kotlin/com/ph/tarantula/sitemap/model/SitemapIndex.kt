package com.ph.tarantula.sitemap.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("sitemapindex")
data class SitemapIndex(
    @set:JsonProperty("sitemap")
    var sitemaps: List<Sitemap> = ArrayList()
)
