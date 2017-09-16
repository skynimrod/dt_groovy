package org.grails.shortenurl

class IsGdTests extends GroovyTestCase{
  def transactional = false
  
  void testShorten(){
    def shortUrl = IsGd.shorten("http://grails.org")
    assertEquals "http://is.gd/2oCZR", shortUrl        
  }
  
  void testBadUrl(){
    def shortUrl = IsGd.shorten("IAmNotAValidUrl")
    println shortUrl
    assertTrue shortUrl.startsWith("An error occurred:")
  }
}  