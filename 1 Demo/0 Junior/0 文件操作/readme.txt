/*
 * 对文件的访问，尽量读取到内存后访问内存， 频繁访问文件， 效率极低，特别是需要频繁重新定位的操作
 * 即便是一个几MB 的文件， 如果涉及频繁定位读写，那么一旦到百次级别， 可能就需要几分钟
 * 所以为了效率，可以浪费一点内存使用率， 几MB的内存短时间访问也不会太浪费系统的资源， 
 * 使用后释放即可

 在处理大文件时，如果利用普通的FileInputStream 或者FileOutputStream 抑或RandomAccessFile 来进行频繁的读写操作，都将导致进程因频繁读写外存而降低速度.
 */

. 参见:

      http://blog.csdn.net/kypfos/article/details/3097032

.  1. 判断目录是否存在， 创建目录

            def destDir = date.format("YYYYMMdd")

            def dir = new File("D:/R ReportData/" +destDir )
            if (!dir.exists() ) {
                println "目录不存在， 创建目标目录"
                dir.mkdirs()
            }

. 2. 获取当前路径

. 3. 删除文件

     
     