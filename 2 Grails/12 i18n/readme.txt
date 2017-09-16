. i18n 是 internationalization 的首末字母 i 和 n , 18 为中间的字符数。 是国际化的简称. 让产品(出版物，软件， 硬件等) 无需做出大的改变就能适应不同的语言和地区的需要.  对于程序而言, 在不修改内部代码的情况下, 能根据不同语言及地区显示相应的界面. 

  在全球化的时代, 国际化尤为重要, 因为产品的潜在用户可能来自世界的各个角落. 通常与 i18n 相关的还有L10n(本地化的简称)


.i18n 和 L10n 的国际组织是 Openi18n 组织， 其前身是 li18nux 组织。 它原来是指定 GNU/Linux自由操作系统上软件全球化 标准的国际计划, 后来扩充到GNU/Linux之外所有开放源代码的技术领域, 因而更名为 Open Internationalization Initiative , 有非营利组织 Free Standard Group 赞助， 并为世界各大厂商所支持, 对于GNU/Linux 系统上的多国语言文字处理技术和环境有决定性的影响.  各个开源软件开发组织通常都有负责"国际化"和"本地化" 工作的分支机构.

  i18n 主要使用 gettext软件包 使软件实现国际化支持. 事实上它是一整套 i18n 解决方案. 现在开源程序中，普遍通过分离语言文件, 然后通过gettext软件包来实现国际化发展.

. Grails 有 i18n 插件，是创建工程的时候缺省安装的.

  参见:

      http://www.kuqin.com/grails-doc-1.0/guide/10.%20Internationalization.html
 
      http://grails.github.io/grails-doc/2.4.2/guide/i18n.html

  Grails通过Spring MVC所提供的功能支持国际化（i18n）。在Grails中,你可以根据用户的Locale自定义任意视图中的文本。Java类中Locale的javadoc引用如下：

    一个 Locale 对象描述了一个特定地理的、政治的和文化的语言环境。一个要求 Locale 执行的任务操作是 语言环境敏感的 ，它使用 Locale 来为用户裁剪信息。例如，显示一个数字是语言环境敏感的操作--数字应根据用户的国家、地区或文化的风俗/传统来格式化。 

Locale是由语言代码 和 国家代码组成。例如，"en_US"是美国英语的语言码，而"en_GB"代表英国英语。 

. 1. 理解信息绑定

  既然你已经有了Locales的概念，为了在Grails中利用它们，你必须要创建你希望展现的不同语言的信息绑定。Grails的信息绑定是一些简单的Java属性文件,并且位于grails-app/i18n目录下。

  每一个绑定的名字习惯上都是以 messages开始，并且以locale结束。Grails的 grails-app/i18n目录下自带了很多不同语言的信息绑定。比如：

messages.properties
messages_de.properties
messages_es.properties
etc.

缺省情况下，Grails将在messages.properties查找信息，除非用户指定了自己的locale。你也可以创建你自己的信息绑定，只需要简单地创  建一个属性文件，此文件要以你感兴趣的locale结尾。比如 messages_en_GB.properties 代表的是英国英语。 

. 2. 改变Locales

  缺省情况下，用户的locale是通过HTTP信息头（header）中的 Accept-Language来检测的。但是你也可以简单地在Grails的请求参数中传入 lang参数来切换用户认可的locale，比如：

/book/list?lang=es

  Grails将自动地切换到用户的locale，并且将其保存在cookie中，因此接下来的请求将使用新的信息头。 

. 3. 读取信息

在视图中读取信息

你最需要信息的地方是在视图中，要在视图中读取信息，只需要使用message标签：

<g:message code="my.localized.content" />

只要在你的 messages.properties （当然要有适当的locale后缀）中有相应的关键字（如以下所示），Grails将会在其中查找消息：

my.localized.content=Hola, Me llamo John. Hoy es domingo.

注意，有时候你可能需要传入一些参数给消息，这在 message标签中也是可以做到的，比如：

<g:message code="my.localized.content" args="${ ['Juan', 'lunes'] }" />

接下来就可以在消息中使用这些位置参数了：

my.localized.content=Hola, Me llamo {0}. Hoy es {1}.

在控制器和标签库中读取信息

既然你可以在控制器中象调用方法一样调用标签，那也可以很容易的在控制器内读取信息：

def show = {
	def msg = message(code:"my.localized.content", args:['Juan', 'lunes'])
}

同理，你也可以在标签库中使用，但是要注意：如果你的标签库有不同的命名空间，你需要加一个前缀 g.：

def myTag = { attrs, body ->
	def msg = g.message(code:"my.localized.content", args:['Juan', 'lunes'])
}

. 4. 实际操作

  修改 grails-app/i18n/目录下的message.properties 和 对应的语言的message文件, 例如 message_zh_CN.properties 

  对于工程目录树而言，是target/work.resources.grails-app.i18n/目录下的 message.properties 和 对于语言文件(例如 对应中文的是

     messages_zh_CN.properties)

  添加对应的message 定义。

  在gsp 中， 也可以嵌入在JavaScript 中直接使用

  <g:message code="menu.gsp.popmenu.refresh" />

  这样的代码来替代对应的文本信息， 这样也变相解决了中文显示问题。 

  ***  测试的时候， 修改的文件是 target\work\resources\grails-app\i18n 目录下面的，因为 在工程文件结构中显示的i18n 就是这个目录下面的. 

  上面搞错了， 可以直接在工程结构中的 消息包（message packages） 中修改对应的消息内容

  其实2个位置的message 都可以用, 不过优先使用的是 grails-app/i18n/下面的。

  这些文件的编码方式都是 ansi , 所以消息中的内容 非英文部分都是使用的内码， 比如汉字用  \u5237\u65b0\u6d4b\u8bd5 等

. 关于message 的访问补充可以参见:

   ..\2 页面开发\18 后台向前台传递参数

  主要是涉及 js 中对 i18n 的message 的访问.

  将 gsp 中需要访问的 i18n message 全部在controller 中访问后存贮到哈希表中， 然后通过参数传递给gsp ， 这样 gsp 中的js 访问起来就非常方便了. 

. 关于注释

  注释用 //

  注释只能单独一行

  注释不能放在消息行尾， 不然会作为消息的值被取到

. 5. 在JavaScript 中访问

   alert("${message(code:'smms.main.reportProc')}")
 
   也是用的${}, 与标签中使用一样。
  