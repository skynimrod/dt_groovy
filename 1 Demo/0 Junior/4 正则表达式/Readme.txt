. 参见:

      http://www.360doc.com/content/12/1127/07/820209_250456233.shtml

      http://tool.oschina.net/regex    在线测试 正则表达式 的网站

. 用 /../ 定义正则表达式

  Groovy 中使用 slashy(斜线)语法"//" 定义正则表达式, 对于出现在表达式中特殊字符, 会自动进行转义. 比如

      def name = "Ted Naleid"

      assert ( /$name/ == "TedNaleid" )
      assert (/$name/ == "$name")

      assert( /Count is \d == "Count is \\d" )

. 操作符

  ～: 用在字符串之前, 灰浆字符串编译成Pattern. 比如:

       def  shoutedWord = ~/\b[A-Z]+\b/

  =~: 将操作符左边的字符串跟右边的Pattern 进行局部匹配, 返回值为Matcher. 如：

     def matcher = ("finda" = ~/find/ )

     assert "find"=matcher[0]

  ==~: 用法跟 =~ 类似， 只是这里进行的精确匹配, 即左边的整个字符串跟右边的模式进行匹配, ==~的结果跟 Matcher.matches() 的结果是一样的. 返回值为Boolean. 如：

      def matcher = ( "finda" ==~ /find/ )

      assert java.lang.Boolean == matcher.getClass()

. 最字符串的改进

   1. replaceFirst:  将满足正则表达式的第一个字符串进行替换, 比如：