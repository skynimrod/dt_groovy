. 更新失败后恢复

  1. 环境变量改回去

  2. NetBeans 中的工具 -> 选项 -> 其他 中的 Grails 的路径设置回原来路径

  3. 关闭当前项目(或关闭所有项目)

  4. command 模式下， 运行 Grails clean

     或者更为保险的做法是， 手工删除project 目录下的 target 子目录下的所有内容， 删除 grails-app/plugins 子目录下的所有内容

  5. 然后重新打开project , 再运行， 即可

. 更新 Grails 2.4.2 -> Grails 3.0.3

  1. 环境变量设置为 Grails 3.0.3的路径

  2. Netbeans 中工具 -> 选项 -> 其他 中的 Grails 的路径设置为 Grails 3.0.3的路径

  3. 打开项目运行

     出现下面的错误

|Running application...

FAILURE: Build failed with an exception.

* What went wrong:
Task 'bootRun' not found in root project 'Grails_OnlyController'.

* Try:
Run gradle tasks to get a list of available tasks. Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
Error |
Failed to start server (Use --stacktrace to see the full trace)

  4. 关闭现有所有的Project, 重新建立一个3.0.3 环境下的project ，看看与现有project 有何不同。 
   
     由于Grails 3 版本对应的是Groovy 2.4 版本系列， 所以应该同时更新Groovy 版本。 

        参见:  Grails 3 -> User Guide -> 1.1.1 Core Features

      Groovy 2.4

      Grails 3.0 comes with Groovy 2.4 which includes many new features and enhancements.

      For more information on Groovy 2.4, see the release notes for more information.

     
 
     