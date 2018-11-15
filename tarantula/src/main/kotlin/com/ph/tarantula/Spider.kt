package com.ph.tarantula

import khttp.responses.Response

open class Spider(initialUrls: MutableList<String>, domain: String, requesterQty: Int) :
    Crawler(initialUrls, domain, requesterQty) {

    override fun result(response: Response) {}

    override fun stop() {}

    override fun start() {
        startCrawler()
    }
}
