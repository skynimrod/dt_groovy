package org.grails.shortenurl

class TinyUrlTests extends GroovyTestCase{
  def transactional = false

  void testShorten(){    
    def shortUrl = TinyUrl.shorten("http://grails.org")
    assertEquals "http://tinyurl.com/3xfpkv", shortUrl
  }
}