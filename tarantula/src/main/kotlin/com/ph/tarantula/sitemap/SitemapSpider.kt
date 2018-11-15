package com.ph.tarantula.sitemap

import com.ph.tarantula.Crawler
import khttp.responses.Response
import java.nio.charset.StandardCharsets.UTF_8
import java.util.zip.GZIPInputStream

open class SitemapSpider(sitemapUrl: String, domain: String, requesterQty: Int) :
    Crawler(mutableListOf(sitemapUrl), domain, requesterQty) {

    override fun result(response: Response) {
        extraxtUrls(response.content)
            .stream()
            .forEach { addUrl(it!!) }
    }


    override fun start() {
        startCrawler()
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
