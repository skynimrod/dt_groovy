�μ�:

     http://www.grails.org/         ������ ���Դ�

     http://www.grails.org/single-page-documentation.html

     http://www.grails.org/download.html     ���ص�ַ

     http://www.grailscn.com/       ����ǹ��ڵĹ���

     http://baike.baidu.com/view/1097340.htm?fr=aladdin

     ѧϰ:  https://grails.org/learn      �ǹٷ��ṩ��ѧϰ����, �ǳ���

            grails-petclinic-master.zip   ������ �ṩ��һ���򵥵�����. 

. Grails ��Groovy ��Web �������. 

. Grails ��һ�����ڿ���WebӦ�ÿ����Ŀ�Դ���, ������Groovy �������, ������ ��Spring��Hibernate��������׼Java���֮��, �Ӷ�Ϊ��Ҵ���һ����ʵ�ֳ�����������һվʽ���.

  Ruby on Rails ������һ��ǿ��ı������ �� һ����ּ������ᳫ�� ͨ������Ĭ������ ���� �������õĿ�ܽ��д����Խ�ϵ��Ⱥ�. Ȼ��, ���������֯ ��û������ ��Java �İ�ȫ����ɡ�� �߳�����׼��, Ҳ���д����������Ŀǰ��Java �ϵ�Ͷ��. �� Grails �ĳ���, ʹ����һ����Java Ϊ���ĵĻ�����ʵ��ͬ�����������뷨��Ϊ����. 

. ���

     grails �Ĳ��ϵͳҲ��������֮һ. ����, ��rails�� django ��web�������, ����΢�ں˵�˼��, ���(������ģ��)�ǿ�ܵ�һ�ȹ���.  grails ���� ����ģ������Ĺ��ܼ�������ͨ�������ʽʵ�ֵ�. ʵ����, һ�� grails �����һ��grails Ӧ�� ��������ȫһ����, ͬ������ʹ��grails run-app ����������. ���������һ������ĸ�Ŀ¼����Ҫ�ṩһ��fooplugin.groovy �ļ�, �ṩ�����һЩ������Ϣ.

     grails ��������������κ�����, grails���� �Ѿ��ṩ�˸�ʽ�����Ĳ��, ������grails �ٷ����Դ��.

        grails list-plugins                                �鿴���еĹٷ����

        grails install-plugin ���������·��             ��װ���

        grails uninstall-plugin  ����� ���� ���·��      ж�ز��

. �ص�

     ����Java Web ��������������˵�Ѿ���ù��ڸ���. �����ڶ�Java �����Web ������ܲ���ʹ�ø���, ���Ҳ�û�кܺõ���ѭ Don't Repeat Yourself (DRY) ԭ��. �� Rails�� Django �� TurboGears �����Ķ�̬��� ��Web�������򿪱���һ���µĵ�·, Grails ������Щ����֮��, ���ö�̬������С��Java ƽ̨�Ͻ���web �����ĸ��Ӷ�, ��������Щ��ܲ�ͬ����, grails �ǹ�����Spring ��Hibernate ��Java ���м���֮�ϵ�. Grails ��һ��full-stack ���, �������� ���ļ�������صĲ��(Plug-in) ����� web ������ �������������, ����:

    1. ����ʹ�õĻ���Hibernate �Ķ���-��ϵӳ��(ORM)��, ��Ϊ Groovy Server Pages (GSP) �ȱ��ֲ㼼��

    2.  ���� Spring MVC �Ŀ�������

    3.  ������ Gant �ϵ������� �ű����л���, ���� Tomcat ������, �������������������Ϳ��Խ��м���

    4.  �������õ�Spring ����ʵ������ע��

    5.  ����Spring ��MessageSource ���ĸ���, �ṩ�˶Թ��ʻ�(i18n) ��֧��

    6.  ����Spring ����������, ʵ����������

    7.  �����ڹ���ǿ���Groovy ��̬���Ժ������ض�����( Domain Specific Language, DSL), ������Щ���Ա�÷ǳ�����.

. ʾ��

  ��һ���������˵Ķ��־��������, �ڴ���Ӧ�ó���֮ǰ, ����Ϥһ�� grails �����ʹ��(ȷ��grails �����Ѿ����ú�)

     grails command name

  ����Ϊ�˴���һ��grails Ӧ��, ��Ҫ�����������create-app

     grails create-app helloworld

  �������ڵ�ǰĿ¼�´�����һ����Ϊhelloworld (�����ǵ�Ӧ�ó�����)���ļ���, ������ļ����а��������������Ŀ�������ļ�Ŀ¼, ����ʹ����������������Ŀ¼�в鿴:

    cd helloworld

  Ϊ�������������Hello World ʾ��, ������Ҫ���� create-controller ����,�Ƚ���CMD ���ִ��:

    grails create-controller hello

  ���и���������grails-app/controller Ŀ¼�´���һ����Ϊ HelloController.groovy �Ŀ�����. ��������Ҫ������ɶ�Web ����Ĵ���, ������΢�޸�һ�¿�����������, ʹ���ܹ���ҳ�������"Hello world!"������, ��������:

     class HelloController {
           def world = { render "Hello World!"}
     }

  �������Ѿ������, ������Ҫʹ��run-app ���������õ�jetty�����������иոմ�����helloworld ����.

  grails run-app ���к����8080 �˿�(Ĭ�ϵ�, ����ʹ�� -Dserver.port ��ָ���˿�)����������, Ȼ���������������

     http://localhost:8080/helloworld ������Ӧ�ó���.

. SpringSource �ṩ��һЩ Training ������. ���Ƕ��й�Ҫ�շ�. �μ�:

      http://mylearn.vmware.com/mgrReg/plan.cfm?plan=31719&ui=www_edu

. "Լ����������" (Convention Over Configuration)

. Ajax (�첽JavaScript �� XML)�� ��־��Web 2.0 ʱ���ĵ���. 

. ���е�Java �����ѭ���Ǵ�ͳ�� ����->����->�����ģʽ, ��������������Ӻ���Ŀ��ģ������, ��һ�������Ի�����ӷ��.  Ajax ��������Ŀ��ģ�ϲ��ɱ���Ļ���ڴ�ͳ��Web Ӧ�á� ��Ҳ��ζ��Ҫ�ڲ���һ��Web Ӧ�ó���ǰ�ı���ʹ������ ���Ѹ����ʱ��. 

  ����ЩAjax Ӧ�õ����̲��� Ҳ��ʼ��Ϊ����. ��Ϊ������״̬�����ڿͻ���, ��˵�Ӧ�÷�������������ʱ, ���ò����¼��������, ����ĳ���������Ǽ�����һ�ֵ���. 

  �����Ҫ��Ŀ��������Ӧʵ����Ҫ, ��������ھ�̬���͵�Java �������˵�������� , ��Ϊ Java ����Ҫ�����±���. ����̬��������һ���ǡǡ�෴, ��Щ��̬���Ի����ǽ�������, �����ܹ�������ʱ�Զ�������Դ.

  ����������̬����Ϊ�����Ŀ����˵, Ajax �ĵ�����ͬѩ����̿, ������Щ���Ҳ�׷�Ϊ������Ա�ṩ�˶�Ajax ����Ӧ�ú��Զ����ص�֧��.  �ڼ�����Prototype �� Acript.aculo.us ��JavaScript ��Ľ��ܼ���, ���ڿ�����Ա���Ժ����׵�ִ���첽����, ���Html Ԫ��, �Լ�ʹ�ø�������������Ч.

  ��Щ����ṩ�ĵ�������, �����û����޷�������, �Լ����ڹ�Լ�ı��, ��ʹ���Ϊ�����������Ŀ�������.

. Grails ѡ�������еĿ�Դ������Ϊ�������, ����Ŀ�Դ��Ŀ��������:

  1. Hibernate : Java �ж����ϵӳ���ʵ�ʱ�׼;

  2. Spring : ��Ϊ���еķ�ת��������������Java ��ܵİ�װ��;

  3. Quartz : �ǳ�������ҵ�� ��ҵ���ȿ��, ���Գ���ִ����ҵ;

  4. SiteMesh : �ȶ��Ĳ�����Ⱦ���. 

. Grail ����

  1. �ӹ��� http://grails.org/ �������·����İ汾

  2. ����ص�ѹ������ѹ��һ��Ŀ¼��, ������ר������������Ŀ¼, Ҳ���Լ򵥵�ֱ�ӽ�ѹ��������;

  3. ����GRAIL_HOME��������, ֵΪ ����2 �н�ѹ��Grails Ŀ¼·��.

  4. Ϊ���ܹ����ն˻��������������Grails �ű�, ��Ҫ��Grails ��bin Ŀ¼�ӵ�ϵͳ�������� "PATH"��. 

  5. ��֤.  D:\> grails

     ��Ҫע�����  grails 2.4.2 ��jre 1.5.0 ������, ���쳣, �����ǰ汾��֧��.   

     �� JAVA_HOME ָ�� JRE 1.7 ��, ���������Ϳ���������, ����ʾdownloads һ�� ����grails ��ص�jar�� Ȼ�����: 

     grails> ��ʾ��

  6. grails > quit

     �˳���ᷢ��, �ڵ�ǰĿ¼��, �����һЩ"." ��ͷ���ļ�, ��һ���־���grails ��ص�. ����һЩ��gradle, android, myeclipse, fgclient�� groovy, sts, m2 ��һ�󲿷��ļ���Ŀ¼. 

     �ǳ�����.....!!!!!!!!!!!!!!!!!!!!

. ��Ŀ��Ŀ¼ ���� Grails create-app,  ����ʾ����Ӧ������, ϵͳ���Զ�����ͬ����Ŀ¼, ������Ŀ¼���洴����Ӧ�ù����ļ���Ŀ¼.

  ����ղŴ�����Ӧ��Ŀ¼(����Hello)�� ���� Grails create-controller , ϵͳ���Զ�������Ҫ���ļ�(.pom, .jar), Ȼ����ʾ����controller������.

  ע��, ����ǻ�����һ������, ��Ҫȷ��������, ��Ҫͨ������������Ҫ���ļ�.  ϵͳ���Զ���grails-app\controlls\�´�����Ӧ��controller.

  ���ԣ�

       http://localhost:8080/hello  (�����������Ҫ��һ����ʵ)

       ʵ�������� Grails ����Ƕ��tomcat �����еģ� ��Ҫȷ�� ��Ƕ��tomcat ������ʲô�ط�. 

  ����Ĳ���ͨ����, ��ΪӦ�û�û������.  

  ��Ӧ��Ŀ¼��, ���� grails run-app  ������, ������ִ���. ������Ϣ�μ�: 

      log.txt, log2.txt (grails run-app 1>log.txt 2>log2.txt )

  ������־�� log2.txt �У�

    [groovyc] org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
  [groovyc] General error during semantic analysis: unable to locate the java compiler com.sun.tools.javac.Main, please change your classloader settings
  [groovyc] 
  [groovyc] java.lang.ClassNotFoundException: unable to locate the java compiler com.sun.tools.javac.Main, please change your classloader settings

   ���İٶ�����, �ƺ��ǲ�ͬ�����������(��������JDK1.5�� JDK1.7) . Ҫ�޸�������������ã�����

   û������CLASSPATH��������, �����й�ϵ>>><>>>>>

   ��β鿴grails ��ǰ������(����: ʹ�õ�JDK�汾, tomcat �汾��λ�õȵ�.)

   ���� �鿴Tomcat �� ����Ҳ����������. ���������Ƶ�����.   

. ���� Domain Class

  �ǳ��õ����. Domain Class ʵ���Ͼ��� ORM ��ʵ��, ���Ƕ���� ���ݵ�ӳ��. Grail �Զ��� ���ݵĲ���(��ɾ��) �����˽�ȥ. ͨ��Controller �����п��Ʋ���.  ʵ��Ҳ�ǳ���, ֻ��Ҫ��Controller ����� Domain Class �Ķ��弴��. 

  
. ��netBeans ���� ��Ŀ�� û�������κ����ݵ�ʱ�� ����ʱ��������Ĵ�����ʾ:

 Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error occurred during initialization of VM
agent library failed to init: instrument
Error |
Forked Grails VM exited with error

�����������洴��������Ӧ�õ�ʱ��, Ҳ������������⣺

Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grai
ls-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.ja
r

˵��������һ���ģ���VM�����ĳ�ʼ�������з����Ĵ����޷���ʼ����

����Ϊʲô����֮ǰ����Ŀ�Ϳ��ԣ� ���� Grails_OnlyController �Ϳ�����ȷ����

������Ҫ�޸������ļ�:

   BuildConfig.groovy  

   run:.....

   �޸�Ϊ : run: false,

  Ȼ�����о�û�������ˡ�