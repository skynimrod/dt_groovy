. easyui �Ĺ���:

     http://www.jeasyui.com


    http://www.jeasyui.com/documentation/index.php      �ĵ�

. ����

  ��Grails ��ʹ��easyui, ��ʹ�� easyui ����� Ŀǰ��easyui plugin 1.7 for grails,  ���Ƕ���grails 2.4 �Ժ�İ汾��֧�֣� ��Ҫԭ���� easyui 1.7 plugin��ʹ�õ�resources-1.2.1 ��Ҫʹ�� grails �е� PluginManagerHolder, ���Ǵ�grails 2.4 �Ժ� PluginManagerHolder �ͱ������ˡ� 

  �� import grails.util.Holders ���

  ����:

   import grails.util.Holders

   if (Holders.pluginManager.hasGrailsPlugin('acegi')) {
       ...
   }

You currently already have a version of the plugin installed [Aresources-1.2.1]. Do you want to upgrade to [resources-1.2.14]? [y,n] y

�� Resources-1.2.14 �� ��Ȼ�����ȥ�ˣ� ���ǳ���������Ķ���:

   
Error |
2015-07-29 17:57:05,968 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /js/jquery-easyui/themes/icon.css

Error |
2015-07-29 17:57:06,109 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /js/jquery-easyui/themes/default/easyui.css

Error |
2015-07-29 17:57:06,218 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /js/jquery-easyui/jquery.min.js

Error |
2015-07-29 17:57:06,328 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /js/jquery-easyui/jquery.easyui.min.js

Error |
2015-07-29 17:57:06,468 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /js/jquery-easyui/locale/easyui-lang-en.js

Error |
2015-07-29 17:57:06,578 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /assets/easyui-scaffold.js

Error |
2015-07-29 17:57:06,609 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /plugins/easyui-1.7/js/locale/easyui-scaffold-lang-en.js

Error |
2015-07-29 17:57:06,703 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /assets/easyui-scaffold.css

Error |
2015-07-29 17:57:06,718 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /plugins/jquery-1.11.1/js/jquery/jquery-1.11.1.min.js

Error |
2015-07-29 17:57:06,718 [localhost-startStop-1] ERROR resource.ResourceMeta  - Resource not found: /plugins/jquery-1.11.1/js/jquery/jquery-1.11.1.js

|Server running. Browse to http://localhost:8080/Grails_OnlyController


��ʵ�����Ҳ�����Ӧ����Դ�ļ�:

�μ�:

     http://www.cnblogs.com/lijingzhi/archive/2013/01/23/2873944.html

. �����ʵ����application.  

  create-plugin  run-app  package-plugin

  �������²��������package-plugin

  grails-app/conf/BootStrap.groovy

  grails-app/conf/BuildConfig.groovy (although it is used to generate dependencies.groovy)

  grails-app/conf/Config.groovy

  grails-app/conf/DataSource.groovy (and any other *DataSource.groovy)

  grails-app/conf/UrlMappings.groovy

  grails-app/conf/spring/resources.groovy

  Everything within /web-app/WEB-INF

  Everything within /web-app/plugins/**
  
  Everything within /test/**

  SCM management files within **/.svn/** and **/CVS/**

. _Install.groovy �ű��� ÿ���������װ��,  �ͻ�ִ������ű���

. ���Ʋ������

  ��2��������

  1. ����һ���¼����   ����CreatePluginArchiveStart ʱ�� �� ����:

     eventCreatePluginArchiveStart = { stagingDir ->
          // update staging directory contents here
     }

     ������ļ�������Ŀ��Ŀ¼�к󣨻���zip, jar ��ѹ�󣩣��ͻἤ������¼������ִ�С� ͨ���������� ����Ը�����Ҫ���ӣ� �޸ģ� ɾ���ļ���

     ����ľ����ӵ� _Events.groovy �ļ��У� ��script Ŀ¼��.

  2.  ��Ҳ���Զ���Ŀ��Ŀ¼�� ͨ�� grails.project.plugin.staging.dir ���ԡ�   ��BuildConfig.groovy.  ��ͬϵͳ����. 

  ���ڵ�һ�ַ���. ������ ��BuildCOnfig.groovy ��� ���� grails.plugin.resources ��  ���ൽ grails.war.resources ����,���磺

     grails.plugin.resources = { stagingDir ->
         // update staging directory contents here
     }

. ָ�����λ��

   ������û�б���װ�� Ҳ�������롣  �� grails/conf/BuildConfig.groovy �ļ��У�

  // Useful to test plugins you are developing.
  grails.plugin.location.shiro =
        "/home/dilbert/dev/plugins/grails-shiro"
  // Useful for modular applications where all plugins and
  // applications are in the same directory.
  grails.plugin.location.'grails-ui' = "../grails-grails-ui"



. ��Main.gsp ���������������ݣ�

  <g:javascript library="easyui" />

  ��������Ĵ���

Caused by GroovyPagesException: Error processing GroovyPageView: Error executing tag <g:javascript>: No module found with name [easyui]
->>  527 | runWorker in \grails-app\views\layouts\main.gsp
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

Caused by GrailsTagException: Error executing tag <g:javascript>: No module found with name [easyui]
->>   18 | doCall    in E:/4 WorkSpace/0 Grails/Grails_OnlyController/grails-app/views/layouts/main.gsp
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

Caused by IllegalArgumentException: No module found with name [easyui]
->> 1188 | getAllModuleNamesRequired in org.grails.plugin.resource.ResourceProcessor
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
|   1221 | addModuleDispositionsToRequest in     ''
|    125 | declareModuleRequiredByPage in org.grails.plugin.resource.ResourceTagLib
|    310 | doCall    in org.grails.plugin.resource.ResourceTagLib$_closure5_closure18
|    306 | doCall .  in org.grails.plugin.resource.ResourceTagLib$_closure5
|     43 | doCall    in E__4_WorkSpace_0_Grails_Grails_OnlyController_grails_app_views_layouts_main_gsp$_run_closure1
|     50 | run . . . in E__4_WorkSpace_0_Grails_Grails_OnlyController_grails_app_views_layouts_main_gsp
|   1145 | runWorker in java.util.concurrent.ThreadPoolExecutor
|    615 | run . . . in java.util.concurrent.ThreadPoolExecutor$Worker
^    744 | run       in java.lang.Thread

. �μ���

     http://www.ibm.com/developerworks/cn/java/j-grails07219/

  ͨ���鿴�������Ŀ¼�ṹ�� �ᷢ�ֲ�� ��Ӧ�ó��� ��ͬ���Ļ������֣� ��grails-app��Ŀ¼�� ����lib��Ŀ¼�� �ȵȡ�

  ��ؼ�������grails-app ��Ŀ¼�е�controller ��Ŀ¼�� services ��Ŀ¼������Ҫ�Ķ����� ���� conf ��Ŀ¼�е����ݡ�

  ��conf��Ŀ¼�е� EasyuiPluginResources.groovy �ļ��� ��������Ĵ���Ҳ���Ǹ��ļ��ж������Դ�ļ��Ҳ�����

compile(':shiro:1.1.4'){//������仰�󣬰�װ����ʹ��ʱҲ�Ͳ�������shiro1.1.4��������quartz-1.6.2.jar  
            excludes "quartz"  
        }  

142.0.134.7/8

import org.grails.plugins.easyui.EasyuiConfig

������� ��ʾ�Ҳ���Ŀ���࣬ ʵ���ϸ����Ǵ��ڵġ� ������·�������⣬ �������ǲ����װ���Ĭ��·���� �������������⡣



        println "EasyuiConfig.theme:[" + EasyuiConfig.theme + \
            "],EasyuiConfig.locale:[" + EasyuiConfig.locale + \
            "],EasyuiConfig.jqueryVersion:[" + EasyuiConfig.jqueryVersion + "]."


��仰�������Դ�ļ�����Ҫ�� ��������� �ṩ����Ϣ�� ������ֺ�2��û�����ݡ�  ���


