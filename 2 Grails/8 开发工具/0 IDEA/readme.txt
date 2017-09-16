. 参见:

      http://wenku.baidu.com/link?url=Mfuif3r_465qTY6MDfO-fSqSJGRA8ClM7jKzOtVJKhDfgJNJnLKrmUQN1jQbSfZmySLsHa5R8jiTmH84vGst6LwggGHFeyzrc-2LGxxVxvO

. 1. IEDA 配置 JRE 运行环境

    选择 JDK 的安装目录, 在 Project Settings 中设置， 右面有Project SDK 的选择， 可以设置JDK 的位置。 还可以设置project 的输出位置。


         由于JDK 1.7 是用的glassfish4, 所以自动找到的可能是JDK 1.5， 可以更改设置为JDK 1.7的路径  

            D:\glassfish4\jdk7

         同时IEDA 也会自动搜到 Groovy 的路径， 不用单独设置了。

      可以选择新的project 是否使用额外的库和框架， 如 Groovy.

   ** 一般是新建完一个project 后可以进行设置。

   之前下载的免费版不支持Grails, 所以没有Grails 的项目支持部分。 后来又下载了 IDEA Utimate 14 版本， 但是需要注册

   注册码参见: 

        http://www.csdn123.com/html/topnews201408/28/6928.htm

   现在用的是:  (注册的时候断了网， 为了防止和已经注册的其他人冲突)

       key:huangwei
       value:97493-G3A41-0SO24-W57LI-Y2UGI-JGTU2
 
. 2. 测试

    随便创建一个Java Project , 然后在src 目录中创建一个java 程序， 可以用Java /junior 中的HelloWorldX 来进行测试。

    运行即可。

    * 需要注意的是， 编辑的过程中， 由于IDEA 和VIM 的快捷键有重复， 用^A ^C, ^V 等的时候可以选IDE shortcut , 这样就不影响使用了， 当然由于编辑环境是VIM , 也可以随时切换到VIM 快捷方式下， 非常方便。

     切换 可以点击 左下角的图标。

. 3. 开发 Grails project

     创建的时候没有提示Grails 的位置， 可能是IDEA 的版本不支持。 网上查看:

     http://wangcheng.iteye.com/blog/173860


     File -> Settings -> IDE Settings -> Groovy&Grails 

     需要先安装 JetGroovy 插件。 然后配置JetGroovy, 设置 Grails。(当然要提前下载并解压Grails-bin-...zip)

     ??新版本中根本没有 上面说的安装JetGroovy 插件的位置。

     有可能是安装的这个IEDA 版本不支持Grails , 当初下载的时候， 有2个IDEA 版本， 选择的是右面的， 明天选择左面的试试。

    下载并安装  IDEA Utimate 版本后， 就可以直接创建Grails project了。但是创建了Controller 和Domain， 后， 发现没有找到配置文件位置， 比如DataConfig.groovy, BuildConfig.groovy等。 这样就不能把表创建在目标数据库了。

     另外， 也不能之间运行， 每次云溪都要用Debug 方式，奇怪。。

    点击左下角的图标， 选择 Grails Console, 可以看到每次操作的输出结果. 

    运行的时候出现下面的错误:

Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error |
Forked Grails VM exited with error

  在Project  Structure 的 Libraries 中：中间的+号， 然后选择Maven 搜索

       org.springframework:springloaded:1.2.0.RELEASE

  然后搜索到后， 选中（可能有 新的版本，但是为防止版本不一致， 还是用提示的版本），然后 选择下载到 应用的lib 目录中。

  然后会提示， 选择模块，  

       abc

       abc-grailsPlugins
 
  我选择的abc, 因为是应用运行中需要的。

  然后再运行应用。  又出现下面的错误:


Packaging Grails application
................Error 
|
Error executing script RunApp: loader constraint violation: loader (instance of java/net/URLClassLoader) previously initiated loading for a different type with name "org/springsource/loaded/ReloadableType" (Use --stacktrace to see the full trace)

Process finished with exit code 1


URLClassLoader是ClassLoader的子类，它用于从指向 JAR 文件和目录的 URL 的搜索路径加载类和资源。也就是说，通过URLClassLoader就可以加载指定jar中的class到内存中。


这个错误应该是有2个类载入器冲突了， 一个是 Java的URLClassLoader, 另一个估计是 Spring的 ReloadableType.  。。。？？

如果仅仅只是选择了一个 Application Server 后， 则可以正常运行Grails Project , 而且显示实在Tomcat 7.0.5, 但是对于打开的页面，  localhost:8080， 并没有正常显示出缺省的Grails 欢迎页面。 但是也没有提示任何错误， 如果指定 Controller ， 比如:

   localhost:8080/FrController , 也没有先似乎任何内容, 但是也没有提示任何错误。 


====================================

  检查lib 的时候， 把netbeans 中Grails 项目中的lib 的 mysql-connector-java-5.1.5-bin.jar, 也拷贝到了现有应用的lib 目录下， 应为也会用到。 

  电表箱液压画

  创建Grails Project 的时候，  提示

     Spring Configuration Check

     Unmapped Spring configuration files found. Disable....

     Please configure/setup Spring facet for modules:
 
     sdf (1 file)

  在Project Structure -> Project Settings -> Modules 中设置  添加  Spring Application Context (就用默认的+ ， 然后OK)

  参见:

       http://blog.csdn.net/tiantiandjava/article/details/41204607

  重新关闭打开Project , 发现Spring的提示没有了， 出现新的提示:


   Unregistered VCS root detected

   The directory E:\4 WorkSpaces is under Git, but is not registered in the Settings:

   Add root, Configure, Ignore

  这个就是版本控制的部分， 随便处理即可。 

==========================================

查看 IntelliJ IDEA UI 14.1.4 版本的随机帮助中的Manul -> Grails 部分

. IDEA 支持 Grails 2.0.0 + 的所有属性

. 1. 准备工作

     下载SDK 并且安装包配置好

      Grails 插件在IDEA 中激活。  如果没有激活， 按照下面的方法进行激活:

      打开 Settings 对话框( Ctrl + Alt + S )

      在左面的pane, 选择 Plugins

      在Plugins page  (右面的打开的对话框中)

           激活plugin,  选择名字的check box

           消除plugin, 清除 check box 的对号

      如果列表中没有对应的插件， 需要下载安装插件

      重新启动IDEA 来确认修改有效。

  . 右键点击 Grails Project 名称， "Grails" -Run Grails target  来手动运行Grails Project,  

       Command Line :  输入 run-app (也可以下拉选择)

        可选的选项暂时用缺省的， VM options 不知道干啥用？

    然后点击OK.  就开始运行Grails Project 了。  运行的时候会自动下载安装需要的插件。然后进行编译。  最后出现下面的错误:


Error occurred during initialization of VM
agent library failed to init: instrument
Error opening zip file or JAR manifest missing : E:\1%20RunEnv\1.2%20Groovy\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar
Error |
Forked Grails VM exited with error


     把 springloaded\jars\springloaded-1.2.0.RELEASE.jar 拷贝到当前的project 的lib 目录下面， 然后重新运行。 然后又出现下面的错误。 

................Error 
|
Error executing script RunApp: loader constraint violation: loader (instance of java/net/URLClassLoader) previously initiated loading for a different type with name "org/springsource/loaded/ReloadableType" (Use --stacktrace to see the full trace)

可能不能将  springloaded-1.2.0.RELEASE.jar 拷贝到project 的lib 目录下面， 否则访问的时候可能会出现错误。 

这个问题可以产看  stackflow :

   https://www.baidu.com/link?url=7Qp0IDeou_Y6_-FfInW5V51xDmoDeqYnilErg7z4ivItz8hGWaQMHdlNpaHpM3p2UZqPO09WZN69FPHPlkDZrozAWcbDzjKPbTtMTZ2aix7XTSz9QQ7I7Hi0DT2hJfPVPT93zRMVEA8-QNCqdfmF6_&wd=&eqid=8a4d724300033c0b0000000355b320b4

  应该与之前 VM 的参数没有设置有关系。 

看百度知道的说明:

   http://zhidao.baidu.com/link?url=6zOThYIIIWRnS_W4Zj-vQyRy51M-6Bv81QD78Za25epDEriiwiwLkSkC37ABk87hVTAxf9JWbcgfkRh9HLaeu_

也就是你的grails在D:/Program file/下面的某一个文件夹里面 但是因为有空格它不能识别，所以就说找不到这个文件夹 

我就是遇到这个问题 然后我把grails放在D盘根目录下面就OK了

  这个回答与之前

     http://stackoverflow.com/questions/23530157/error-opening-zip-file-or-jar-manifest-missing-c-program

  中的回答有异曲同工的作用， 及加了双引号。 

  重新用netbeans 运行Grails Project, 没有问题， 可以运行。 发现就是在 Packaging Grails application. 重新查看Packing 机制

  参见:

       http://segmentfault.com/a/1190000000353272

  这段话说明了VM 与Grails 的关系。  
 
       "Grails 是一个基于Groovy 和Java 的开源Web 框架。 它是Java 虚拟机(JVM)上顺应Rails、Django等流行Web框架而生的, 伴随着标准的Jetty/Tomcat 服务器，  Grails 能帮助开发者进行快速的应用开发.  

  按理说， IDE 环境中应该自己配置对应VM 基本信息， 开发者调整相应参数即可。 但是现在IDEA 出现的问题好像是VM 混淆了。

  在IEDA 的Project 的  grails.bat 中有下面一句话:


  set AGENT_STRING=-javaagent:wrapper/springloaded-1.2.0.RELEASE.jar -noverify -Dspringloaded.synchronize=true -Djdk.reflect.allowGetCallerClass=true -Dspringloaded=\"%SPRINGLOADED_PARAMS%\"

  这个应该是VM 相关的设置。

  删除lib 目录中的 springloaded-1.2.0.RELEASE.jar. 可能是2个同名jar 出现冲突了。 然后发现IDEA 中的Project 突然可以运行了， 由于netbeans 的project 也用的是8080 端口， 停止了 netbeans 运行的的project， 然后重新运行 IDEA的 Project , 成功运行：

D:\glassfish4\jdk7\bin\java -Dgrails.home=E:\grails-2.4.2 -Dbase.dir=E:\3 -Dtools.jar=D:\glassfish4\jdk7\lib\tools.jar -Dgroovy.starter.conf=E:\grails-2.4.2/conf/groovy-starter.conf -Xmx768M -Xms768M -XX:MaxPermSize=256m -XX:PermSize=256m -Djline.WindowsTerminal.directConsole=false -javaagent:E:\grails-2.4.2\lib\org.springframework\springloaded\jars\springloaded-1.2.0.RELEASE.jar -noverify -Dspringloaded=profile=grails -Didea.launcher.port=7533 "-Didea.launcher.bin.path=C:\Program Files\JetBrains\IntelliJ IDEA IU 14.1.4\bin" -Dfile.encoding=GBK -classpath "E:\grails-2.4.2\lib\org.codehaus.groovy\groovy-all\jars\groovy-all-2.3.3.jar;E:\grails-2.4.2\dist\grails-bootstrap-2.4.2.jar;C:\Program Files\JetBrains\IntelliJ IDEA IU 14.1.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.groovy.grails.cli.support.GrailsStarter --main org.codehaus.groovy.grails.cli.GrailsScriptRunner --conf E:\grails-2.4.2/conf/groovy-starter.conf "run-app -plain-output"
|Loading Grails 2.4.2
|Configuring classpath
.
|Environment set to development
.................................
|Packaging Grails application
....................................
|Running Grails application
|Server running. Browse to http://localhost:8080/3

 在浏览器输入:
 
      http://localhost:8080/3

  出现正确的页面信息， 即 Grails 的 欢迎信息， 与NetBeans 中新建 Project 运行的一样。 

  那么为什么之前出现了错误， 难道就是因为将Grails 2.4.2 重新拷贝到了根目录？ 这样Grails 所在的路径中没有空格的原因？看上面的运行信息， 还真就是这个原因。。。。。。。


. 在IDEA中， Grails 是用library 来呈现的。