. easyui 的官网:

     http://www.jeasyui.com


    http://www.jeasyui.com/documentation/index.php      文档

. 概述

  在Grails 中使用easyui, 是使用 easyui 插件， 目前是easyui plugin 1.7 for grails,  但是对于grails 2.4 以后的版本不支持， 主要原因是 easyui 1.7 plugin中使用的resources-1.2.1 需要使用 grails 中的 PluginManagerHolder, 但是从grails 2.4 以后， PluginManagerHolder 就被废弃了。 

  用 import grails.util.Holders 替代

  例如:

   import grails.util.Holders

   if (Holders.pluginManager.hasGrailsPlugin('acegi')) {
       ...
   }

You currently already have a version of the plugin installed [Aresources-1.2.1]. Do you want to upgrade to [resources-1.2.14]? [y,n] y

用 Resources-1.2.14 后， 虽然编译过去了， 但是出现了下面的恩替:

   
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


其实就是找不到对应的资源文件:

参见:

     http://www.cnblogs.com/lijingzhi/archive/2013/01/23/2873944.html

. 插件其实就是application.  

  create-plugin  run-app  package-plugin

  不过以下插件不能用package-plugin

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

. _Install.groovy 脚本， 每当插件被安装后,  就会执行这个脚本。

. 定制插件内容

  有2个方法。

  1. 创建一个事件句柄   处理CreatePluginArchiveStart 时间 ， 例如:

     eventCreatePluginArchiveStart = { stagingDir ->
          // update staging directory contents here
     }

     当插件文件拷贝到目标目录中后（或者zip, jar 解压后），就会激活这个事件句柄并执行。 通过这个句柄， 你可以根据需要增加， 修改， 删除文件。

     上面的句柄添加到 _Events.groovy 文件中， 在script 目录中.

  2.  你也可以定制目标目录， 通过 grails.project.plugin.staging.dir 属性。   在BuildConfig.groovy.  如同系统属性. 

  对于第一种方法. 还可以 在BuildCOnfig.groovy 添加 属性 grails.plugin.resources ，  编类到 grails.war.resources 属性,例如：

     grails.plugin.resources = { stagingDir ->
         // update staging directory contents here
     }

. 指定插件位置

   即便插件没有被安装， 也可以载入。  在 grails/conf/BuildConfig.groovy 文件中：

  // Useful to test plugins you are developing.
  grails.plugin.location.shiro =
        "/home/dilbert/dev/plugins/grails-shiro"
  // Useful for modular applications where all plugins and
  // applications are in the same directory.
  grails.plugin.location.'grails-ui' = "../grails-grails-ui"



. 在Main.gsp 中增加了如下内容：

  <g:javascript library="easyui" />

  出现下面的错误：

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

. 参见：

     http://www.ibm.com/developerworks/cn/java/j-grails07219/

  通过查看插件所在目录结构， 会发现插件 和应用程序 有同样的基础布局， 有grails-app子目录， 还有lib子目录， 等等。

  最关键的是在grails-app 子目录中的controller 子目录和 services 子目录中有需要的东西， 还有 conf 子目录中的内容。

  在conf子目录中的 EasyuiPluginResources.groovy 文件。 出现上面的错误也就是该文件中定义的资源文件找不到。

compile(':shiro:1.1.4'){//加上这句话后，安装插件和打包时也就不再引入shiro1.1.4所依赖的quartz-1.6.2.jar  
            excludes "quartz"  
        }  

142.0.134.7/8

import org.grails.plugins.easyui.EasyuiConfig

这句语言 提示找不到目标类， 实际上该类是存在的。 可能是路径有问题， 但是这是插件安装后的默认路径。 后面继续检查问题。



        println "EasyuiConfig.theme:[" + EasyuiConfig.theme + \
            "],EasyuiConfig.locale:[" + EasyuiConfig.locale + \
            "],EasyuiConfig.jqueryVersion:[" + EasyuiConfig.jqueryVersion + "]."


这句话输出了资源文件所需要的 上面的类中 提供的信息， 结果发现后2个没有内容。  奇怪


