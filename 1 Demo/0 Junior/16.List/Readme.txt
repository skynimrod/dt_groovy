. �μ�

      http://m.blog.csdn.net/blog/chenwill3/23337975
  
      http://chenfeng0104.iteye.com/blog/609075

. 1. ����ж�list ���Ƿ��и�����value?

     def list = ["1", "b", 1, 4, 8 ]

     if ( 1 in list ) {
	println "OK"
     }

. 2. ��list �е�����ƴ������

     def li = []

     li.add("first")
     li.add("second")

     def str = ""
     li each { item ->
          str += item
     }
   

. 3. ��ȡlist ��Ԫ�ظ���

    def li = ["1","2","3"]

    def llen = li.size()

    # ��ϣ��Ҳ��ͬ����size()������

. 4. ɾ��list �е�Ԫ��

    def li = ["1","2","3"]
 
    li.remove(0)

    println li 		// ���Ϊ: [2, 3]
