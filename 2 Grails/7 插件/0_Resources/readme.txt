. 参见:

      http://grails-plugins.github.io/grails-resources/

.快速上手过程

   1. 确认 JQuery 插件已经安装

     grails install-plugin jquery*

   2. 安装Jquery UI 和  Blueprint 插件

     grails install-plugin jquery-ui
     grails install-plugin blueprint

  3. 显示已安装的插件
  
     从Grails 开始， 安装插件不能通过命令行了， 所以查看已经安装的插件可以查看 BuildConfig.groovy 文件内容来获知。

     所以上面的1，2 步骤也就错了。

     安装插件举例:


     Example:
     grails.project.dependency.resolution = {
          ...
          plugins {
               compile ":jquery:1.11.1"
          }
     }

. 参见:

  http://grails-plugins.github.io/grails-resources/

.  这个插件提供了Grails 的资源框架， Resources 框架处理以下内容:

  1. Web 应用 性能调整困难 (Web application performance tuning is difficult)

  2. 矫正 资源的载入顺序， 特别是那些依赖于其他资源的( Correct load order for resources that depend on others)

  3. 延迟包含JavaScript 脚本直到文件结尾(Deferring inclusion of JavaScript to the end of the document)

  4. Gails插件暴露静态资源的一种标准方式的需要(The need for standard way to for Grails plugins to expose static resources)

  5. 优化资源的扩展处理机制的需要( The need for an extensible processing chain to optimize resources)

  6. 防止多次包含同样的资源( Preventing inclusion of the same resource multiple times)

  7. 开发和产品化阶段 定义行为的需要(The need for identical behaviour in development and production)

  Resources 插件能达成这些目标， 主要是通过新的工件，以及通过服务器端的本地文件系统进行资源处理.

  