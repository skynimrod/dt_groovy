. 参见:

      http://blog.csdn.net/kypfos/article/details/3097032

.  write 是覆盖式的, 多个write 只会保留最后一个

  fp = new File( "1.txt")

  fp.write("hello")
  fp.write("world")


. append 是 追加式的

  fp.append("hello ")

  fp.write("world\n\r")