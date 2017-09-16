. 安装Grails 的插件

  需要注意的是， 应该在应用所在的目录下面安装对应的插件。

  从Grails 2.3 开始，  不同通过 命令行来安装插件了， 必须在grails-app/conf/BuildConfig.groovy 文件来声明插件。

  例如：

  Example:
grails.project.dependency.resolution = {
   ...
   plugins {
      compile ":easyui:1.7"
   }
}

. 1. 安装 easyUI 插件

     grails-app/conf/BuildConfig.groovy 文件来声明插件。

     例如：

     Example:
     grails.project.dependency.resolution = {
           ...
           plugins {
              compile ":easyui:1.7"
           }
     }


     这样在开发环境编译的时候， 会自动下载对应的插件， 输出信息如下:

     |Downloading: org/grails/plugins/easyui/1.7/easyui-1.7.pom
     |Downloading: org/grails/plugins/scaffolding/2.0.3/scaffolding-2.0.3.pom
     |Downloading: org/grails/plugins/resources/1.2.1/resources-1.2.1.pom
     |Downloading: org/grails/plugins/resources/1.2.1/resources-1.2.1.zip
     |Downloading: org/grails/plugins/easyui/1.7/easyui-1.7.zip

     编译运行程序的时候， 出现下面的错误

      注: E:\4 WorkSpace\0 Grails\Grails_OnlyController\target\work\plugins\easyui-1.7\src\java\org\grails\plugins\easyui\EasyuiDomainClassMarshaller.java使用或覆盖了已过时的 API。
注: 有关详细信息, 请使用 -Xlint:deprecation 重新编译。
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

   执行grails dependency-report 命令来验证jar的更新情况

   发现原来就有  +--- org.grails:grails-resources:2.4.2

   结果 安装 easyui 的时候， 有添加了 org.grails.plugins:resources:1.2.1   

2. 使用插件

   使用方法可以参考 官方文档中 插件 部分的使用文档， 例如：

   http://www.grails.org/plugin/easyui

   上面的文档就列出了easyui 使用的方法以及代码示例。