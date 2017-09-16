参见:

     http://www.grails.org/         官网， 可以打开

     http://www.grails.org/single-page-documentation.html

     http://www.grails.org/download.html     下载地址

     http://www.grailscn.com/       这个是国内的官网

     http://baike.baidu.com/view/1097340.htm?fr=aladdin

     学习:  https://grails.org/learn      是官方提供的学习资料, 非常好

            grails-petclinic-master.zip   是上面 提供的一个简单的例子. 

. Grails 是Groovy 的Web 开发框架. 

. Grails 是一套用于快速Web应用开发的开源框架, 它基于Groovy 编程语言, 并构建 于Spring、Hibernate和其他标准Java框架之上, 从而为大家带来一套能实现超高生产力的一站式框架.

  Ruby on Rails 开创了一门强大的编程语言 和 一个坚持己见、提倡用 通情达理的默认设置 代替 复杂配置的框架进行创造性结合的先河. 然而, 还有许多组织 并没有做好 从Java 的安全保护伞下 走出来的准备, 也米有打算放弃他们目前在Java 上的投入. 而 Grails 的出现, 使得在一个以Java 为中心的环境中实现同等生产力的想法称为可能. 

. 插件

     grails 的插件系统也是其亮点之一. 首先, 和rails， django 等web框架类似, 基于微内核的思想, 插件(可重用模块)是框架的一等公民.  grails 除了 核心模块意外的功能几乎都是通过插件方式实现的. 实际上, 一个 grails 插件和一个grails 应用 基本是完全一样的, 同样可以使用grails run-app 命令来运行. 区别仅在于一个插件的根目录下需要提供一个fooplugin.groovy 文件, 提供插件的一些描述信息.

     grails 插件基本可以做任何事情, grails社区 已经提供了各式各样的插件, 发布在grails 官方插件源上.

        grails list-plugins                                查看现有的官方插件

        grails install-plugin 插件名或插件路径             安装插件

        grails uninstall-plugin  插件名 或者 插件路径      卸载插件

. 特点

     如今的Java Web 开发对于需求来说已经变得过于复杂. 当今众多Java 领域的Web 开发框架不仅使用复杂, 而且并没有很好地遵循 Don't Repeat Yourself (DRY) 原则. 像 Rails， Django 和 TurboGears 这样的动态框架 在Web开发领域开辟了一条新的道路, Grails 基于这些概念之上, 采用动态方法减小了Java 平台上进行web 开发的复杂度, 不过与那些框架不同的是, grails 是构建在Spring 和Hibernate 等Java 已有技术之上的. Grails 是一个full-stack 框架, 它借助于 核心技术与相关的插件(Plug-in) 来解决 web 开发中 方方面面的问题, 包括:

    1. 易于使用的基于Hibernate 的对象-关系映射(ORM)层, 称为 Groovy Server Pages (GSP) 等表现层技术

    2.  基于 Spring MVC 的控制器层

    3.  构建于 Gant 上的命令行 脚本运行环境, 内置 Tomcat 服务器, 不用重新启动服务器就可以进行加载

    4.  利用内置的Spring 容器实现依赖注入

    5.  基于Spring 的MessageSource 核心概念, 提供了对国际化(i18n) 的支持

    6.  基于Spring 事物抽象概念, 实现事物服务层

    7.  借助于功能强大的Groovy 动态语言和领域特定语言( Domain Specific Language, DSL), 以上那些特性变得非常易用.

. 示例

  是一个被用烂了的而又经典的例子, 在创建应用程序之前, 先熟悉一下 grails 命令的使用(确保grails 环境已经配置好)

     grails command name

  我们为了创建一个grails 应用, 需要输入的命令是create-app

     grails create-app helloworld

  这样就在当前目录下创建了一个名为helloworld (即我们的应用程序名)的文件夹, 在这个文件夹中包含了我们这个项目的整个文件目录, 可以使用如下命令进入这个目录中查看:

    cd helloworld

  为了完成这个经典的Hello World 示例, 我们需要运行 create-controller 命令,先进入CMD 命令并执行:

    grails create-controller hello

  运行该命令后会在grails-app/controller 目录下创建一个名为 HelloController.groovy 的控制器. 控制器主要用来完成对Web 请求的处理, 我们稍微修改一下控制器的内容, 使它能够在页面上输出"Hello world!"的字样, 代码如下:

     class HelloController {
           def world = { render "Hello World!"}
     }

  控制器已经完成了, 接下来要使用run-app 来启动内置的jetty服务器　运行刚刚创建的helloworld 程序.

  grails run-app 运行后会在8080 端口(默认的, 可以使用 -Dserver.port 来指定端口)启动服务器, 然后再浏览器中输入

     http://localhost:8080/helloworld 来启动应用程序.

. SpringSource 提供了一些 Training 的资料. 但是对中国要收费. 参见:

      http://mylearn.vmware.com/mgrReg/plan.cfm?plan=31719&ui=www_edu

. "约定优于配置" (Convention Over Configuration)

. Ajax (异步JavaScript 和 XML)， 标志着Web 2.0 时代的到来. 

. 现有的Java 框架遵循的是传统的 开发->编译->部署的模式, 而随着需求的增加和项目规模的扩大, 这一过程明显缓慢而臃肿.  Ajax 程序在项目规模上不可避免的会大于传统的Web 应用。 这也意味着要在部署一个Web 应用程序前的编译和打包环节 花费更多的时间. 

  对这些Ajax 应用的流程测试 也开始成为问题. 因为大量的状态保留在客户端, 因此当应用服务器重新启动时, 不得不重新加载浏览器, 这在某种意义上是技术的一种倒退. 

  框架首要的目的在于适应实际需要, 但是这对于静态类型的Java 虚拟机来说绝非易事 , 因为 Java 类需要被重新编译. 而动态语言中这一情况恰恰相反, 这些动态语言或者是解释运行, 或者能够在运行时自动更新资源.

  对于上述动态语言为基础的框架来说, Ajax 的到来如同雪中送炭, 而且这些框架也纷纷为开发人员提供了对Ajax 开发应用和自动加载的支持.  在加上与Prototype 和 Acript.aculo.us 等JavaScript 库的紧密集成, 现在开发人员可以很容易地执行异步请求, 监控Html 元素, 以及使用富有吸引力的特效.

  这些框架提供的迭代开发, 零配置或者无发布周期, 以及基于规约的编程, 都使其成为极具吸引力的开发环境.

. Grails 选择最流行的开源技术作为基础框架, 具体的开源醒目分类如下:

  1. Hibernate : Java 中对象关系映射的实际标准;

  2. Spring : 极为流行的反转控制容器和其他Java 框架的包装器;

  3. Quartz : 非常灵活的企业级 作业调度框架, 可以持续执行作业;

  4. SiteMesh : 稳定的布局渲染框架. 

. Grail 入门

  1. 从官网 http://grails.org/ 下载最新发布的版本

  2. 将相关的压缩包解压到一个目录中, 可以是专门用来开发的目录, 也可以简单的直接解压到桌面上;

  3. 设置GRAIL_HOME环境变量, 值为 步骤2 中解压的Grails 目录路径.

  4. 为了能够在终端或者命令窗口中运行Grails 脚本, 需要将Grails 的bin 目录加到系统环境变量 "PATH"中. 

  5. 验证.  D:\> grails

     需要注意的是  grails 2.4.2 在jre 1.5.0 下运行, 出异常, 可能是版本不支持.   

     将 JAVA_HOME 指向 JRE 1.7 后, 上面的命令就可以运行了, 会提示downloads 一堆 关于grails 相关的jar， 然后出现: 

     grails> 提示符

  6. grails > quit

     退出后会发现, 在当前目录中, 多出来一些"." 开头的文件, 有一部分就是grails 相关的. 还有一些是gradle, android, myeclipse, fgclient， groovy, sts, m2 等一大部分文件或目录. 

     非常好用.....!!!!!!!!!!!!!!!!!!!!

. 在目标目录 运行 Grails create-app,  会提示输入应用名称, 系统会自动创建同名的目录, 并且在目录下面创建后应用工程文件及目录.

  进入刚才创建的应用目录(例如Hello)后， 运行 Grails create-controller , 系统会自动下载需要的文件(.pom, .jar), 然后提示输入controller的名称.

  注意, 如果是机器第一次运行, 需要确保能联网, 需要通过网络下载需要的文件.  系统会自动在grails-app\controlls\下创建对应的controller.

  测试：

       http://localhost:8080/hello  (后面的内容需要进一步核实)

       实际上是在 Grails 中内嵌的tomcat 中运行的， 需要确认 内嵌的tomcat 到底在什么地方. 

  上面的测试通不过, 因为应用还没有启动.  

  在应用目录下, 运行 grails run-app  来启动, 结果出现错误. 错误信息参见: 

      log.txt, log2.txt (grails run-app 1>log.txt 2>log2.txt )

  分析日志， log2.txt 中：

    [groovyc] org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
  [groovyc] General error during semantic analysis: unable to locate the java compiler com.sun.tools.javac.Main, please change your classloader settings
  [groovyc] 
  [groovyc] java.lang.ClassNotFoundException: unable to locate the java compiler com.sun.tools.javac.Main, please change your classloader settings

   查阅百度资料, 似乎是不同编译器引起的(本机中有JDK1.5和 JDK1.7) . 要修改类加载器的设置？？？

   没有配置CLASSPATH环境变量, 可能有关系>>><>>>>>

   如何查看grails 当前的配置(例如: 使用的JDK版本, tomcat 版本及位置等等.)

   现在 查看Tomcat ， 发现也出现了问题. 可能是类似的问题.   

. 关于 Domain Class

  非常好的设计. Domain Class 实际上就是 ORM 的实现, 就是对象和 数据的映射. Grail 自动将 数据的操作(增删等) 加入了进去. 通过Controller 来进行控制操作.  实现也非常简单, 只需要在Controller 中添加 Domain Class 的定义即可. 

  
. 用netBeans 创建 项目， 没有增加任何内容的时候， 运行时出现下面的错误提示:

 Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error occurred during initialization of VM
agent library failed to init: instrument
Error |
Forked Grails VM exited with error

在命令行下面创建并运行应用的时候, 也出现下面的问题：

Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grai
ls-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.ja
r

说明问题是一样的，“VM代理库的初始化过程中发生的错误无法初始化”

但是为什么运行之前的项目就可以， 比如 Grails_OnlyController 就可以正确运行

好像是要修改配置文件:

   BuildConfig.groovy  

   run:.....

   修改为 : run: false,

  然后运行就没有问题了。