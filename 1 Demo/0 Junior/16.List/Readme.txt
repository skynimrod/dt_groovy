. 参见

      http://m.blog.csdn.net/blog/chenwill3/23337975
  
      http://chenfeng0104.iteye.com/blog/609075

. 1. 如何判断list 中是否有给定的value?

     def list = ["1", "b", 1, 4, 8 ]

     if ( 1 in list ) {
	println "OK"
     }

. 2. 将list 中的内容拼接起来

     def li = []

     li.add("first")
     li.add("second")

     def str = ""
     li each { item ->
          str += item
     }
   

. 3. 获取list 的元素个数

    def li = ["1","2","3"]

    def llen = li.size()

    # 哈希表也有同样的size()方法。

. 4. 删除list 中的元素

    def li = ["1","2","3"]
 
    li.remove(0)

    println li 		// 结果为: [2, 3]
