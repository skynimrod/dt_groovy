package org.grails.shortenurl

class IsGd{
  static String shorten(String longUrl){
    def addr = "http://is.gd/api.php?longurl=${longUrl}"
    def url = addr.toURL()
    def urlConnection = url.openConnection()
    if(urlConnection.responseCode == 200){
      return urlConnection.content.text
    }else{
      return "An error occurred: ${addr}\n" + 
      "${urlConnection.responseCode} : ${urlConnection.responseMessage}"
    }
  }
}