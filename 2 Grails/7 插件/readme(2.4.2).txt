参见

   http://justjavac.iteye.com/blog/705556

. 指定插件位置 (Specifying Plugin Locations)

  一个应用能从文件系统的任何地方载入插件， 即使 插件没有被安装。 可以在 应用的 grails-app/conf/BuildConfig.groovy 文件中指定没有安装的插件位置， 如下:

   // Useful to test plugins you are develoging.
   grails.plugin.location.shiro = "/home/dilbert/dev/plugins/grails-shiro"

   // Useful for modular applications where all plugins and applications are in the same directory.
   grails.plugin.location.'grails-ui' = "../grails-grails-ui"

   在两种(case)情况下非常有用:

      1. 开发一个插件， 并且要在一个真实的应用测试它， 但是没有打包和安装它.

      2. 把一个应用拆分为一系列插件和一个应用, 全都在同一个 "super-project" 目录中.

  现在 grails 的产品仓库(artifactory repository) 包括所有已发布插件的依赖关系.  如果你用那些有依赖关系的内联插件, 有必要做第二个解决方案， 因为这些依赖关系可能不再仓库中.  因此， 如果你要用有依赖关系的内联插件，需要在 BuildConfig.groovy中设置 legacyResolve 为true .

. 插件仓库 (Plugin Repositories) 

 1. 在 Grails 中心插件仓库发布 插件

    这样， 你的插件就可以在list-plugins 命令中被看到

    grails list-plugins

    你的插件也可以通过 plugin-info 命令来查看是否available

    grails plugin-info [plugin-name]

    打印出插件的额外信息， 例如 描述， 作者等等.

    * 如果

=======================

. 在2.4.2 版本环境创建插件速度非常快，1秒就创建成功了。 创建完成后的目录结构如下:


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

. 然后运行插件

  grails run-app

  这个时候开始了3.0.3 创建插件时的痛苦等待， 下载无数的jar.  看来这早晚一刀是躲不过去的。

  出现下面的错误:

  | Packaging Grails application.....
  | Error No default container found. Please install a container plugin such as 'tomcat' first.

  在2.4.2 中，不支持 --profile 参数， 即不指定是否是web 插件。

  在/grails-app/conf/BuildConfig.groovy 中增加tomcat 插件部分:

  plugins {
        
	...
	build ":tomcat:8.0.22"
    
        ...
  }

  然后再运行  grails run-app, 会自动下载tomcat 8.0.22 插件相关的jar

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

 然后提示运行成功:

  | Server running. Browse to http://localhost:8080/tplug242

 由于我手动在 /grails-app/views/index.gsp, 内容如下:

  <html>
	<head>
	</head>
	<body>
		<p>hello world</p>
	</body>
  </html>

  所以在浏览器输入 http://localhost:8080/tplug242， 显示的就是hello world.

  如果没有这个index.gsp,  会提示:

HTTP Status 404 - "/WEB-INF/grails-app/views/index.gsp" not found.

type Status report

message "/WEB-INF/grails-app/views/index.gsp" not found.

description The requested resource is not available.

Apache Tomcat/8.0.22

. 定制 插件的内容(也就是插件打包成产品的内容)

  可以通过在pluginExcludes 描述属性设置来 指定 那些内容不打包到产品中(exclude).  另外， 还有2种方法来配置 插件ZIP 或 JAR 文件的内容。

  1. 为CreatePluginArchiveStart事件  创建一个event handler， 这个时间是所有的插件文件拷贝到staging 目录的时候触发。 通过添加事件句柄， 可以根据需要进行增删改。    添加 句柄到 _Events.groovy （scripts 目录下）

     eventCreatePluginArchiveStart = { stagingDir ->
          // update staging directory contents here
     }

  你能定制 staging directory 的位置， 通过grails.project.plugin.staging.dir 属性进行定制 ( BuildConfig.groovy)

   注意， 还有一个 CreatePluginArchiveEnd 事件， ZIP或 JAR打包后触发.

  2. 这个方法是设置 BuildConfig.groovy 中的属性grails.plugin.resources 的闭包.  这个属性 归类在  grails.war.resources 属性. 例如:

    grails.plugin.resources = { stagingDir ->
        // update staging directory contents here
    }   

. 指定插件位置 (Specifying Plugin Locations )

  即便插件没有安装， 应用也可以载入插件， 通过文件系统。 在 grails-app/conf/BuildConfig.groovy 文件中指定插件的位置(没有打包的)。

  //Useful to test plugins you are developing.
  grails.plugin.location.shiro = "/home/dilbert/dev/plugins/grails-shiro"

  // Useful for modular applications where all plugins and applications are in the same directory.
  grails.plugin.location.'grails-ui' = "../grails-grails-ui"

  在下面的两种情况下非常有用:

  1. 正在开发一个插件并且需要在一个真实的应用中进行测试， 还没有对该插件进行打包和安装。

  2. 把一个应用拆分为一系列的插件集合 和一个应用， 全都在同一个"super-project"目录中.

  ** 如果要将自己开发的Grails 插件添加到 仓库中心， 需要 相关账号， 现在外网访问被限制了。

  当访问 Grails 插件仓库的时候， 需要 安装 Release Plugin , 通过在 grails-app/conf/BuildConfig.groovy 文件定义一个'build' 范围来实现:

     grails.project.dependency.resolution = {
         ...
         plugins {
              build ':release:3.0.0'
         }
     }

    发布到仓库中心插件用 publish-plugin :

      grails publish-plugin

   如果成功的话， 在 http://grails.org/plugin/<pluginName> 上就会立即可用. 

. 在Grails 中心插件仓库发布插件

  grails.project.dependency.resolution = {
      ...
      plugins {
          build ':release:3.0.0'
      }
  }

  ==========

  grails publish-plugin
   

.  配置附加的仓库

  不同的grails 版本中处理配置仓库 也不同.  Grails 1.3 以后, 用Ivy  来处理插件的依赖关系.   机制就是定义附加的插件仓库.  具体参见(5.7节的文档)。 例如， 你可以按照下面语法， 在grails-app/conf/BuildConfig.groovy定义包含Grails 插件的远程Maven 仓库:

   repositories {
       mavenRepo "http://repository.codehaus.org"

       // ... or with a name
       mavenRepo name: "myRepo"
                 root: "http://myserver:8081/artifactory/plugins-snapshots-local"
   }

   你也可以定义一个基于SVN的Grails 仓库 ，用 grailsRepo 方法:

   repositories {
       grailsRepo "http://myserver/mygrailsrepo"

       //.. or with a name
       grailsRepo "http://myserver/svn/grails-plugins", "mySvnRepo"
   }  

   下面是建立 Grails 中心仓库的快捷方式:

   repositories {
       grailsCentral()
   }

   为了兼容老版本， 可以如下处理:
   repositories {
       grailsRepo "http://myserver/mygrailsrepo"
       grailsCentral()
   }

   发布Maven 兼容的仓库

   略.

. 理解插件的结构

  插件与grails 应用基本一样，稍有不同。例如， 看看插件的目录结构:

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

 当一个插件安装后，grails-app 目录内容 会在 plugin/example-1.0/grails-app目录里.  不会拷贝到应用主目录树. 一个插件永远不会干预工程的主目录树(never interferes with a project's primary source tree)

 处理静态资源有轻微不同。 当开发一个插件， 就像一个应用一样, 所有的静态资源在web-app 目录中. 你可以想在应用中一样链接这些静态资源。 下面的例子是链接一个JavaScript 代码:

   <g:resource dir="js" file="mycode.js" />


   *********************
   当你在开发模式下运行插件,  会找/js/mycode.js . 当然， 插件是安装到应用中的， 所以路径应该是 
       /plugin/example-0.1/js/mycode.js
   grails 处理它来确认资源在正确的位置.
   ***********************

   有一个特殊的pluginContextPath 变量,  在开发插件和插件安装后同时使用,  来确定插件的路径是否正确.

   运行的时候， pluginContextPath 变量可能是空串 或者 /plugins/example ， 对应的是插件单独运行 还是安装在应用中. 

   在lib和 src/java 以及 src/groovy 目录下的Java、Groovy代码将被编译到当前工程的 web-app/WEB-INF/classes 里面，因此在运行时也不会出现类找不到的问题.

. 提供基础的工件( Prividing Basic Artefacts )

  1. 增加新的脚本

  在插件的scripts目录下可以增加新的Gant相关的脚本:

   + MyPlugin.groovy
   + scripts     <-- additional scripts here
   + grails-app
        + controllers
        + services
        + etc.
    + lib

  2. 添加新的grails-app 工件( 控制器， 标签库， 服务， 等等)  Adding a new grails-app artifact(controller,Tag Library, Service, etc. )

    在插件的 grails-app 树中， 插件可以通过创建新的有关文件来创建工件(controller, Tag Library, Service, etc). 需要注意的是， 插件是从安装的位置载入， 而不是拷贝到应用的主目录树.

   + ExamplePlugin.groovy
   + scripts
   + grails-app
        + controllers  <-- additional controllers here
        + services <-- additional services here
        + etc.  <-- additional XXX here
    + lib

  3. 提供视图， 模板和 视图解决方案 (Prividing views, Templates and View resolution)

    当一个插件提供一个控制器的同时， 它也提供了缺省的views 来 被渲染(rendered). 这是非常好的途径来通过插件模块化应用。

    grails 视图处理机制 会先查找应用安装的view，如果没找到， 会尝试查找插件中的视图.   这意味着你可以重载插件提供的视图， 即 在应用的grails-app/view 目录中创建 插件中对应的GSPs.

    例如, 一个 'amazon'插件提供了一个 BookController 控制器. 如果执行list Action, Grails  会先找 grails-app/views/book/list.gsp， 如果没找到, 会在plugin 下面找同名的gsp.

    如果视图用了插件提供的模板, 下面的语法就是必要的:

    <g:render template="fooTemplate" plugin="amazon" />

    ** 注意上面的plugin属性， 是包含模板的插件的名称.  如果没有指定，Grails 就从应用中寻找相关的模板.

. 排除工件 (Excluded Artefacts)

  默认的， 当打包插件的时候， Grails 的插件包不包含以下文件:

    grails-app/conf/BootStrap.groovy

    grails-app/conf/BuildConfig.groovy ( 它用来创建 dependencies.groovy)

    grails-app/conf/Config.groovy

    grails-app/conf/DataSource.groovy ( 以及其他的 *DataSource.groovy )

    grails-app/conf/UrlMappings.groovy

    grails-app/conf/spring/resources.groovy

    /web-app/WEB-INF 中的所有内容

    /web-app/plugins/** 中的所有内容

    /test/** 中的所有内容

    在 **/.svn/** 和 **/CVS/** 中的所有SCM 管理文件( 配置管理文件 )

  如果你的插件需要 web-app/WEB-INF 目录中的文件, 你可以修改插件的scripts/_Install.groovy Grant 脚本 , 来安装这些工件到目标工程的目录树.  (这个意思似乎是拷贝到 应用的目录树， 而不是插件的目录树？？？？)

  另外, 不打包 UrlMapping.groovy 文件， 是为了防止命名冲突, 但是你可以将UrlMappings 定义成其他名字来打包进来. 例如 改成
grails-app/conf/BlogUrlMappings.groovy 就可以。

  不打包的列表内容通过设置 pluginExcludes 属性来实现:

  // resources that are excluded from plugin packaging
  def pluginExcludes = [
      "grails-app/views/error.gsp"
  ]

  这个特点非常有用, 例如 对于插件仓库中包含 demo 或 test 资源的， 最终发布的时候是不能把demo 和test 资源打包进去的.

. 评估规约(Evaluating Conventions)

  在得以继续查看基于规约所能提供的运行时配置以前，有必要了解一下怎样来评估插件的这些基本规约。本质上，每一个插件都有一个隐含的 GrailsApplication接口的实例变量：application。

  GrailsApplication 接口 提供了在工程内评估这些规约的方法并且保存着所有工件类的相互引用

  工件实现了GrailsClass 接口， 每个接口代表一个Grails 资源， 例如 一个controller 或一个 tag library. 例如： 获取所有 GrailsClass 实例， 可以这么做:

  for ( grailsClass in application.allClasses) {
      println grailsClass.name
  }
   
  GrailsApplication 有少数"神奇的"属性 用来限定你感兴趣的工件类型(narrow the type of artefact)。 例如  你可以这样访问controllers：

  for ( controllerClass in application.controllerClasses ) {
      println controllerClass.name
  }
  
  动态方法规约 的顺序如下:

    *Classes  -- 通过 特定的工件名称获取所有的类. 例如: application.controllerClasses.

    get*Class -- 通过 特定的工件名称获取一个命名的类. 例如: application.getControllerClass("PersonController")

    is*Class --- 如果给定的类 是给定工件类型的 则返回true.  例如: application.isControllerClass(PersonController)

  GrailsClass 接口有大量的非常有用的方法， 让你来评估和使用这些规约. 这些方法包括:

    getPropertyValue -- 获取类 的给定属性 的 初始值.

    hasProperty ------- 如果类 有指定的属性， 则返回true

    newInstance ------- 创建类的新实例.

    getName ----------- 如果可能的话， 返回应用中没有后缀规约部分的逻辑类名.

    getShortName ------ 返回没有包前缀的类的短名称 

    getFullName ------- 返回包含包名称及后缀部分的应用类的全称.

    getPropertyName --- 将类的名称返回为属性名称

    getLogicalPropertyName -- 如果applicable(应用可以的话)， 返回不带后缀的应用类的逻辑属性名称

    getNaturalName ---- 返回属性名称的自然语言的术语(例如: 将“lastName" 变成 "Last Name")

    getPackageName ---- 返回包的名称

. 参与构建事件 (Hooking into Build Events)

. 安装的时候进行配置  以及 指定升级

  Grails 插件 可以在安装的时候进行配置.  这是通过 插件的scripts 目录下的 _Install.groovy 文件类实现的.

  _Install.groovy 是在 插件被安装完成后被执行的. 

  这个脚本是一个Gant 脚本, (Gant就是使用Groovy对 Apache Ant 进行了简单的包装。) 你可以用Gant 的所有强大的功能. pluginBasedir 变量被增加到标准的Gant 变量汇总, 指向 插件安装的根目录.
  下面是一个_Install.groovy 脚本的例子， 在grails-app 目录中创建了一个新目录, 并且安装了一个配置模板


     ant.mkdir(dir: "${basedir}/grails-app/jobs")

     ant.copy(file: "${pluginBasedir}/src/samples/SamplePluginConfig.groovy",
              todir: "${basedir}/grails-app/conf")


    
  pluginBasedir 变量 在这个定制的脚本中是无效的, 不过你可以用fooPluginDir， foo 是你的插件名称. 

. 脚本事件

  可以 hook into 命令行脚本事件. 有些事件在 执行 Grails 目标和插件 脚本的时候可以被触发.

  例如, 可以hook into  更新状态输出( 例如, "Tests passed", "Server running"等等信息) 以及 工件文件的创建.  

  一个插件只能提供一个 _Events.groovy 脚本来监听 需求监控的事件. 参见 Hooking into Events 的相关文档.

. Hooking into 运行时配置

  Grails 提供了大量的钩子(hooks) 来  均衡(leverage) 系统部分与 依据规约 执行运行时配置.

. Hooking into Grails Spring configuration  钩进 Grails Spring 配置

  首先， 通过提供一个 doWithSpring 属性来钩进(Hook into) Grails 运行时配置,  doWithSpring 定义了一个代码块. 例如， 下面的代码片段是提供 i18n 支持的Grails 插件核心 的其中一部分.
 
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


  这个插件配置了Grails messageSource bean , 还有一对beans 来管理本地化解决方案(resolution) 和开关(switching). 它用的是 Spring Bean Builder 语法.

. 参与 web.xml 的生成  (Participating in web.xml Genenration)

  Grails 载入的时候生成 WEB-INF/web.xml文件， 虽然插件不能直接更改这个文件,  但是可以参与这个文件的生成. 插件可以提供一个 doWithWebDescription 属性， 赋值为一段代码块(闭包)， 将web.xml 传入闭包进行处理， 参数类型是 XmlSlurper GPathResult.

 1. 添加 servlet 和 servlet-mapping

 看看下面 ControllersPlugin 中的例子:

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

  这儿插件获取了上一个<servlet-mapping> 元素的引用， 并且, 在它用 XmlSluprer 的能力计算修改XML 似乎用闭包来 添加Grails 的 servlet 。

 2. 添加 filter 和 filter-mapping

   添加 filter 和他的映射关系与上面的做法有一点儿不同。<filter>元素位置不再是问题， 因为顺序不重要。所以非常简单的插入你定制的filter 定义在上一个<context-parm>元素即可。  重要的是映射的顺序， 通常的做法是 在<filter>元素之后理解添加映射:
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
   
  
  有些情况， 你需要确保你的filter 在一个标准的Grails filters 后面， 例如 Spring character encoding filter 或者 SiteMesh filter。   好的是，你可以在标准的filter (更精确的说法是， 指那些在web.xml文件中过滤器)后面直接插入filter mappings. 


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
  

. 初始化完成后进行配置

  有时候，需要在 Spring ApplicationContext 构建完成后进行运行配置。 这种情况你可以定义doWithApplicationContext 闭包属性:

class SimplePlugin {

    def name = "simple"
    def version = "1.1"

    def doWithApplicationContext = { appCtx ->
        def sessionFactory = appCtx.sessionFactory
        // do something here with session factory
    }
}

. 运行时添加动态方法

  1. 基础知识

     Grails 插件允许再运行的时候 注册 Grails 管辖类或其他类的 动态方法。用doWithDynamicMethods 闭包来实现.

    对于 Grails 管辖类， 比如 controllers, tag libraries 等， 是值得你添加方法的, 析构函数等等。 通过访问每个controller的 MetaClass 来使用 ExpandoMetaClass 机制。

class ExamplePlugin {
    def doWithDynamicMethods = { applicationContext ->
        for (controllerClass in application.controllerClasses) {
             controllerClass.metaClass.myNewMethod = {-> println "hello world" }
        }
    }
}   

   在上面这个案例， 用隐含的(implicit) application对象类获取 所有 controller 类 的 MetaClass 实例的引用. 给每个controller 添加了一个新方法myNewMethod。  如果你已经知道你要添加方法的类， 只需要简单的给类的metaClass属性上添加方法即可。下面是一个例子。 

   下面的例子是给 java.lang.String 添加一个新方法 swapCase:

class ExamplePlugin {

    def doWithDynamicMethods = { applicationContext ->
        String.metaClass.swapCase = {->                      // 注意这儿 只用的是String类，添加了方法 swapCase
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

. 跟 ApplicationContext 进行交互

  doWithDynamicMethods 闭包可以获得Spring ApplicationContext 实例。 这就非常有用了， 你可以与ApplicationContext实例里面的对象进行交互. 例如， 如果你想实现一个方法与Hibernate 进行交互，你可以与HibernateTemplate一同使用 SessionFactory 实例， 例如:

  
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

  因为Spring 容器 有自动装配(autowiring)和依赖注入(dependency injection)能力, 你可以在运行时是实现更强大的动态 constructors,  这个 constructors 用 应用上下文(application context)来装备你的对象及依赖关系.

class MyConstructorPlugin {

    def doWithDynamicMethods = { applicationContext ->
         for (domainClass in application.domainClasses) {
              domainClass.metaClass.constructor = {->
                  return applicationContext.getBean(domainClass.name)
              }
         }
    }
}

. 参与自动重载事件( Participating in Auto Reload Events) 

. 监控资源的改变( Monitoring Resources for Changes )

  通常来讲， 当资源发生改变的时候， 监控并且重新加载这些变化是非常有意义的.  这也是Grails 为什么要在运行时实现复杂的应用程序重新加载. 查看如下Grails 的ServicesPlugin 的一段简单的代码片段:

class ServicesGrailsPlugin {
    …
    def watchedResources = "file:./grails-app/services/*Service.groovy"

    …
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

  首先， 定义了watchedResources, 有可能是String 或者 String 的 List,   包含着要监控的资源的引用(reference) 或者模式(Pattern). 如果要监控的资源是Groovy 文件， 当它被改变的时候，就会自动被重新载入，并且传递给 onChange 闭包的event对象参数。

  event 对象定义了许多有用的属性:

    event.source ---- 事件源, 可能是重新载入的类 或者 Spring 资源

    event.ctx ------- Spring ApplicationContext 实例

    event.plugin ---- 管理资源的插件对象(通常是this)

    event.application -- GrailsApplication 实例

    event.manager --- GrailsPluginManager 实例

  通过这些对象， 你可以根据发生的改变来响应适应的对策。 在上述的"Services"示例中, 当一个service类变化时, 一个新的service类被重新注册到ApplicationContext中。 

. 影响其他的插件  ( Influencing Other Plugins )

  除了应对变化， 有时候插件还需要 影响其他的插件.

  例如 Services 和 Controllers 插件。 当一个 service 重新加载后， 除非你也重新加载controllers, 否则当你试图重新装配service 到旧的controller 类的时候就会发生问题。

  为了避免这种情况发生, 可以指定那些受到影响的插件。 这样， 当一个插件被检测到改变， 它就会被重新加载， 然后它影响到的插件也会重新加载.  例如 ServicesGrailsPlugin 实现这些的代码:

  def influences = ['controllers']

. 观察其他插件

  如果你想观察一个特定的插件的变化， 但又不需要监视插件的资源, 可以使用"observe"属性:

  def observe = ["controllers"]

  在这个案例中， 当一个controller 改变的时候， 你可以从对应的controllers 插件接收到 事件。

  也可以用通配符来观察所有的载入的插件

  def observe = ["*"]

  Logging 插件 必须做到这些， 以确应用运行过程中， 保它能添加log属性到任何发生改变的工件。

. 理解 插件载入顺序

. 控制插件的依赖

  插件经常依赖于其他已经存在的插件， 并且可以调整对这些插件的依赖。 通过2个属性来实现. 第一个是 dependsOn, 例如: 看看Hibernate 插件的代码片段:

  class HibernateGrailsPlugin {

      def version = "1.0"

      def dependsOn = [dataSource: "1.0",
                      domainClass: "1.0",
                      i18n: "1.0",
                      core:"1.0"]
  }

  Hibernate 插件依赖于现有的4个插件: dataSource, domainClass, i18n 和 core插件。

  依赖的插件会先于Hibernate 插件载入， 如果依赖的插件没有全部载入， 那么Hibernate 插件也不会载入.

  dependsOn 属性也支持简单的表达式语言来制定版本范围。 例如:

  def dependsOn = [foo: "* > 1.0"]
  def dependsOn = [foo: "1.0 > 1.1"]
  def dependsOn = [foo: "1.0 > *"]
  
  通配符* 表示任何版本. 这种表达式语法不支持任何后缀， 类似 -BETA, -ALPHA 等等.  所以 表达式"1.0 > 1.1" 将匹配下面的的所有版本:

  1.1           1.0          1.0.1    1.0.3-SNAPSHOT, 1.1-BETA2

. 控制载入顺序

  如果依赖关系无法被处理， 导致插件被放弃并不会被载入， 这说明建立的是强依赖.  我们可以通过 loadAfter和 loadBefore 属性来定义一个弱依赖:

  def loadAfter = ['controllers']

  这个例子中，如果controllers 插件存在的话， 当controllers 插件载入后， 载入目标插件； 否则 插件单独被载入.  插件可以适应其他已经存在的插件, 例如 Hibernate 插件在 doWithSpring 闭包中有下面的代码:

if (manager?.hasGrailsPlugin("controllers")) {
    openSessionInViewInterceptor(OpenSessionInViewInterceptor) {
        flushMode = HibernateAccessor.FLUSH_MANUAL
        sessionFactory = sessionFactory
    }
    grailsUrlHandlerMapping.interceptors << openSessionInViewInterceptor
}

    如果 controllers 插件已经被载入的话, Hibernate 插件仅仅注册 OpenSessionInViewInterceptor . manager 变量是 GrailsPluginManager 接口的实例, 它提供了与其他插件交互的方法.

    你也可以用loadBefore 属性来指定一个或多个插件在你的插件载入之前被载入. 

    def loadBefore = ['rabitmq']

. 范围和环境

  不仅仅可以控制插件的载入顺序， 还可以指定插件载入的环境以及范围(stage of build). 只需要简单定义一个或2个这样的属性在你的插件描述中:

   def environments = ['development','test','myCustomEnv']
   def scopes = [excludes:'war']

   在这个例子中， 插件只载入'development' 和'test' 的环境变量. 也不会打包成WAR文件， 因为它不包含'war'部分. 这让一些处于开发阶段的插件不会被打包到产品中被使用。

  所有可用的范围在枚举 变量BuildScope 中定义，  这儿总结如下:

  test -  运行 tests

  functional-test --- 运行functional tests

  run ---  对应 run-app 和 run-war

  war ---  打包应用成一个WAR文件

  all --- 插件响应所有的scope(缺省的)

 之前的2个属性值可以是下面之一:

  a string ----- 一个sole inclusion

  a list   ----- environments 或 scopes 的列表

  a map -------- 对应完全控制， 用'includes' 和/或 'excludes' 关键字, 可能是字符串， 也可能是列表值

  例如:

  def environments = "test"

  仅包含插件的test 环境

  def environments = ["development","test"]

  包含 development 和test 环境.

  def environments = [includes:["development","test"]]

  做的是与上面同一间事情.

. 工件 API

  现在你应该理解Grails 的工件概念了: 特殊的class 类型，不同于普通的Groovy 类和 Java 类， 例如， 为了增强它们， 用了额外的属性和方法。 工件例子包含 domain 类和 controllers 类。你可能不容易理解的是Grails 允许应用和插件开发者访问工件的底层, 这意味着你可以找到那些工件可以使用，并自己强化它们. 甚至可以提供你自己定制的工件类型.

. 查询可用的工件

  对一个开发者而言, 非常重要的一点是，找到那些domain类， controllers, 或 其它类型的工件 在应用中是可用的。

  。。。。

. 二进制插件

. 使用二进制插件

  dependices {

       compile "myconpany:myplugin:0.1"
  }

  

. ============ 现在 尝试如何把创建的插件 在应用中使用 ===============