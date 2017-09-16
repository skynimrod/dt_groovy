. 参见:

      http://baike.baidu.com/link?url=nPed2mltZJvxxKcJ0WsD_r67Glmg6C7uL0GRJP0eNwAfeHGSvUj_gVuvZJSc1Z_TGwjKCdeF2ZfXEwbCzTZJ1_

      https://nodejs.org/    官网

      http://nodeschool.io/zh-cn/   官方 中文教程 

     http://blog.fens.me/nodejs-roadmap/   非常好的nodejs 的教程

. V8 引擎本身使用了一些最新的编译技术. 这使得 用Javascript 这类脚本语言 编写出来的代码运行速度 获得了极大提升, 却节省了开发成本.  对性能的苛求是 Node 的一个关键因素.  Javascript 是一个事件驱动 语言, Node 利用了这个优点, 编写出可扩展性高的服务器.  

  Node 采用了一个称为"事件循环"(event loop) 的架构, 使得编写可扩展性高的服务器变得极容易又安全.  

  提高服务器性能的技巧有很多种, node 选择了一种既能提高性能， 又能降低开发复杂度的架构.  这是非常重要的特性。 

  Node 采用一系列"非阻塞"库 来支持事件循环的方式. 本质上就是为文件系统、数据库之类的资源提供接口.  向文件系统发送一个请求时, 无需等待硬盘（寻址并检索文件）, 硬盘准备好的时候非阻塞接口会通知Node.  该模型以 可扩展的方式简化了对慢资源的访问, 直观，易懂.  尤其对熟悉onmouseover、onclick等 DOM 事件的用户, 更有一种似曾相识的感觉. 

  虽然 让 Javascript 运行于服务器端 不是Node的独特之处,  但却是 其 一 强大功能.  

. nodejs 作为一个新兴的后台语言, 有很多吸引人的地方 :

  RESTful API

  单线程

  Node.js 可以在不新增额外线程的情况下, 依然可以对任务进行并行处理 --- Node.js 是单线程的。 它通过事件轮询(event loop) 来实现并行操作, 对此， 我们应该要充分利用这一点 ---- 尽可能的避免阻塞操作, 取而代之, 多使用非阻塞操作.

  非阻塞IO

  V8 虚拟机

  事件驱动

. 3. 模块

  Node.js 使用 Module 模块去划分不同的功能, 以简化应用的开发。 Modules 模块有点像 C语言中的类库。 每一个 node.js 的类库都包含了十分丰富的各类函数, 比如 http 模块就包含了和http 功能相关的很多函数, 可以帮助开发者 很容易的对比 如 http, tcp/udp 等进行操作, 还可以很容易的创建 http和 tcp/udp 的服务器.

  要在程序中使用模块是十分方便的, 只需要如下:   *******************************************

  在这里, 引入了http 类库, 并且对 http 类库的引用存放在http 变量中. 这个时候, node.js 会在我们应用中搜索是否存在 node_modules 的目录, 并且搜索这个目录中是否存在 http 的模块.  如果node.js 找不到这个目录， 则会到全局模块 缓存中去寻找, 用户可以通过相对 或者  绝对路径, 指定模块的位置, 比如:

  var myModule = require('./myModule.js')

  模块中包含了很多功能代码片段, 在模块中的代码 大部分都是私有的, 意思是在模块中定义的函数方法和变量, 都只能在同一个模块中被调用. 当然， 可以将某些方法和变量暴露到模块外, 这个时候可以使用exports 对象去实现.

  windows 下
官网现已提供 安装包和编译器，版本:v0.12.7 和相应的API 文档（English）

. 示例

任何一套标准都由一个著名的程序开始：Hello World ！在Node中，Http是首要的。Node为创建http服务器作了优化，所以你在网上看到的大部分示例和库都是集中在web上(http框架、模板库等）。以下做了一个nodejs的Hello World 演示[6] ：

   var http = require('http');
   server = http.createServer(function (req, res) {
       res.writeHeader(200, {"Content-Type": "text/plain"});
       res.end("Hello World\n");
   });
   server.listen(8000);
   console.log("httpd start @8000");

. 2.1 Web开发：Express + EJS + Mongoose/MySQL

express 是轻量灵活的Nodejs Web应用框架，它可以快速地搭建网站。Express框架建立在Nodejs内置的Http模块上，并对Http模块再包装，从而实际Web请求处理的功能。

  通常用Nodejs做Web开发，需要3个框架配合使用，就像Java中的SSH。
   
  Bootstrap,   express    mongoose    -> nodejs

2.2 REST开发：Restify

restify 是一个基于Nodejs的REST应用框架，支持服务器端和客户端。restify比起express更专注于REST服务，去掉了express中的template, render等功能，同时强化了REST协议使用，版本化支持，HTTP的异常处理。

2.3 Web聊天室(IM)：Express + Socket.io

socket.io一个是基于Nodejs架构体系的，支持websocket的协议用于时时通信的一个软件包。socket.io 给跨浏览器构建实时应用提供了完整的封装，socket.io完全由javascript实现。


2.4 Web爬虫：Cheerio/Request

cheerio 是一个为服务器特别定制的，快速、灵活、封装jQuery核心功能工具包。Cheerio包括了 jQuery核心的子集，从jQuery库中去除了所有DOM不一致性和浏览器不兼容的部分，揭示了它真正优雅的API。Cheerio工作在一个非常简单，一致的DOM模型之上，解析、操作、渲染都变得难以置信的高效。基础的端到端的基准测试显示Cheerio大约比JSDOM快八倍(8x)。Cheerio封装了@FB55兼容的htmlparser，几乎能够解析任何的 HTML 和 XML document。

2.5 Web博客：Hexo

Hexo 是一个简单地、轻量地、基于Node的一个静态博客框架。通过Hexo我们可以快速创建自己的博客，仅需要几条命令就可以完成。

发布时，Hexo可以部署在自己的Node服务器上面，也可以部署github上面。对于个人用户来说，部署在github上好处颇多，不仅可以省去服务器的成本，还可以减少各种系统运维的麻烦事(系统管理、备份、网络)。所以，基于github的个人站点，正在开始流行起来….

2.6 Web论坛: nodeclub

Node Club 是用 Node.js 和 MongoDB 开发的新型社区软件，界面优雅，功能丰富，小巧迅速， 已在Node.js 中文技术社区 CNode 得到应用，但你完全可以用它搭建自己的社区。

2.7 Web幻灯片：Cleaver

Cleaver 可以生成基于Markdown的演示文稿。如果你已经有了一个Markdown的文档，30秒就可以制作成幻灯片。Cleaver是为Hacker准备的工具。

2.8 前端包管理平台: bower.js

Bower 是 twitter 推出的一款包管理工具，基于nodejs的模块化思想，把功能分散到各个模块中，让模块和模块之间存在联系，通过 Bower 来管理模块间的这种联系。

2.9 OAuth认证：Passport

Passport项目是一个基于Nodejs的认证中间件。Passport目的只是为了“登陆认证”，因此，代码干净，易维护，可以方便地集成到其他的应用中。Web应用一般有2种登陆认证的形式：用户名和密码认证登陆,OAuth认证登陆。Passport可以根据应用程序的特点，配置不同的认证机制。本文将介绍，用户名和密码的认证登陆。

2.10 定时任务工具: later

Later 是一个基于Nodejs的工具库，用最简单的方式执行定时任务。Later可以运行在Node和浏览器中。

2.11 浏览器环境工具: browserify

Browserify 的出现可以让Nodejs模块跑在浏览器中，用require()的语法格式来组织前端的代码，加载npm的模块。在浏览器中，调用browserify编译后的代码，同样写在<script>标签中。

用 Browserify 的操作，分为3个步骤。1. 写node程序或者模块, 2. 用Browserify 预编译成 bundle.js, 3. 在HTML页面中加载bundle.js。

2.12 命令行编程工具：Commander

commander 是一个轻巧的nodejs模块，提供了用户命令行输入和参数解析强大功能。commander源自一个同名的Ruby项目。commander的特性
：自记录代码,自动生成帮助,合并短参数（“ABC”==“-A-B-C”）,默认选项,强制选项, 命令解析, 提示符.

2.13 Web控制台工具: tty.js

tty.js 是一个支持在浏览器中运行的命令行窗口，基于node.js平台，依赖socket.io库，通过websocket与Linux系统通信。特性：支持多tab窗口模型; 支持vim,mc,irssi,vifm语法; 支持xterm鼠标事件; 支持265色显示; 支持session。

2.14 客户端应用工具: node-webkit

Node-Webkit 是NodeJS与WebKit技术的融合，提供一个跨Windows、Linux平台的客户端应用开发的底层框架，利用流行的Web技术（Node.JS，JavaScript，HTML5）来编写应用程序的平台。应用程序开发人员可以轻松的利用Web技术来实现各种应用程序。Node-Webkit性能和特色已经让它成为当今世界领先的Web技术应用程序平台。

2.15 操作系统: node-os

NodeOS 是采用NodeJS开发的一款友好的操作系统，该操作系统是完全建立在Linux内核之上的，并且采用shell和NPM进行包管理，采用NodeJS不仅可以很好地进行包管理，还可以很好的管理脚本、接口等。目前，Docker和Vagrant都是采用NodeOS的首个版本进行构建的。

========================================

. 如何运行 

  打开终端, 键入 node 进入命令行交互模式, 可以输入一条代码语句后, 立即执行并显示结果, 例如：

  