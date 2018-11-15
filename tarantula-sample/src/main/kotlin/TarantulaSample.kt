import com.ph.tarantula.Spider
import khttp.responses.Response

fun main(args: Array<String>) {
    val tarantula = TarantulaSample()
    tarantula.start()
}

class TarantulaSample : Spider(
    mutableListOf(
        "http://localhost:8080/test/aa", "http://localhost:8080/test/ab",
        "http://localhost:8080/test/ac", "http://localhost:8080/test/ad"
    ),
    "localhost:8080",
    5
) {

    override fun result(response: Response) {
        addUrl(response.url + "a")
        response.text
    }

    override fun stop() {}
}

