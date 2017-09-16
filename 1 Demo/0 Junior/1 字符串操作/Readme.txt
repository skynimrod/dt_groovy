. 参见:

       wiki-snapshot.pdf->1.2.3.7

       http://www.groovy-lang.org/syntax.html#all-strings    官方在线文档

      http://www.ibm.com/developerworks/cn/java/j-pg10255.html

. 1. Groovy 中的字符串可以使用双引号"和单引号'。 非常方便. 

  println "he said 'cheese' once"

  println 'he said "cheese" again'

. 2. 多行字符串

  def  text = """\
  hello  there ${name}
  how are you today?
  """

. 3. slashy String literals   正则表达式的字符串

  def  s = /.*foo.*/

  def dirname = /^.*\//

  def basename = /[Strings and GString^\/]+$/

. 4.

  def noParam = { -> println "I'm executed";
  return "no param"}

  def oneParam = { out -> println "Executed with a ${out.class}
  parameter"; out << "one param"}

  def printSum = {a, b -> print a+b }

  printSum(5+7)

  // prints "12"

. 5. 遍历字符串中的字符的例子

          def content = 'var szzbAffiches=[["000707","finalpage/2014-09-12/1200226442.PDF","双环科技：关于召开公司2014年第四次临时股东大会的提示性公告","PDF","250","2014-09-12","2014-09-12 00:00"],["000402","finalpage/2014-09-12/1200226440.PDF","金 融 街：关于回购股份事项中前十名股东持股信息的公告","PDF","88","2014-09-12","2014-09-12 00:00"]]'
        for ( def i = 0; i < content.length(); i ++ ) {
            if ( content[i] == '[') {
                println "Yes , i find ["
                println content.substring(i,content.length())

                println content[0] + content[1] + content[2]
                break
            }
        }

. 6. 字符串比较

  def a = "hello"
  def b = "hello"

  println a == b ? "-)" : "-("

. 7. 判断字符串是否为空

    
. 8. 删除字符串中的空格

     删除头尾的空格: trim() 

     def s = "  a c d  "
     println s.trim()
 
       
. 9. 拆分字符串

     def keys = keysList.split(",")
        for ( item in keys )  {
            println item
            item = item.replaceALL(/(^s*)|(s*$)/g,"")

            println item
        }

    或者 

        def keys = keysList.tokenize(",")
        for ( item in keys )  {
            println item
            //item = item.replaceALL(/(^s*)|(s*$)/g,"")
            //println item
        }

    这2中方法效果一样， 不过后一种好像效率更高点。

. 10. 判断字符串内容是否全是数字 (扩展， 判断字符串内容是否符合指定格式)

    def f = ! (year ==~ /[\d]{4}/)

    使用正则表达式来进行判断是否匹配

. 11. 数字型字符串转换为数字

     def ab = "123"
     def bb = ab.parseInteger()			----》  这个不正确， 没有这个方法
     def bc = Integer.parseInt( ab )

. 12. 格式化字符串

     String.format("%04d-12-30", curyear )

     println String.format("-----%d---", k )    // 这是println 实现格式输出的一种方法, 应该用 Integer.parseInt()


. 13. 字符串加减

    println "1999"-1       // 输出结果为999

    println "1999"+1       // 输出结果为 19991

    println "1999"-9       // 输出结果为 199

. 14. 常数数字转字符串

    1.toString()

   println leapmap[1.toString()]

. 15. 取字符串的子串

        def DateStr = "2014-11-23"
        println DateStr.substring(0,4)                   // 第一个参数是开始下标， 后一个参数是截至下标，不包含这个下标内容
        def year = datestr.substring(0,4) 
        def month = datestr.substring(5,7)
        def day = datestr.substring(8,10)

        println DateStr[0..3]				// 这是第二种取子串的方式
            year = Integer.parseInt( DateStr[0..3] )
            month = Integer.parseInt( DateStr[5..6] )
            day = Integer.parseInt( DateStr[8..9] )

. 16. 判断字符串中是否有目标子串  indexOf()

                if ( temp.indexOf( "startxref" ) != -1 ) {  // 不等于-1 表示找到了startxref
                    temp = rd.readLine()
                    println "位置:" + temp
                    xrefpos = Integer.parseInt( temp )
                    println xrefpos
                    break
                } 

. 17. 十六进制字符串转换为数字

     def  str = "0x0137"
     def  desnum = Integer.parseInt( str.substring(2,6), 16 )     // 需要注意的是转换的时候不能包含0x

. 18. 数字转换为十六进制字符串

      Integer.toHexString(n).toUpperCase()

      方法2: 

            	def n = 311
        
        	println String.format("%04x", n )       // 出来结果是 0137, 不带0x的， 
							//如果大写的X, 则是类似01A8, 如果是小写的x, 则是类似01a8