import org.grails.shortenurl.*

class ShortenUrlService {
    boolean transactional = false

    def tinyurl(String longUrl) {
      return TinyUrl.shorten(longUrl)
    }

    def isgd(String longUrl) {
      def shortUrl = IsGd.shorten(longUrl)
      if(shortUrl.contains("error")){
        log.error(shortUrl)
      }
      return shortUrl
    }
}
