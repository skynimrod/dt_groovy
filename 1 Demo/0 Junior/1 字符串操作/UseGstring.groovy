package org.test

class UseGstring {

  static main(def args) {
    
    gstring的用法(理解成转义也成)
    def str1=编程语言
    def str2=Groovy
    println $str1$str2
    println '$str2'
    
    
    字符串操作函数
    def str3=上海市浦东新区轨道交通2号线
    def str4=hello world
    def str5=你,好
    截取字符串
    println str3.substring(0,7)
    大小写转换
    println str4.toUpperCase()
    拆分字符串
    def split=str5.split(",")
    for(item in split){
      println item
    }
    字符串替换
    println str4.replaceAll(world, Tom)
    字符串转为数字
    def str6=28
    def str7=2
    println str6.toInteger()+str7.toInteger()
    字符串的减法
    def str8=abcd
    println str8-c
    contains的使用
    println str8.contains(c)
  }

}