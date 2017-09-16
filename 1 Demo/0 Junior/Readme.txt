. Groovy 有自身的 shell 程序, 打开后, 可以像 R 语言一样进行执行.

. 在命令行下面: (或者 windows 执行: windows + R)

  > groovysh

  就会启动groovy 的 shell 环境

. 最好在Eclipse 中添加Groovy Plugin 来进行调试. 

. 在Eclipse for JEE 中创建Groovy Project 并进行开发调试的步骤:

  1. New Project

     选择 Groovy Project. 

     起好项目名字后, 选择JRE 版本, 以及是否需要workSpace. 等等.

     创建完成后, 发现Eclipse 里面没有.... 其实已经创建好了, 不过新装的Eclipse 其实是欢迎界面, 点击 EE 图标(欢迎页面左上角的， 鼠标移上去有显示)， 则显示出 当前工作区下面的项目.

  2. Groovy 新项目自动 添加了Groovy Libraries 包含以下jar (jar后面是对应的绝对路径)

     groovy-all-2.1.8.jar

     servlet-api-2.4.jar

     ivy-2.2.0.jar

     ivy-2.2.0-sources.jar

     bsf-2.4.0.jar

  3. Groovy 新项目 自动添加了 DSL 支持 (Groovy DSL Support)   
   
     global_dsld-support -  c:\Documents and Setting\Administrator\.groovy\greclipse

     plugin_dsld_support - E:\1 RunEnv\1.1 Java\eclipse-jee-kepler-SR2-wine32\eclipse\plugins\org.codehaus.groovy_2.1.8xx-201405300180-e43j8\

  4. 然后new 一个groovy class 来进行测试.

    参见:

        wiki-snapshot.pdf   -----> Groovy 安装后自带的文档

        http://blog.csdn.net/kmyhy/article/details/4200563

    最好在src 下面再建2个子目录  .\java 和 .\groovy，  分别用于存储 java 源文件和 groovy源文件

     a. 添加 groovy 特性

        在项目 上右击 Groovy -> Add Groovy Nature, 这样会在项目中添加 Groovy Libraries。

     b. 添加 Groovy 类

         在项目 Groovy 源文件下 右键 -> New -> Other -> Groovy -> Groovy Class

         类名称为 HelloWorld 。 自动生成的代码如下：

package Groovy

class HelloWorld {
	

}


        添加:

    	public static void main(def args) {
		println "hello  World!!!";
	}


       现在测试运行:

           在源文件上右键，Run As -> Groovy Script，在控制台中查看运行结果。 如果选择 Run As -> Groovy Console  则会弹出 Groovy 的Console 窗口.   该窗口中也可以运行调试 Groovy 类.

. groovy 文件可以在命令行下面直接执行. 

  c:\>groovy helloworld.groovy

. groovy 文件可以直接是语句, 系统会自动对象化来执行. 例如: helloworld.groovy

. groovy 文件里面的main() 格式与java 类似, 不过 参数是def args .  命令行执行的时候就是执行main()

  例如:  $ groovy helloworld1.groovy

. 可以执行多个groovy 文件，但是只会执行第一个　main()， 第二个main() 就不会被执行.

   ## 看错了, 不能执行2个groovy 文件. .....-----------

  另外, groovy 不要求 文件名称必须与类名称相同.  例如:

     helloworld1.groovy 里面的类 名称为 HelloWorldtest  , 但是仍然可以执行(参见 .\0 helloworld\子目录下面的run.bat)

. 一个groovy 文件中, 如果有多个class, 那么有main()函数的类必须放在第一个. 另外一个文件中只能有一个main(). 

    