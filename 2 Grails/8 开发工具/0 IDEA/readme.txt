. �μ�:

      http://wenku.baidu.com/link?url=Mfuif3r_465qTY6MDfO-fSqSJGRA8ClM7jKzOtVJKhDfgJNJnLKrmUQN1jQbSfZmySLsHa5R8jiTmH84vGst6LwggGHFeyzrc-2LGxxVxvO

. 1. IEDA ���� JRE ���л���

    ѡ�� JDK �İ�װĿ¼, �� Project Settings �����ã� ������Project SDK ��ѡ�� ��������JDK ��λ�á� ����������project �����λ�á�


         ����JDK 1.7 ���õ�glassfish4, �����Զ��ҵ��Ŀ�����JDK 1.5�� ���Ը�������ΪJDK 1.7��·��  

            D:\glassfish4\jdk7

         ͬʱIEDA Ҳ���Զ��ѵ� Groovy ��·���� ���õ��������ˡ�

      ����ѡ���µ�project �Ƿ�ʹ�ö���Ŀ�Ϳ�ܣ� �� Groovy.

   ** һ�����½���һ��project ����Խ������á�

   ֮ǰ���ص���Ѱ治֧��Grails, ����û��Grails ����Ŀ֧�ֲ��֡� ������������ IDEA Utimate 14 �汾�� ������Ҫע��

   ע����μ�: 

        http://www.csdn123.com/html/topnews201408/28/6928.htm

   �����õ���:  (ע���ʱ��������� Ϊ�˷�ֹ���Ѿ�ע��������˳�ͻ)

       key:huangwei
       value:97493-G3A41-0SO24-W57LI-Y2UGI-JGTU2
 
. 2. ����

    ��㴴��һ��Java Project , Ȼ����src Ŀ¼�д���һ��java ���� ������Java /junior �е�HelloWorldX �����в��ԡ�

    ���м��ɡ�

    * ��Ҫע����ǣ� �༭�Ĺ����У� ����IDEA ��VIM �Ŀ�ݼ����ظ��� ��^A ^C, ^V �ȵ�ʱ�����ѡIDE shortcut , �����Ͳ�Ӱ��ʹ���ˣ� ��Ȼ���ڱ༭������VIM , Ҳ������ʱ�л���VIM ��ݷ�ʽ�£� �ǳ����㡣

     �л� ���Ե�� ���½ǵ�ͼ�ꡣ

. 3. ���� Grails project

     ������ʱ��û����ʾGrails ��λ�ã� ������IDEA �İ汾��֧�֡� ���ϲ鿴:

     http://wangcheng.iteye.com/blog/173860


     File -> Settings -> IDE Settings -> Groovy&Grails 

     ��Ҫ�Ȱ�װ JetGroovy ����� Ȼ������JetGroovy, ���� Grails��(��ȻҪ��ǰ���ز���ѹGrails-bin-...zip)

     ??�°汾�и���û�� ����˵�İ�װJetGroovy �����λ�á�

     �п����ǰ�װ�����IEDA �汾��֧��Grails , �������ص�ʱ�� ��2��IDEA �汾�� ѡ���������ģ� ����ѡ����������ԡ�

    ���ز���װ  IDEA Utimate �汾�� �Ϳ���ֱ�Ӵ���Grails project�ˡ����Ǵ�����Controller ��Domain�� �� ����û���ҵ������ļ�λ�ã� ����DataConfig.groovy, BuildConfig.groovy�ȡ� �����Ͳ��ܰѱ�����Ŀ�����ݿ��ˡ�

     ���⣬ Ҳ����֮�����У� ÿ����Ϫ��Ҫ��Debug ��ʽ����֡���

    ������½ǵ�ͼ�꣬ ѡ�� Grails Console, ���Կ���ÿ�β�����������. 

    ���е�ʱ���������Ĵ���:

Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error |
Forked Grails VM exited with error

  ��Project  Structure �� Libraries �У��м��+�ţ� Ȼ��ѡ��Maven ����

       org.springframework:springloaded:1.2.0.RELEASE

  Ȼ���������� ѡ�У������� �µİ汾������Ϊ��ֹ�汾��һ�£� ��������ʾ�İ汾����Ȼ�� ѡ�����ص� Ӧ�õ�lib Ŀ¼�С�

  Ȼ�����ʾ�� ѡ��ģ�飬  

       abc

       abc-grailsPlugins
 
  ��ѡ���abc, ��Ϊ��Ӧ����������Ҫ�ġ�

  Ȼ��������Ӧ�á�  �ֳ�������Ĵ���:


Packaging Grails application
................Error 
|
Error executing script RunApp: loader constraint violation: loader (instance of java/net/URLClassLoader) previously initiated loading for a different type with name "org/springsource/loaded/ReloadableType" (Use --stacktrace to see the full trace)

Process finished with exit code 1


URLClassLoader��ClassLoader�����࣬�����ڴ�ָ�� JAR �ļ���Ŀ¼�� URL ������·�����������Դ��Ҳ����˵��ͨ��URLClassLoader�Ϳ��Լ���ָ��jar�е�class���ڴ��С�


�������Ӧ������2������������ͻ�ˣ� һ���� Java��URLClassLoader, ��һ�������� Spring�� ReloadableType.  ����������

�������ֻ��ѡ����һ�� Application Server �� �������������Grails Project , ������ʾʵ��Tomcat 7.0.5, ���Ƕ��ڴ򿪵�ҳ�棬  localhost:8080�� ��û��������ʾ��ȱʡ��Grails ��ӭҳ�档 ����Ҳû����ʾ�κδ��� ���ָ�� Controller �� ����:

   localhost:8080/FrController , Ҳû�����ƺ��κ�����, ����Ҳû����ʾ�κδ��� 


====================================

  ���lib ��ʱ�� ��netbeans ��Grails ��Ŀ�е�lib �� mysql-connector-java-5.1.5-bin.jar, Ҳ������������Ӧ�õ�lib Ŀ¼�£� ӦΪҲ���õ��� 

  �����Һѹ��

  ����Grails Project ��ʱ��  ��ʾ

     Spring Configuration Check

     Unmapped Spring configuration files found. Disable....

     Please configure/setup Spring facet for modules:
 
     sdf (1 file)

  ��Project Structure -> Project Settings -> Modules ������  ���  Spring Application Context (����Ĭ�ϵ�+ �� Ȼ��OK)

  �μ�:

       http://blog.csdn.net/tiantiandjava/article/details/41204607

  ���¹رմ�Project , ����Spring����ʾû���ˣ� �����µ���ʾ:


   Unregistered VCS root detected

   The directory E:\4 WorkSpaces is under Git, but is not registered in the Settings:

   Add root, Configure, Ignore

  ������ǰ汾���ƵĲ��֣� ��㴦���ɡ� 

==========================================

�鿴 IntelliJ IDEA UI 14.1.4 �汾����������е�Manul -> Grails ����

. IDEA ֧�� Grails 2.0.0 + ����������

. 1. ׼������

     ����SDK ���Ұ�װ�����ú�

      Grails �����IDEA �м��  ���û�м�� ��������ķ������м���:

      �� Settings �Ի���( Ctrl + Alt + S )

      �������pane, ѡ�� Plugins

      ��Plugins page  (����Ĵ򿪵ĶԻ�����)

           ����plugin,  ѡ�����ֵ�check box

           ����plugin, ��� check box �ĶԺ�

      ����б���û�ж�Ӧ�Ĳ���� ��Ҫ���ذ�װ���

      ��������IDEA ��ȷ���޸���Ч��

  . �Ҽ���� Grails Project ���ƣ� "Grails" -Run Grails target  ���ֶ�����Grails Project,  

       Command Line :  ���� run-app (Ҳ��������ѡ��)

        ��ѡ��ѡ����ʱ��ȱʡ�ģ� VM options ��֪����ɶ�ã�

    Ȼ����OK.  �Ϳ�ʼ����Grails Project �ˡ�  ���е�ʱ����Զ����ذ�װ��Ҫ�Ĳ����Ȼ����б��롣  ����������Ĵ���:


Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error |
Forked Grails VM exited with error


     �� springloaded\jars\springloaded-1.2.0.RELEASE.jar ��������ǰ��project ��lib Ŀ¼���棬 Ȼ���������С� Ȼ���ֳ�������Ĵ��� 

................Error 
|
Error executing script RunApp: loader constraint violation: loader (instance of java/net/URLClassLoader) previously initiated loading for a different type with name "org/springsource/loaded/ReloadableType" (Use --stacktrace to see the full trace)

���ܲ��ܽ�  springloaded-1.2.0.RELEASE.jar ������project ��lib Ŀ¼���棬 ������ʵ�ʱ����ܻ���ִ��� 

���������Բ���  stackflow :

   https://www.baidu.com/link?url=7Qp0IDeou_Y6_-FfInW5V51xDmoDeqYnilErg7z4ivItz8hGWaQMHdlNpaHpM3p2UZqPO09WZN69FPHPlkDZrozAWcbDzjKPbTtMTZ2aix7XTSz9QQ7I7Hi0DT2hJfPVPT93zRMVEA8-QNCqdfmF6_&wd=&eqid=8a4d724300033c0b0000000355b320b4

  Ӧ����֮ǰ VM �Ĳ���û�������й�ϵ�� 

���ٶ�֪����˵��:

   http://zhidao.baidu.com/link?url=6zOThYIIIWRnS_W4Zj-vQyRy51M-6Bv81QD78Za25epDEriiwiwLkSkC37ABk87hVTAxf9JWbcgfkRh9HLaeu_

Ҳ�������grails��D:/Program file/�����ĳһ���ļ������� ������Ϊ�пո�������ʶ�����Ծ�˵�Ҳ�������ļ��� 

�Ҿ�������������� Ȼ���Ұ�grails����D�̸�Ŀ¼�����OK��

  ����ش���֮ǰ

     http://stackoverflow.com/questions/23530157/error-opening-zip-file-or-jar-manifest-missing-c-program

  �еĻش�������ͬ�������ã� ������˫���š� 

  ������netbeans ����Grails Project, û�����⣬ �������С� ���־����� Packaging Grails application. ���²鿴Packing ����

  �μ�:

       http://segmentfault.com/a/1190000000353272

  ��λ�˵����VM ��Grails �Ĺ�ϵ��  
 
       "Grails ��һ������Groovy ��Java �Ŀ�ԴWeb ��ܡ� ����Java �����(JVM)��˳ӦRails��Django������Web��ܶ�����, �����ű�׼��Jetty/Tomcat ��������  Grails �ܰ��������߽��п��ٵ�Ӧ�ÿ���.  

  ����˵�� IDE ������Ӧ���Լ����ö�ӦVM ������Ϣ�� �����ߵ�����Ӧ�������ɡ� ��������IDEA ���ֵ����������VM �����ˡ�

  ��IEDA ��Project ��  grails.bat ��������һ�仰:


  set AGENT_STRING=-javaagent:wrapper/springloaded-1.2.0.RELEASE.jar -noverify -Dspringloaded.synchronize=true -Djdk.reflect.allowGetCallerClass=true -Dspringloaded=\"%SPRINGLOADED_PARAMS%\"

  ���Ӧ����VM ��ص����á�

  ɾ��lib Ŀ¼�е� springloaded-1.2.0.RELEASE.jar. ������2��ͬ��jar ���ֳ�ͻ�ˡ� Ȼ����IDEA �е�Project ͻȻ���������ˣ� ����netbeans ��project Ҳ�õ���8080 �˿ڣ� ֹͣ�� netbeans ���еĵ�project�� Ȼ���������� IDEA�� Project , �ɹ����У�

D:\glassfish4\jdk7\bin\java -Dgrails.home=E:\grails-2.4.2 -Dbase.dir=E:\3 -Dtools.jar=D:\glassfish4\jdk7\lib\tools.jar -Dgroovy.starter.conf=E:\grails-2.4.2/conf/groovy-starter.conf -Xmx768M -Xms768M -XX:MaxPermSize=256m -XX:PermSize=256m -Djline.WindowsTerminal.directConsole=false -javaagent:E:\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar -noverify -Dspringloaded=profile=grails -Didea.launcher.port=7533 "-Didea.launcher.bin.path=C:\Program Files\JetBrains\IntelliJ IDEA IU 14.1.4\bin" -Dfile.encoding=GBK -classpath "E:\grails-2.4.2\lib\org.codehaus.groovy\groovy-all\jars\groovy-all-2.3.3.jar;E:\grails-2.4.2\dist\grails-bootstrap-2.4.2.jar;C:\Program Files\JetBrains\IntelliJ IDEA IU 14.1.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.groovy.grails.cli.support.GrailsStarter --main org.codehaus.groovy.grails.cli.GrailsScriptRunner --conf E:\grails-2.4.2/conf/groovy-starter.conf "run-app -plain-output"
|Loading Grails 2.4.2
|Configuring classpath
.
|Environment set to development
.................................
|Packaging Grails application
....................................
|Running Grails application
|Server running. Browse to http://localhost:8080/3

 �����������:
 
      http://localhost:8080/3

  ������ȷ��ҳ����Ϣ�� �� Grails �� ��ӭ��Ϣ�� ��NetBeans ���½� Project ���е�һ���� 

  ��ôΪʲô֮ǰ�����˴��� �ѵ�������Ϊ��Grails 2.4.2 ���¿������˸�Ŀ¼�� ����Grails ���ڵ�·����û�пո��ԭ�򣿿������������Ϣ�� ����������ԭ�򡣡�����������


. ��IDEA�У� Grails ����library �����ֵġ�