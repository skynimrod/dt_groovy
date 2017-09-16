�μ�

   http://justjavac.iteye.com/blog/705556

. ָ�����λ�� (Specifying Plugin Locations)

  һ��Ӧ���ܴ��ļ�ϵͳ���κεط��������� ��ʹ ���û�б���װ�� ������ Ӧ�õ� grails-app/conf/BuildConfig.groovy �ļ���ָ��û�а�װ�Ĳ��λ�ã� ����:

   // Useful to test plugins you are develoging.
   grails.plugin.location.shiro = "/home/dilbert/dev/plugins/grails-shiro"

   // Useful for modular applications where all plugins and applications are in the same directory.
   grails.plugin.location.'grails-ui' = "../grails-grails-ui"

   ������(case)����·ǳ�����:

      1. ����һ������� ����Ҫ��һ����ʵ��Ӧ�ò������� ����û�д���Ͱ�װ��.

      2. ��һ��Ӧ�ò��Ϊһϵ�в����һ��Ӧ��, ȫ����ͬһ�� "super-project" Ŀ¼��.

  ���� grails �Ĳ�Ʒ�ֿ�(artifactory repository) ���������ѷ��������������ϵ.  ���������Щ��������ϵ���������, �б�Ҫ���ڶ������������ ��Ϊ��Щ������ϵ���ܲ��ٲֿ���.  ��ˣ� �����Ҫ����������ϵ�������������Ҫ�� BuildConfig.groovy������ legacyResolve Ϊtrue .

. ����ֿ� (Plugin Repositories) 

 1. �� Grails ���Ĳ���ֿⷢ�� ���

    ������ ��Ĳ���Ϳ�����list-plugins �����б�����

    grails list-plugins

    ��Ĳ��Ҳ����ͨ�� plugin-info �������鿴�Ƿ�available

    grails plugin-info [plugin-name]

    ��ӡ������Ķ�����Ϣ�� ���� ������ ���ߵȵ�.

    * ���

=======================

. ��2.4.2 �汾������������ٶȷǳ��죬1��ʹ����ɹ��ˡ� ������ɺ��Ŀ¼�ṹ����:


       +--- \grails-app\
       |
       +--- \lib\
       |
       +--- \scripts\
       |
       +--- \src\
       |
       +--- \test\
       |
       +--- \web-app\
       |
       +--- .classpath
       |
       +--- .project
       |
       +--- applicatio.properties
       |
       +--- Tplug242GrailsPlugin.groovy

. Ȼ�����в��

  grails run-app

  ���ʱ��ʼ��3.0.3 �������ʱ��ʹ��ȴ��� ����������jar.  ����������һ���Ƕ㲻��ȥ�ġ�

  ��������Ĵ���:

  | Packaging Grails application.....
  | Error No default container found. Please install a container plugin such as 'tomcat' first.

  ��2.4.2 �У���֧�� --profile ������ ����ָ���Ƿ���web �����

  ��/grails-app/conf/BuildConfig.groovy ������tomcat �������:

  plugins {
        
	...
	build ":tomcat:8.0.22"
    
        ...
  }

  Ȼ��������  grails run-app, ���Զ�����tomcat 8.0.22 �����ص�jar

| Downloading: org/apache/tomcat/embed/tomcat-embed-el/8.0.22/tomcat-embed-el-8.
| Downloading: org/apache/tomcat/embed/tomcat-embed-jasper/8.0.22/tomcat-embed-j
| Downloading: org/apache/tomcat/embed/tomcat-embed-logging-log4j/8.0.22/tomcat-
| Downloading: org/apache/tomcat/embed/tomcat-embed-logging-juli/8.0.22/tomcat-e
| Downloading: org/apache/tomcat/embed/tomcat-embed-websocket/8.0.22/tomcat-embe
| Downloading: org/apache/tomcat/embed/tomcat-embed-core/8.0.22/tomcat-embed-cor
| Downloading: javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.pom
| Downloading: org/apache/tomcat/embed/tomcat-embed-logging-juli/8.0.22/tomcat-e
| Downloading: org/apache/tomcat/embed/tomcat-embed-logging-log4j/8.0.22/tomcat-
| Downloading: org/apache/tomcat/embed/tomcat-embed-websocket/8.0.22/tomcat-embe
| Downloading: org/apache/tomcat/embed/tomcat-embed-jasper/8.0.22/tomcat-embed-j
| Downloading: org/apache/tomcat/embed/tomcat-embed-el/8.0.22/tomcat-embed-el-8.
| Downloading: org/apache/tomcat/embed/tomcat-embed-core/8.0.22/tomcat-embed-cor
| Downloading: javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar
| Downloading: javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar
| Compiling 10 source files

 ...

 Ȼ����ʾ���гɹ�:

  | Server running. Browse to http://localhost:8080/tplug242

 �������ֶ��� /grails-app/views/index.gsp, ��������:

  <html>
	<head>
	</head>
	<body>
		<p>hello world</p>
	</body>
  </html>

  ��������������� http://localhost:8080/tplug242�� ��ʾ�ľ���hello world.

  ���û�����index.gsp,  ����ʾ:

HTTP Status 404 - "/WEB-INF/grails-app/views/index.gsp" not found.

type Status report

message "/WEB-INF/grails-app/views/index.gsp" not found.

description The requested resource is not available.

Apache Tomcat/8.0.22

. ���� ���������(Ҳ���ǲ������ɲ�Ʒ������)

  ����ͨ����pluginExcludes �������������� ָ�� ��Щ���ݲ��������Ʒ��(exclude).  ���⣬ ����2�ַ��������� ���ZIP �� JAR �ļ������ݡ�

  1. ΪCreatePluginArchiveStart�¼�  ����һ��event handler�� ���ʱ�������еĲ���ļ�������staging Ŀ¼��ʱ�򴥷��� ͨ������¼������ ���Ը�����Ҫ������ɾ�ġ�    ��� ����� _Events.groovy ��scripts Ŀ¼�£�

     eventCreatePluginArchiveStart = { stagingDir ->
          // update staging directory contents here
     }

  ���ܶ��� staging directory ��λ�ã� ͨ��grails.project.plugin.staging.dir ���Խ��ж��� ( BuildConfig.groovy)

   ע�⣬ ����һ�� CreatePluginArchiveEnd �¼��� ZIP�� JAR����󴥷�.

  2. ������������� BuildConfig.groovy �е�����grails.plugin.resources �ıհ�.  ������� ������  grails.war.resources ����. ����:

    grails.plugin.resources = { stagingDir ->
        // update staging directory contents here
    }   

. ָ�����λ�� (Specifying Plugin Locations )

  ������û�а�װ�� Ӧ��Ҳ������������ ͨ���ļ�ϵͳ�� �� grails-app/conf/BuildConfig.groovy �ļ���ָ�������λ��(û�д����)��

  //Useful to test plugins you are developing.
  grails.plugin.location.shiro = "/home/dilbert/dev/plugins/grails-shiro"

  // Useful for modular applications where all plugins and applications are in the same directory.
  grails.plugin.location.'grails-ui' = "../grails-grails-ui"

  ���������������·ǳ�����:

  1. ���ڿ���һ�����������Ҫ��һ����ʵ��Ӧ���н��в��ԣ� ��û�жԸò�����д���Ͱ�װ��

  2. ��һ��Ӧ�ò��Ϊһϵ�еĲ������ ��һ��Ӧ�ã� ȫ����ͬһ��"super-project"Ŀ¼��.

  ** ���Ҫ���Լ�������Grails �����ӵ� �ֿ����ģ� ��Ҫ ����˺ţ� �����������ʱ������ˡ�

  ������ Grails ����ֿ��ʱ�� ��Ҫ ��װ Release Plugin , ͨ���� grails-app/conf/BuildConfig.groovy �ļ�����һ��'build' ��Χ��ʵ��:

     grails.project.dependency.resolution = {
         ...
         plugins {
              build ':release:3.0.0'
         }
     }

    �������ֿ����Ĳ���� publish-plugin :

      grails publish-plugin

   ����ɹ��Ļ��� �� http://grails.org/plugin/<pluginName> �Ͼͻ���������. 

. ��Grails ���Ĳ���ֿⷢ�����

  grails.project.dependency.resolution = {
      ...
      plugins {
          build ':release:3.0.0'
      }
  }

  ==========

  grails publish-plugin
   

.  ���ø��ӵĲֿ�

  ��ͬ��grails �汾�д������òֿ� Ҳ��ͬ.  Grails 1.3 �Ժ�, ��Ivy  ����������������ϵ.   ���ƾ��Ƕ��帽�ӵĲ���ֿ�.  ����μ�(5.7�ڵ��ĵ�)�� ���磬 ����԰��������﷨�� ��grails-app/conf/BuildConfig.groovy�������Grails �����Զ��Maven �ֿ�:

   repositories {
       mavenRepo "http://repository.codehaus.org"

       // ... or with a name
       mavenRepo name: "myRepo"
                 root: "http://myserver:8081/artifactory/plugins-snapshots-local"
   }

   ��Ҳ���Զ���һ������SVN��Grails �ֿ� ���� grailsRepo ����:

   repositories {
       grailsRepo "http://myserver/mygrailsrepo"

       //.. or with a name
       grailsRepo "http://myserver/svn/grails-plugins", "mySvnRepo"
   }  

   �����ǽ��� Grails ���Ĳֿ�Ŀ�ݷ�ʽ:

   repositories {
       grailsCentral()
   }

   Ϊ�˼����ϰ汾�� �������´���:
   repositories {
       grailsRepo "http://myserver/mygrailsrepo"
       grailsCentral()
   }

   ����Maven ���ݵĲֿ�

   ��.

. ������Ľṹ

  �����grails Ӧ�û���һ�������в�ͬ�����磬 ���������Ŀ¼�ṹ:

  + grails-app
     + controllers
     + domain
     + taglib
     etc.
 + lib
 + src
     + java
     + groovy
 + web-app
     + js
     + css

 ��һ�������װ��grails-app Ŀ¼���� ���� plugin/example-1.0/grails-appĿ¼��.  ���´����Ӧ����Ŀ¼��. һ�������Զ�����Ԥ���̵���Ŀ¼��(never interferes with a project's primary source tree)

 ����̬��Դ����΢��ͬ�� ������һ������� ����һ��Ӧ��һ��, ���еľ�̬��Դ��web-app Ŀ¼��. ���������Ӧ����һ��������Щ��̬��Դ�� ���������������һ��JavaScript ����:

   <g:resource dir="js" file="mycode.js" />


   *********************
   �����ڿ���ģʽ�����в��,  ����/js/mycode.js . ��Ȼ�� ����ǰ�װ��Ӧ���еģ� ����·��Ӧ���� 
       /plugin/example-0.1/js/mycode.js
   grails ��������ȷ����Դ����ȷ��λ��.
   ***********************

   ��һ�������pluginContextPath ����,  �ڿ�������Ͳ����װ��ͬʱʹ��,  ��ȷ�������·���Ƿ���ȷ.

   ���е�ʱ�� pluginContextPath ���������ǿմ� ���� /plugins/example �� ��Ӧ���ǲ���������� ���ǰ�װ��Ӧ����. 

   ��lib�� src/java �Լ� src/groovy Ŀ¼�µ�Java��Groovy���뽫�����뵽��ǰ���̵� web-app/WEB-INF/classes ���棬���������ʱҲ����������Ҳ���������.

. �ṩ�����Ĺ���( Prividing Basic Artefacts )

  1. �����µĽű�

  �ڲ����scriptsĿ¼�¿��������µ�Gant��صĽű�:

   + MyPlugin.groovy
   + scripts     <-- additional scripts here
   + grails-app
        + controllers
        + services
        + etc.
    + lib

  2. ����µ�grails-app ����( �������� ��ǩ�⣬ ���� �ȵ�)  Adding a new grails-app artifact(controller,Tag Library, Service, etc. )

    �ڲ���� grails-app ���У� �������ͨ�������µ��й��ļ�����������(controller, Tag Library, Service, etc). ��Ҫע����ǣ� ����ǴӰ�װ��λ�����룬 �����ǿ�����Ӧ�õ���Ŀ¼��.

   + ExamplePlugin.groovy
   + scripts
   + grails-app
        + controllers  <-- additional controllers here
        + services <-- additional services here
        + etc.  <-- additional XXX here
    + lib

  3. �ṩ��ͼ�� ģ��� ��ͼ������� (Prividing views, Templates and View resolution)

    ��һ������ṩһ����������ͬʱ�� ��Ҳ�ṩ��ȱʡ��views �� ����Ⱦ(rendered). ���Ƿǳ��õ�;����ͨ�����ģ�黯Ӧ�á�

    grails ��ͼ������� ���Ȳ���Ӧ�ð�װ��view�����û�ҵ��� �᳢�Բ��Ҳ���е���ͼ.   ����ζ����������ز���ṩ����ͼ�� �� ��Ӧ�õ�grails-app/view Ŀ¼�д��� ����ж�Ӧ��GSPs.

    ����, һ�� 'amazon'����ṩ��һ�� BookController ������. ���ִ��list Action, Grails  ������ grails-app/views/book/list.gsp�� ���û�ҵ�, ����plugin ������ͬ����gsp.

    �����ͼ���˲���ṩ��ģ��, ������﷨���Ǳ�Ҫ��:

    <g:render template="fooTemplate" plugin="amazon" />

    ** ע�������plugin���ԣ� �ǰ���ģ��Ĳ��������.  ���û��ָ����Grails �ʹ�Ӧ����Ѱ����ص�ģ��.

. �ų����� (Excluded Artefacts)

  Ĭ�ϵģ� ����������ʱ�� Grails �Ĳ���������������ļ�:

    grails-app/conf/BootStrap.groovy

    grails-app/conf/BuildConfig.groovy ( ���������� dependencies.groovy)

    grails-app/conf/Config.groovy

    grails-app/conf/DataSource.groovy ( �Լ������� *DataSource.groovy )

    grails-app/conf/UrlMappings.groovy

    grails-app/conf/spring/resources.groovy

    /web-app/WEB-INF �е���������

    /web-app/plugins/** �е���������

    /test/** �е���������

    �� **/.svn/** �� **/CVS/** �е�����SCM �����ļ�( ���ù����ļ� )

  �����Ĳ����Ҫ web-app/WEB-INF Ŀ¼�е��ļ�, ������޸Ĳ����scripts/_Install.groovy Grant �ű� , ����װ��Щ������Ŀ�깤�̵�Ŀ¼��.  (�����˼�ƺ��ǿ����� Ӧ�õ�Ŀ¼���� �����ǲ����Ŀ¼����������)

  ����, ����� UrlMapping.groovy �ļ��� ��Ϊ�˷�ֹ������ͻ, ��������Խ�UrlMappings ����������������������. ���� �ĳ�
grails-app/conf/BlogUrlMappings.groovy �Ϳ��ԡ�

  ��������б�����ͨ������ pluginExcludes ������ʵ��:

  // resources that are excluded from plugin packaging
  def pluginExcludes = [
      "grails-app/views/error.gsp"
  ]

  ����ص�ǳ�����, ���� ���ڲ���ֿ��а��� demo �� test ��Դ�ģ� ���շ�����ʱ���ǲ��ܰ�demo ��test ��Դ�����ȥ��.

. ������Լ(Evaluating Conventions)

  �ڵ��Լ����鿴���ڹ�Լ�����ṩ������ʱ������ǰ���б�Ҫ�˽�һ�������������������Щ������Լ�������ϣ�ÿһ���������һ�������� GrailsApplication�ӿڵ�ʵ��������application��

  GrailsApplication �ӿ� �ṩ���ڹ�����������Щ��Լ�ķ������ұ��������й�������໥����

  ����ʵ����GrailsClass �ӿڣ� ÿ���ӿڴ���һ��Grails ��Դ�� ���� һ��controller ��һ�� tag library. ���磺 ��ȡ���� GrailsClass ʵ���� ������ô��:

  for ( grailsClass in application.allClasses) {
      println grailsClass.name
  }
   
  GrailsApplication ������"�����"���� �����޶������Ȥ�Ĺ�������(narrow the type of artefact)�� ����  �������������controllers��

  for ( controllerClass in application.controllerClasses ) {
      println controllerClass.name
  }
  
  ��̬������Լ ��˳������:

    *Classes  -- ͨ�� �ض��Ĺ������ƻ�ȡ���е���. ����: application.controllerClasses.

    get*Class -- ͨ�� �ض��Ĺ������ƻ�ȡһ����������. ����: application.getControllerClass("PersonController")

    is*Class --- ����������� �Ǹ����������͵� �򷵻�true.  ����: application.isControllerClass(PersonController)

  GrailsClass �ӿ��д����ķǳ����õķ����� ������������ʹ����Щ��Լ. ��Щ��������:

    getPropertyValue -- ��ȡ�� �ĸ������� �� ��ʼֵ.

    hasProperty ------- ����� ��ָ�������ԣ� �򷵻�true

    newInstance ------- ���������ʵ��.

    getName ----------- ������ܵĻ��� ����Ӧ����û�к�׺��Լ���ֵ��߼�����.

    getShortName ------ ����û�а�ǰ׺����Ķ����� 

    getFullName ------- ���ذ��������Ƽ���׺���ֵ�Ӧ�����ȫ��.

    getPropertyName --- ��������Ʒ���Ϊ��������

    getLogicalPropertyName -- ���applicable(Ӧ�ÿ��ԵĻ�)�� ���ز�����׺��Ӧ������߼���������

    getNaturalName ---- �����������Ƶ���Ȼ���Ե�����(����: ����lastName" ��� "Last Name")

    getPackageName ---- ���ذ�������

. ���빹���¼� (Hooking into Build Events)

. ��װ��ʱ���������  �Լ� ָ������

  Grails ��� �����ڰ�װ��ʱ���������.  ����ͨ�� �����scripts Ŀ¼�µ� _Install.groovy �ļ���ʵ�ֵ�.

  _Install.groovy ���� �������װ��ɺ�ִ�е�. 

  ����ű���һ��Gant �ű�, (Gant����ʹ��Groovy�� Apache Ant �����˼򵥵İ�װ��) �������Gant ������ǿ��Ĺ���. pluginBasedir ���������ӵ���׼��Gant ��������, ָ�� �����װ�ĸ�Ŀ¼.
  ������һ��_Install.groovy �ű������ӣ� ��grails-app Ŀ¼�д�����һ����Ŀ¼, ���Ұ�װ��һ������ģ��


     ant.mkdir(dir: "${basedir}/grails-app/jobs")

     ant.copy(file: "${pluginBasedir}/src/samples/SamplePluginConfig.groovy",
              todir: "${basedir}/grails-app/conf")


    
  pluginBasedir ���� ��������ƵĽű�������Ч��, �����������fooPluginDir�� foo ����Ĳ������. 

. �ű��¼�

  ���� hook into �����нű��¼�. ��Щ�¼��� ִ�� Grails Ŀ��Ͳ�� �ű���ʱ����Ա�����.

  ����, ����hook into  ����״̬���( ����, "Tests passed", "Server running"�ȵ���Ϣ) �Լ� �����ļ��Ĵ���.  

  һ�����ֻ���ṩһ�� _Events.groovy �ű������� �����ص��¼�. �μ� Hooking into Events ������ĵ�.

. Hooking into ����ʱ����

  Grails �ṩ�˴����Ĺ���(hooks) ��  ����(leverage) ϵͳ������ ���ݹ�Լ ִ������ʱ����.

. Hooking into Grails Spring configuration  ���� Grails Spring ����

  ���ȣ� ͨ���ṩһ�� doWithSpring ����������(Hook into) Grails ����ʱ����,  doWithSpring ������һ�������. ���磬 ����Ĵ���Ƭ�����ṩ i18n ֧�ֵ�Grails ������� ������һ����.
 
  //##########3
  
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.context.support.ReloadableResourceBundleMessageSource

class I18nGrailsPlugin {

    def version = "0.1"

    def doWithSpring = {
        messageSource(ReloadableResourceBundleMessageSource) {
            basename = "WEB-INF/grails-app/i18n/messages"
        }
        localeChangeInterceptor(LocaleChangeInterceptor) {
            paramName = "lang"
        }
        localeResolver(CookieLocaleResolver)
    }
}
  // ############


  ������������Grails messageSource bean , ����һ��beans �������ػ��������(resolution) �Ϳ���(switching). ���õ��� Spring Bean Builder �﷨.

. ���� web.xml ������  (Participating in web.xml Genenration)

  Grails �����ʱ������ WEB-INF/web.xml�ļ��� ��Ȼ�������ֱ�Ӹ�������ļ�,  ���ǿ��Բ�������ļ�������. ��������ṩһ�� doWithWebDescription ���ԣ� ��ֵΪһ�δ����(�հ�)�� ��web.xml ����հ����д��� ���������� XmlSlurper GPathResult.

 1. ��� servlet �� servlet-mapping

 �������� ControllersPlugin �е�����:

def doWithWebDescriptor = { webXml ->

    def mappingElement = webXml.'servlet-mapping'

    def lastMapping = mappingElement[mappingElement.size() - 1]
    lastMapping + {
        'servlet-mapping' {
            'servlet-name'("grails")
            'url-pattern'("*.dispatch")
        }
    }
}  

  ��������ȡ����һ��<servlet-mapping> Ԫ�ص����ã� ����, ������ XmlSluprer �����������޸�XML �ƺ��ñհ��� ���Grails �� servlet ��

 2. ��� filter �� filter-mapping

   ��� filter ������ӳ���ϵ�������������һ�����ͬ��<filter>Ԫ��λ�ò��������⣬ ��Ϊ˳����Ҫ�����Էǳ��򵥵Ĳ����㶨�Ƶ�filter ��������һ��<context-parm>Ԫ�ؼ��ɡ�  ��Ҫ����ӳ���˳�� ͨ���������� ��<filter>Ԫ��֮��������ӳ��:
def doWithWebDescriptor = { webXml ->

    def contextParam = webXml.'context-param'

    contextParam[contextParam.size() - 1] + {
        'filter' {
            'filter-name'('springSecurityFilterChain')
            'filter-class'(DelegatingFilterProxy.name)
        }
    }

    def filter = webXml.'filter'
    filter[filter.size() - 1] + {
        'filter-mapping'{
            'filter-name'('springSecurityFilterChain')
            'url-pattern'('/*')
        }
    }
}
   
  
  ��Щ����� ����Ҫȷ�����filter ��һ����׼��Grails filters ���棬 ���� Spring character encoding filter ���� SiteMesh filter��   �õ��ǣ�������ڱ�׼��filter (����ȷ��˵���ǣ� ָ��Щ��web.xml�ļ��й�����)����ֱ�Ӳ���filter mappings. 


def doWithWebDescriptor = { webXml ->
    ...

    // Insert the Spring Security filter after the Spring
    // character encoding filter.
    def filter = webXml.'filter-mapping'.find {
        it.'filter-name'.text() == "charEncodingFilter"
    }

    filter + {
        'filter-mapping'{
            'filter-name'('springSecurityFilterChain')
            'url-pattern'('/*')
        }
    }
}
  

. ��ʼ����ɺ��������

  ��ʱ����Ҫ�� Spring ApplicationContext ������ɺ�����������á� �����������Զ���doWithApplicationContext �հ�����:

class SimplePlugin {

    def name = "simple"
    def version = "1.1"

    def doWithApplicationContext = { appCtx ->
        def sessionFactory = appCtx.sessionFactory
        // do something here with session factory
    }
}

. ����ʱ��Ӷ�̬����

  1. ����֪ʶ

     Grails ������������е�ʱ�� ע�� Grails ��Ͻ���������� ��̬��������doWithDynamicMethods �հ���ʵ��.

    ���� Grails ��Ͻ�࣬ ���� controllers, tag libraries �ȣ� ��ֵ������ӷ�����, ���������ȵȡ� ͨ������ÿ��controller�� MetaClass ��ʹ�� ExpandoMetaClass ���ơ�

class ExamplePlugin {
    def doWithDynamicMethods = { applicationContext ->
        for (controllerClass in application.controllerClasses) {
             controllerClass.metaClass.myNewMethod = {-> println "hello world" }
        }
    }
}   

   ��������������� ��������(implicit) application�������ȡ ���� controller �� �� MetaClass ʵ��������. ��ÿ��controller �����һ���·���myNewMethod��  ������Ѿ�֪����Ҫ��ӷ������࣬ ֻ��Ҫ�򵥵ĸ����metaClass��������ӷ������ɡ�������һ�����ӡ� 

   ����������Ǹ� java.lang.String ���һ���·��� swapCase:

class ExamplePlugin {

    def doWithDynamicMethods = { applicationContext ->
        String.metaClass.swapCase = {->                      // ע����� ֻ�õ���String�࣬����˷��� swapCase
             def sb = new StringBuilder()
             delegate.each {
                 sb << (Character.isUpperCase(it as char) ?
                        Character.toLowerCase(it as char) :
                        Character.toUpperCase(it as char))
             }
             sb.toString()
        }

        assert "UpAndDown" == "uPaNDdOWN".swapCase()
    }
}

. �� ApplicationContext ���н���

  doWithDynamicMethods �հ����Ի��Spring ApplicationContext ʵ���� ��ͷǳ������ˣ� �������ApplicationContextʵ������Ķ�����н���. ���磬 �������ʵ��һ��������Hibernate ���н������������HibernateTemplateһͬʹ�� SessionFactory ʵ���� ����:

  
import org.springframework.orm.hibernate3.HibernateTemplate

class ExampleHibernatePlugin {

   def doWithDynamicMethods = { applicationContext ->

       for (domainClass in application.domainClasses) {

           domainClass.metaClass.static.load = { Long id->
                def sf = applicationContext.sessionFactory
                def template = new HibernateTemplate(sf)
                template.load(delegate, id)
           }
       }
   }
}

  ��ΪSpring ���� ���Զ�װ��(autowiring)������ע��(dependency injection)����, �����������ʱ��ʵ�ָ�ǿ��Ķ�̬ constructors,  ��� constructors �� Ӧ��������(application context)��װ����Ķ���������ϵ.

class MyConstructorPlugin {

    def doWithDynamicMethods = { applicationContext ->
         for (domainClass in application.domainClasses) {
              domainClass.metaClass.constructor = {->
                  return applicationContext.getBean(domainClass.name)
              }
         }
    }
}

. �����Զ������¼�( Participating in Auto Reload Events) 

. �����Դ�ĸı�( Monitoring Resources for Changes )

  ͨ�������� ����Դ�����ı��ʱ�� ��ز������¼�����Щ�仯�Ƿǳ��������.  ��Ҳ��Grails ΪʲôҪ������ʱʵ�ָ��ӵ�Ӧ�ó������¼���. �鿴����Grails ��ServicesPlugin ��һ�μ򵥵Ĵ���Ƭ��:

class ServicesGrailsPlugin {
    ��
    def watchedResources = "file:./grails-app/services/*Service.groovy"

    ��
    def onChange = { event ->
        if (event.source) {
            def serviceClass = application.addServiceClass(event.source)
            def serviceName = "${serviceClass.propertyName}"
            def beans = beans {
                "$serviceName"(serviceClass.getClazz()) { bean ->
                    bean.autowire =  true
                }
            }
            if (event.ctx) {
                event.ctx.registerBeanDefinition(
                        serviceName,
                        beans.getBeanDefinition(serviceName))
            }
        }
    }
}

  ���ȣ� ������watchedResources, �п�����String ���� String �� List,   ������Ҫ��ص���Դ������(reference) ����ģʽ(Pattern). ���Ҫ��ص���Դ��Groovy �ļ��� �������ı��ʱ�򣬾ͻ��Զ����������룬���Ҵ��ݸ� onChange �հ���event���������

  event ��������������õ�����:

    event.source ---- �¼�Դ, ����������������� ���� Spring ��Դ

    event.ctx ------- Spring ApplicationContext ʵ��

    event.plugin ---- ������Դ�Ĳ������(ͨ����this)

    event.application -- GrailsApplication ʵ��

    event.manager --- GrailsPluginManager ʵ��

  ͨ����Щ���� ����Ը��ݷ����ĸı�����Ӧ��Ӧ�ĶԲߡ� ��������"Services"ʾ����, ��һ��service��仯ʱ, һ���µ�service�౻����ע�ᵽApplicationContext�С� 

. Ӱ�������Ĳ��  ( Influencing Other Plugins )

  ����Ӧ�Ա仯�� ��ʱ��������Ҫ Ӱ�������Ĳ��.

  ���� Services �� Controllers ����� ��һ�� service ���¼��غ� ������Ҳ���¼���controllers, ��������ͼ����װ��service ���ɵ�controller ���ʱ��ͻᷢ�����⡣

  Ϊ�˱��������������, ����ָ����Щ�ܵ�Ӱ��Ĳ���� ������ ��һ���������⵽�ı䣬 ���ͻᱻ���¼��أ� Ȼ����Ӱ�쵽�Ĳ��Ҳ�����¼���.  ���� ServicesGrailsPlugin ʵ����Щ�Ĵ���:

  def influences = ['controllers']

. �۲��������

  �������۲�һ���ض��Ĳ���ı仯�� ���ֲ���Ҫ���Ӳ������Դ, ����ʹ��"observe"����:

  def observe = ["controllers"]

  ����������У� ��һ��controller �ı��ʱ�� ����ԴӶ�Ӧ��controllers ������յ� �¼���

  Ҳ������ͨ������۲����е�����Ĳ��

  def observe = ["*"]

  Logging ��� ����������Щ�� ��ȷӦ�����й����У� ���������log���Ե��κη����ı�Ĺ�����

. ��� �������˳��

. ���Ʋ��������

  ������������������Ѿ����ڵĲ���� ���ҿ��Ե�������Щ����������� ͨ��2��������ʵ��. ��һ���� dependsOn, ����: ����Hibernate ����Ĵ���Ƭ��:

  class HibernateGrailsPlugin {

      def version = "1.0"

      def dependsOn = [dataSource: "1.0",
                      domainClass: "1.0",
                      i18n: "1.0",
                      core:"1.0"]
  }

  Hibernate ������������е�4�����: dataSource, domainClass, i18n �� core�����

  �����Ĳ��������Hibernate ������룬 ��������Ĳ��û��ȫ�����룬 ��ôHibernate ���Ҳ��������.

  dependsOn ����Ҳ֧�ּ򵥵ı��ʽ�������ƶ��汾��Χ�� ����:

  def dependsOn = [foo: "* > 1.0"]
  def dependsOn = [foo: "1.0 > 1.1"]
  def dependsOn = [foo: "1.0 > *"]
  
  ͨ���* ��ʾ�κΰ汾. ���ֱ��ʽ�﷨��֧���κκ�׺�� ���� -BETA, -ALPHA �ȵ�.  ���� ���ʽ"1.0 > 1.1" ��ƥ������ĵ����а汾:

  1.1           1.0          1.0.1    1.0.3-SNAPSHOT, 1.1-BETA2

. ��������˳��

  ���������ϵ�޷������� ���²�������������ᱻ���룬 ��˵����������ǿ����.  ���ǿ���ͨ�� loadAfter�� loadBefore ����������һ��������:

  def loadAfter = ['controllers']

  ��������У����controllers ������ڵĻ��� ��controllers �������� ����Ŀ������ ���� �������������.  ���������Ӧ�����Ѿ����ڵĲ��, ���� Hibernate ����� doWithSpring �հ���������Ĵ���:

if (manager?.hasGrailsPlugin("controllers")) {
    openSessionInViewInterceptor(OpenSessionInViewInterceptor) {
        flushMode = HibernateAccessor.FLUSH_MANUAL
        sessionFactory = sessionFactory
    }
    grailsUrlHandlerMapping.interceptors << openSessionInViewInterceptor
}

    ��� controllers ����Ѿ�������Ļ�, Hibernate �������ע�� OpenSessionInViewInterceptor . manager ������ GrailsPluginManager �ӿڵ�ʵ��, ���ṩ����������������ķ���.

    ��Ҳ������loadBefore ������ָ��һ�������������Ĳ������֮ǰ������. 

    def loadBefore = ['rabitmq']

. ��Χ�ͻ���

  ���������Կ��Ʋ��������˳�� ������ָ���������Ļ����Լ���Χ(stage of build). ֻ��Ҫ�򵥶���һ����2����������������Ĳ��������:

   def environments = ['development','test','myCustomEnv']
   def scopes = [excludes:'war']

   ����������У� ���ֻ����'development' ��'test' �Ļ�������. Ҳ��������WAR�ļ��� ��Ϊ��������'war'����. ����һЩ���ڿ����׶εĲ�����ᱻ�������Ʒ�б�ʹ�á�

  ���п��õķ�Χ��ö�� ����BuildScope �ж��壬  ����ܽ�����:

  test -  ���� tests

  functional-test --- ����functional tests

  run ---  ��Ӧ run-app �� run-war

  war ---  ���Ӧ�ó�һ��WAR�ļ�

  all --- �����Ӧ���е�scope(ȱʡ��)

 ֮ǰ��2������ֵ����������֮һ:

  a string ----- һ��sole inclusion

  a list   ----- environments �� scopes ���б�

  a map -------- ��Ӧ��ȫ���ƣ� ��'includes' ��/�� 'excludes' �ؼ���, �������ַ����� Ҳ�������б�ֵ

  ����:

  def environments = "test"

  �����������test ����

  def environments = ["development","test"]

  ���� development ��test ����.

  def environments = [includes:["development","test"]]

  ������������ͬһ������.

. ���� API

  ������Ӧ�����Grails �Ĺ���������: �����class ���ͣ���ͬ����ͨ��Groovy ��� Java �࣬ ���磬 Ϊ����ǿ���ǣ� ���˶�������Ժͷ����� �������Ӱ��� domain ��� controllers �ࡣ����ܲ�����������Grails ����Ӧ�úͲ�������߷��ʹ����ĵײ�, ����ζ��������ҵ���Щ��������ʹ�ã����Լ�ǿ������. ���������ṩ���Լ����ƵĹ�������.

. ��ѯ���õĹ���

  ��һ�������߶���, �ǳ���Ҫ��һ���ǣ��ҵ���Щdomain�࣬ controllers, �� �������͵Ĺ��� ��Ӧ�����ǿ��õġ�

  ��������

. �����Ʋ��

. ʹ�ö����Ʋ��

  dependices {

       compile "myconpany:myplugin:0.1"
  }

  

. ============ ���� ������ΰѴ����Ĳ�� ��Ӧ����ʹ�� ===============