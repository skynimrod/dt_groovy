. ��װGrails �Ĳ��

  ��Ҫע����ǣ� Ӧ����Ӧ�����ڵ�Ŀ¼���氲װ��Ӧ�Ĳ����

  ��Grails 2.3 ��ʼ��  ��ͬͨ�� ����������װ����ˣ� ������grails-app/conf/BuildConfig.groovy �ļ������������

  ���磺

  Example:
grails.project.dependency.resolution = {
   ...
   plugins {
      compile ":easyui:1.7"
   }
}

. 1. ��װ easyUI ���

     grails-app/conf/BuildConfig.groovy �ļ������������

     ���磺

     Example:
     grails.project.dependency.resolution = {
           ...
           plugins {
              compile ":easyui:1.7"
           }
     }


     �����ڿ������������ʱ�� ���Զ����ض�Ӧ�Ĳ���� �����Ϣ����:

     |Downloading: org/grails/plugins/easyui/1.7/easyui-1.7.pom
     |Downloading: org/grails/plugins/scaffolding/2.0.3/scaffolding-2.0.3.pom
     |Downloading: org/grails/plugins/resources/1.2.1/resources-1.2.1.pom
     |Downloading: org/grails/plugins/resources/1.2.1/resources-1.2.1.zip
     |Downloading: org/grails/plugins/easyui/1.7/easyui-1.7.zip

     �������г����ʱ�� ��������Ĵ���

      ע: E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\easyui-1.7\src\java\org\grails\plugins\easyui\EasyuiDomainClassMarshaller.javaʹ�û򸲸����ѹ�ʱ�� API��
ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:deprecation ���±��롣
  [groovyc] org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
  [groovyc] E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\resources-1.2.1\src\groovy\org\grails\plugin\resource\ResourceProcessor.groovy: 6: unable to resolve class org.codehaus.groovy.grails.plugins.PluginManagerHolder
  [groovyc]  @ line 6, column 1.
  [groovyc]    import org.codehaus.groovy.grails.plugins.PluginManagerHolder
  [groovyc]    ^
  [groovyc] 
  [groovyc] E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\resources-1.2.1\src\groovy\org\grails\plugin\resource\util\HalfBakedLegacyLinkGenerator.groovy: 3: unable to resolve class org.codehaus.groovy.grails.commons.ConfigurationHolder
  [groovyc]  @ line 3, column 1.
  [groovyc]    import org.codehaus.groovy.grails.commons.ConfigurationHolder
  [groovyc]    ^
  [groovyc] 
  [groovyc] 2 errors
.Error 
|
Compilation error: startup failed:
E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\resources-1.2.1\src\groovy\org\grails\plugin\resource\ResourceProcessor.groovy: 6: unable to resolve class org.codehaus.groovy.grails.plugins.PluginManagerHolder
 @ line 6, column 1.
   import org.codehaus.groovy.grails.plugins.PluginManagerHolder
   ^

E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\resources-1.2.1\src\groovy\org\grails\plugin\resource\util\HalfBakedLegacyLinkGenerator.groovy: 3: unable to resolve class org.codehaus.groovy.grails.commons.ConfigurationHolder
 @ line 3, column 1.
   import org.codehaus.groovy.grails.commons.ConfigurationHolder
   ^

2 errors

  ==================

   ִ��grails dependency-report ��������֤jar�ĸ������

   ����ԭ������  +--- org.grails:grails-resources:2.4.2

   ��� ��װ easyui ��ʱ�� ������� org.grails.plugins:resources:1.2.1   

2. ʹ�ò��

   ʹ�÷������Բο� �ٷ��ĵ��� ��� ���ֵ�ʹ���ĵ��� ���磺

   http://www.grails.org/plugin/easyui

   ������ĵ����г���easyui ʹ�õķ����Լ�����ʾ����