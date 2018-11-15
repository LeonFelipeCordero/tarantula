import com.ph.tarantula.sitemap.SitemapSpider

fun main(args: Array<String>) {
   val sitemapSample = SitemapSample()
    sitemapSample.start()
}

class SitemapSample : SitemapSpider("http://localhost:8080/sitemap.xml.gz", "localhost:8080", 10)
