. ���� Grails 2.4.2

. GSP���趨 UTF-8�� Config.groovy ��Ҳ�趨�� UTF-8�� ������ʾ�����������롣 

. ��CONTROLLER�н��������䣺

    request.setCharacterEncoding("gbk");
    response.setCharacterEncoding("gbk");
���뵽render֮ǰ�����ԡ�

http://hi.baidu.com/laopo521anping/blog/item/3b48edf1b4f05ec97931aabe.html/cmtid/b9ccacda4b734968d0164ec1

. Ӧ����Tomcat �ı�����������

Ĭ������£�tomcatʹ�õĵı��뷽ʽ��iso8859-1

�޸�tomcat�µ�conf/server.xml�ļ�

�ҵ����´��룺   
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
��δ���涨��Tomcat����HTTP����Ķ˿ںŵ���Ϣ��

�������������һ�����ԣ�URIEncoding����������ֵ����ΪUTF-8��������Tomcat��Ĭ��ISO-8859-1���룩��UTF-8�ı��봦��get����

�޸���ɺ�

<Connector port="8080"  protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />

. ������֤�� ��ǰtomcat �������Ѿ���UTF-8�ˣ� ���£�

  <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" URIEncoding='utf-8' URLEncoding='utf-8'/>

����Ϊʲô���ǲ����ģ���

. ���ڵ����������spring ��������ʾ���⣬ ��gsp ��������⡣