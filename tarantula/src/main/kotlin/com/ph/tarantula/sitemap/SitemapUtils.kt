package com.ph.tarantula.sitemap

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.ph.tarantula.sitemap.model.SitemapIndex
import com.ph.tarantula.sitemap.model.UrlSet
import java.nio.charset.StandardCharsets
import java.util.zip.GZIPInputStream
import java.util.zip.ZipException


internal val xmlMapper: ObjectMapper = XmlMapper(JacksonXmlModule().apply {
    setDefaultUseWrapper(false)
}).registerModule(KotlinModule())
    .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

fun extraxtUrls(content: ByteArray): List<String?> {
    return try {
        val unzipedContent = GZIPInputStream(content.inputStream()).bufferedReader(StandardCharsets.UTF_8).use { it.readText() }
        if (unzipedContent.contains("urlset")) {
            mapUrlSet(unzipedContent)
        } else {
            mapSitemap(unzipedContent)
        }
    }catch (e: ZipException) {
        println("Not in GZIP format")
        emptyList()
    }
}

fun mapSitemap(content: String): List<String?> =
    xmlMapper.readValue<SitemapIndex>(content)
        .sitemaps
        .map { it.loc }


fun mapUrlSet(content: String): List<String?> =
    xmlMapper.readValue<UrlSet>(content)
        .urls
        .map { it.loc }
