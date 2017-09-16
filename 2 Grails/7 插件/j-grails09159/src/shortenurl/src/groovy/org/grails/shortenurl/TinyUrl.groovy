package org.grails.shortenurl

class TinyUrl{
  static String shorten(String longUrl){
    def addr = "http://tinyurl.com/api-create.php?url=${longUrl}"
    return addr.toURL().text
  }
}