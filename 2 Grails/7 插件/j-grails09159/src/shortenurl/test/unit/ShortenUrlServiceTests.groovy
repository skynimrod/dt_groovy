import grails.test.*

class ShortenUrlServiceTests extends GrailsUnitTestCase {
    def transactional = false
    def shortenUrlService
  
    protected void setUp() {
        super.setUp()
        mockLogging(ShortenUrlService)
        shortenUrlService = new ShortenUrlService()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testTinyUrl() {
      def shortUrl = shortenUrlService.tinyurl("http://grails.org")
      assertEquals "http://tinyurl.com/3xfpkv", shortUrl
    }

    void testIsGd() {
      def shortUrl = shortenUrlService.isgd("http://grails.org")
      assertEquals "http://is.gd/2oCZR", shortUrl        
    }

    void testIsGdWithBadUrl() {
      def shortUrl = shortenUrlService.isgd("IAmNotAValidUrl")
      assertTrue shortUrl.startsWith("An error occurred:")
    }
}
