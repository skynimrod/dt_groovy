. 环境 Grails 2.4.2

. GSP中设定 UTF-8， Config.groovy 中也设定是 UTF-8， 但是显示出来就是乱码。 

. 在CONTROLLER中将以下两句：

    request.setCharacterEncoding("gbk");
    response.setCharacterEncoding("gbk");
加入到render之前，试试。

http://hi.baidu.com/laopo521anping/blog/item/3b48edf1b4f05ec97931aabe.html/cmtid/b9ccacda4b734968d0164ec1

. 应该是Tomcat 的编码设置问题

默认情况下，tomcat使用的的编码方式：iso8859-1

修改tomcat下的conf/server.xml文件

找到如下代码：   
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
这段代码规定了Tomcat监听HTTP请求的端口号等信息。

可以在这里添加一个属性：URIEncoding，将该属性值设置为UTF-8，即可让Tomcat（默认ISO-8859-1编码）以UTF-8的编码处理get请求。

修改完成后：

<Connector port="8080"  protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />

. 经过查证， 当前tomcat 的设置已经是UTF-8了， 如下：

  <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" URIEncoding='utf-8' URLEncoding='utf-8'/>

但是为什么还是不行哪？？

. 现在的问题可能是spring 的容器显示问题， 即gsp 自身的问题。