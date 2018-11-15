package com.ph.tarantula

import khttp.get
import khttp.responses.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

//fun CoroutineScope.processRequest(urls: ReceiveChannel<String>, responses: Channel<Response>, numberOfWorkers: Int) {
//    val requests = Channel<String>()
//    repeat(numberOfWorkers) { worker(requests, responses) }
//    requester(urls, requests)
//}
//
//private fun CoroutineScope.worker(requests: ReceiveChannel<String>, responses: SendChannel<Response>) {
//    launch {
//        for (url in requests) {
//            val response = get(url)
//            responses.send(response)
//        }
//    }
//}
//
//private fun CoroutineScope.requester(urls: ReceiveChannel<String>, requests: SendChannel<String>) {
//    launch {
//        val requested = mutableSetOf<String>()
//        while (true) {
//            select<Unit> {
//                urls.onReceive { url ->
//                    if (!requested.add(url)) requests.send(url)
//                }
//            }
//        }
//    }
//}
