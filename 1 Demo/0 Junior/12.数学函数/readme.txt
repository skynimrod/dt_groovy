参见:

     http://blog.csdn.net/lixiang0522/article/details/7557851     Java 中的应用就是Groovy 中的应用

     http://blog.sina.com.cn/s/blog_61d8d96401013fnr.html

     在Netbeans 开发环境中 输入 Math. 等会一会儿， 会显出 Math 中相关的数学函数

. 1. 取绝对值

      days = Math.abs(days)       // 先取正，最后处理结果+1 即可

. 2. 取整

     参见:   http://www.thinksaas.cn/group/topic/151824/

     

先变为string类型，再返回小数点的位置，再用substring取出小数点前的数字！

     向上取整:Math.ceil() //只要有小数都+1
     向下取整:Math.floor() //不取小数
     四舍五入:Math.round() //四舍五入 

. 3. 取余数

     println 2015%100         // 返回结果  15 
