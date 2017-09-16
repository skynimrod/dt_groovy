class TestController {
    def shortenUrlService

    def index = { 
      render "This is a test for the ShortenUrl plug-in <br/>" + 
             "Type test/tinyurl?q=http://grails.org to try it out." 
    }
    
    def tinyurl = {
      render shortenUrlService.tinyurl(params.q)
    }    
}
