. 1. ����

     ����IDE��������Ĭ�ϵ�create-app, ���Դ������ֻ��ͨ��������.

     ����Ŀ��·��������:   grails create-plugin adamsplug

     ������һ�� adamsplug ��Ŀ¼�� ������һ��grails app.  ���ڻ������������õ���grails 3.0.3 ��groovy 2.4.4

     ���ɵ�Ŀ¼�ṹ����:

       +--- gradle\
       |
       +--- grails-app\
       |
       +--- src\
       |
       +--- build.gradle
       |
       +--- gradle.propeties
       |
       +--- gradlew
       |
       +--- gradlew.bat

     ��grails 3.0 �У� ��Ҫȷ���㴴���Ĳ���Ƿ���Ҫweb �������߲���Ƿ���ҪһЩ�����ļ�.  �������Ҫweb ������ ������"plugin" profile ����� "web-plugin" profile��  ����:

     grails create-plugin [PLUGIN NAME] --profile=plugin

     ����ȷ�ϲ�����Ʋ��ܰ��� ��д��ĸ(capital letter), ����Ͳ��ܹ����� (�������ָ��������ĸ)�� �շ�ƴд�����ã� Camel case is fine, though.

     Grails ����Ľṹ�ǳ������� Grails Ӧ����Ŀ�Ľṹ�� ���� src/main/groovy Ŀ¼�У� ��ᷢ���в���������.  �������� GrailsPlugin ��β���ࣩ

     ��� ���Ŀ���� "web" profile, �����������Բ���� ��run-app

        grails run-app

     ��� ���� û���ṩȱʡ��index.gsp, ��Ϊ�󲿷ֲ������Ҫ�� ���ԣ� �������Ҫ�����������������е������ ����Կ���һ��û�д����ҳ��.  ����㲻ϲ�����ַ�ʽ�� ���Ժ����׵ĸ���Ĳ������һ�� grails-app/views/index.gsp �����в鿴.

     ��������������ǰ��չ�Լ �� GrailsPlugin ��β�� ���б����� ������̵ĸ�Ŀ¼�����ҵ��� ����:

     class ExampleGrailsPlugin {
         ...

     }

     ���еĲ�������� src/main/groovy Ŀ¼�������������, ����Ͳ�����Ϊһ�����.  ����� �����˲����ص�metadata�� �Լ���ѡ�ı����� ����hooks into ���������ӵ�(covered shortly)

    ������ṩ������Ĳ���ĸ�����Ϣ�� ��������ض�����:

    . title ---------- һ���̾�������Ĳ��

    . grailsVersion -- ���֧�ֵ�grails �汾�� ����: "1.2 > *" (��ʾ 1.2 ����߰汾)

    . author --------- ������ߵ�����

    . authorEmail ---- ������ߵ���ϵe-mail

    . description ---- ���������Ĳ���ص�

    . documentation -- ����ĵ���URL

    . license -------- ��������

    . issueManagement -- ��������۹켣

    . scm ------------ �����Դ�������λ��

    ������һ�� Quzrtz Grails ���������:

     class QuartzGrailsPlugin {
         def grailsVersion = "1.1 > *"
         def author = "Sergey Nebolsin"
         def authorEmail = "nebolsin@gmail.com"
         def title = "Quartz Plugin"
         def description = '''\
The Quartz plugin allows your Grails application to schedule jobs\
to be executed using a specified interval or cron expression. The\
underlying system uses the Quartz Enterprise Job Scheduler configured\
via Spring, but is made simpler by the coding by convention paradigm.\
'''
         def documentation = "http://grails.org/plugin/quartz"
          ��
      }

  # �����ǣ�

    ���е�ʱ����ôҪ������ô���jar, �ǵõ�һ������ grails Ӧ�õ�ʱ��ҲҪ������ô�࣬ ��ʱ�޳�. 

    ������й����г�������ĳ��jar ͣ�Ͳ����� ���Թر�console, Ȼ������grails run-app, ��������ϴ�û�����سɹ��õط���������Ŀ��jar.

    ���������ġ�����������У� ���ڽ�������������jar ��Ĳ��Ӧ�������ˣ� Ȼ�� http://localhost:8080 ���ʣ� ��������Ĵ���:

    An error has occurred
    Exception:
    Message: No message available
    Path: /

    ʵ����������ɶ����Ҳû�У� ֻ��create-plugin ���ѡ� 

    ֱ������һ��console ���� grails stop-app ��  ֹͣӦ�á���ֹͣ�ɹ���ԭ������Ӧ�õ�console ��ص���������ʾ���� 

    ������һ��Ӧ�ú� �Ժ��������Ͳ���������ô���jar �ļ��ˣ� ֱ�ӻ���ʾ���������Ϣ��

    | Running application...
    Grails application running at http://localhost:8080 in environment: development

. ��װ���ز��

  Ҫ����Grails Ӧ����ʹ�ò�� �� ��Ҫ���а�װ����

  grails install

  �ᰲװ�������ı��� Maven cache. Ȼ�������build.gradle �ļ������������������ʹ�ò��:

     compile "org.grails.plugin:quartz:0.1"

  ** �� Grails 2.x, ����Ǵ����ZIP�ļ��ģ� �� Grails 3.x �������JAR�ļ��� ������ӵ�IDE ��classpath.

. Notes on excluded Artefacts

  ��Ȼ create-plugin ���� �����ض����ļ��� �������һ��Grails application һ�����У� ���������е��ļ����ڴ�������ʱ�򱻰�����ȥ. �����Ǵ���ʱ�У� ���Ǵ���ǲ��������ļ��б�:

   grails-app/build.gradle      (������������� dependencies.groovy)

   grails-app/conf/application.yml  (������Ϊ plugin.yml)

   grails-app/conf/spring/resources.groovy

   grails-app/conf/logback.groovy

   Everything within  /src/test/*

   SCM management files within  **/.svn/** and **/CVS/**

. ���� �������

  �����������ʱ�� ����Դ��������༰Դ�룬 ������Щ��Ӧ�������Ӧ����.

  Ϊ�˲���������Դ��, ����Ҫ�޸� build.gradle �ļ��е� pluginExcludes ����. ����: ����Щ���� com.demo ���� ���������Ĳ�� ��������, ���ǲ��������Ӧ���У� ��ô�����ڲ����������������:

   // resources that should be loaded by the plugin once installed in the applicaiton

   def pluginExcludes = [
        '**/com/demo/**'
   ]
  
   ������Ҫ��build.gradle ��Ҫ��jar �� exclude �������Щ��

   jar {
       exclude "com/demo/**/**
   }

. grails 3.0 �е��������  (inline Plugins)

  ��grails 2.x �� ������Ҫ�� BuildConfig ��ָ���������(inline plugins)�� ��grails 3.x ����Gradle's �Ķ๤�̹����ص������.

  Ҫ�����๤�̹����� ���� һ��Ӧ�úͲ���ڸ�Ŀ¼��:

  $ grails create-app myapp
  $ grails create-plugin myplugin

  Ȼ���ڸ�Ŀ¼�д���һ�� settings.gradle �ļ������ƶ����Ӧ�úͲ����λ��(location)

  include 'myapp', 'myplugin'

  ���, ��Ӧ�õ� build.gradle ����� ���� ���������

   compile project(':myplugin')

  ����������� ���ܷ���grails 2.x ���������

. ����ֿ�  Plugin Repositories

  1. �� Grails ���Ĳ���ֿⷢ�� ���

    ������ ��Ĳ���Ϳ�����list-plugins �����б�����

    grails list-plugins

    ��Ĳ��Ҳ����ͨ�� plugin-info �������鿴�Ƿ�available

    grails plugin-info [plugin-name]

    ��ӡ������Ķ�����Ϣ�� ���� ������ ���ߵȵ�.

. �ṩ������Artefacts(�˹���Ʒ)

  1. �������������

    

   