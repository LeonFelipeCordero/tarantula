package com.ph.tarantula

import com.ph.tarantula.logging.Logger
import khttp.get
import khttp.responses.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

abstract class Crawler(
    private val initialUrls: MutableList<String>,
    private val domain: String,
    private val requesterQty: Int
) {

    private val urls = Channel<String>()
    private val responses = Channel<Response>()

    abstract fun result(response: Response)

    abstract fun start()

    abstract fun stop()

    fun addUrl(url: String) = GlobalScope.launch {
        if (url.regexUrl(domain)) urls.send(url)
    }

    fun startCrawler() = runBlocking {
        launch {
            initialUrls.forEach { if (it.regexUrl(domain)) urls.send(it) }
        }
        repeat(requesterQty) { requester(urls, responses) }
        responseReceiver()
    }

    private fun responseReceiver() = GlobalScope.launch {
        while (true) {
            select<Unit> { responses.onReceive { launch { result(it) } } }
        }
    }
}

fun CoroutineScope.requester(urls: Channel<String>, responses: Channel<Response>) = launch {
    while (true) {
        select<Unit> {
            urls.onReceive {
                val response = get(it)
                println("response status: ${response.statusCode} for request: ${response.url}")
                Logger.logger.info { "response status: ${response.statusCode} for request: ${response.url}" }
                responses.send(response)
            }
        }
    }
}
