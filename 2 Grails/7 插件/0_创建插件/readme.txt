. 1. 创建

     由于IDE环境中是默认的create-app, 所以创建插件只能通过命令行.

     进入目标路径后运行:   grails create-plugin adamsplug

     会生成一个 adamsplug 子目录， 类似于一个grails app.  由于环境变量中设置的是grails 3.0.3 和groovy 2.4.4

     生成的目录结构如下:

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

     在grails 3.0 中， 需要确认你创建的插件是否需要web 环境或者插件是否需要一些配置文件.  如果不需要web 环境， 可以用"plugin" profile 来替代 "web-plugin" profile。  如下:

     grails create-plugin [PLUGIN NAME] --profile=plugin

     必须确认插件名称不能包含 大写字母(capital letter), 否则就不能工作。 (这儿可能指的是首字母)， 驼峰拼写法可用， Camel case is fine, though.

     Grails 插件的结构非常类似于 Grails 应用项目的结构， 除了 src/main/groovy 目录中， 你会发现有产检描述类.  （名称以 GrailsPlugin 结尾的类）

     如果 插件目标是 "web" profile, 可以立即测试插件， 用run-app

        grails run-app

     插件 工程 没有提供缺省的index.gsp, 因为大部分插件不需要。 所以， 如果你需要看插件在浏览器中运行的情况， 你可以看到一个没有错误的页面.  如果你不喜欢这种方式， 可以很容易的给你的插件创建一个 grails-app/views/index.gsp 来进行查看.

     插件描述的名称是按照规约 以 GrailsPlugin 结尾， 按切必须在 插件工程的根目录中能找到。 例如:

     class ExampleGrailsPlugin {
         ...

     }

     所有的插件必须在 src/main/groovy 目录中有这个描述类, 否则就不能作为一个插件.  插件类 定义了插件相关的metadata， 以及可选的变量， 可以hooks into 到插件的外接点(covered shortly)

    你可以提供关于你的插件的附加信息， 用下面的特定属性:

    . title ---------- 一条短句描述你的插件

    . grailsVersion -- 插件支持的grails 版本， 例如: "1.2 > *" (表示 1.2 或更高版本)

    . author --------- 插件作者的名字

    . authorEmail ---- 插件作者的联系e-mail

    . description ---- 多行描述的插件特点

    . documentation -- 插件文档的URL

    . license -------- 插件的许可

    . issueManagement -- 插件的讨论轨迹

    . scm ------------ 插件的源代码管理位置

    下面是一个 Quzrtz Grails 插件的例子:

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
          …
      }

  # 问题是：

    运行的时候怎么要下载那么多的jar, 记得第一次运行 grails 应用的时候也要下载这么多， 耗时巨长. 

    如果运行过程中出现下载某个jar 停滞不动， 可以关闭console, 然后重新grails run-app, 会继续从上次没有下载成功得地方继续下载目标jar.

    经过漫长的、多次重新运行， 终于将下载了无数的jar 后的插件应用启动了， 然后 http://localhost:8080 访问， 出现下面的错误:

    An error has occurred
    Exception:
    Message: No message available
    Path: /

    实际上这个插件啥内容也没有， 只是create-plugin 而已。 

    直接在另一个console 里面 grails stop-app ，  停止应用。（停止成功后，原来启动应用的console 会回到命令行提示符） 

    启动过一次应用后， 以后再启动就不用下载那么多的jar 文件了， 直接会显示启动后的信息：

    | Running application...
    Grails application running at http://localhost:8080 in environment: development

. 安装本地插件

  要想在Grails 应用中使用插件 ， 需要运行安装命令

  grails install

  会安装插件到你的本地 Maven cache. 然后可以在build.gradle 文件中增加下面的描述来使用插件:

     compile "org.grails.plugin:quartz:0.1"

  ** 在 Grails 2.x, 插件是打包成ZIP文件的， 在 Grails 3.x ，插件是JAR文件， 可以添加到IDE 的classpath.

. Notes on excluded Artefacts

  虽然 create-plugin 命令 创建特定的文件， 插件能像一个Grails application 一样运行， 但不是所有的文件会在打包插件的时候被包含进去. 下面是创建时有， 但是打包是不包含的文件列表:

   grails-app/build.gradle      (这个是用来产生 dependencies.groovy)

   grails-app/conf/application.yml  (重命名为 plugin.yml)

   grails-app/conf/spring/resources.groovy

   grails-app/conf/logback.groovy

   Everything within  /src/test/*

   SCM management files within  **/.svn/** and **/CVS/**

. 定制 插件内容

  当开发插件的时候， 你可以创建测试类及源码， 但是这些不应该输出到应用中.

  为了不包含测试源码, 你需要修改 build.gradle 文件中的 pluginExcludes 属性. 例如: 你有些类在 com.demo 包， 这个包在你的插件 代码树中, 但是不被打包到应用中， 那么可以在插件描述中如下设置:

   // resources that should be loaded by the plugin once installed in the applicaiton

   def pluginExcludes = [
        '**/com/demo/**'
   ]
  
   并且需要在build.gradle 需要在jar 中 exclude 上面的那些类

   jar {
       exclude "com/demo/**/**
   }

. grails 3.0 中的内联插件  (inline Plugins)

  在grails 2.x ， 可能需要在 BuildConfig 中指定内联插件(inline plugins)， 在grails 3.x ，被Gradle's 的多工程构建特点替代了.

  要建立多工程构建来 创建 一个应用和插件在父目录中:

  $ grails create-app myapp
  $ grails create-plugin myplugin

  然后在父目录中创建一个 settings.gradle 文件，来制定你的应用和插件的位置(location)

  include 'myapp', 'myplugin'

  最后, 在应用的 build.gradle 中添加 依赖 插件的设置

   compile project(':myplugin')

  用这个技术， 你能访问grails 2.x 的内联插件

. 插件仓库  Plugin Repositories

  1. 在 Grails 中心插件仓库发布 插件

    这样， 你的插件就可以在list-plugins 命令中被看到

    grails list-plugins

    你的插件也可以通过 plugin-info 命令来查看是否available

    grails plugin-info [plugin-name]

    打印出插件的额外信息， 例如 描述， 作者等等.

. 提供基本的Artefacts(人工制品)

  1. 添加命令行命令

    

   