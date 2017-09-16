. XMLHttpRequest 对象 是 AJAX的基础

  所有的现代浏览器都支持  XMLHttpRequest 对象( IE5 和 IE6 使用 ActiveXObject)

  XMLHttpRequest 用于在后台与服务器交换数据. 这意味着 可以在不重新加载整个网页的情况下， 对网页的某部分进行更新.

. 创建 XMLHttpRequest 对象

  所有现代浏览器（IE7+、Firefox、Chrome、Safari 以及 Opera）均内建 XMLHttpRequest 对象。
  创建 XMLHttpRequest 对象的语法：

  variable=new XMLHttpRequest();

  老版本的 Internet Explorer （IE5 和 IE6）使用 ActiveX 对象：

  variable=new ActiveXObject("Microsoft.XMLHTTP");

  为了应对所有的现代浏览器，包括 IE5 和 IE6，请检查浏览器是否支持 XMLHttpRequest 对象。如果支持，则创建 XMLHttpRequest 对象。如果不支持，则创建 ActiveXObject ：

  var xmlhttp;
  if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
  }
  else
  {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }

. XMLHttpRequest 对象用于和服务器交换数据

  1. 向服务器发送请求

     如需将请求发送到服务器， 可以使用 XMLHttpRequest 对象的 open() 和 send() 方法:

     xmlhttp.open("GET", "test1.txt", true)
     xmlhttp.send();

     方法:

     open( method, url, async)
 
          规定请求的类型、url以及是否异步处理请求.

          method : 请求的类型; GET 或 POST

          url : 文件在服务器上的位置

          async: true(异步) 或 false (同步)

    send(string)  

          将请求发送到服务器

          string: 仅用于post 请求

   
  GET 还是 POST？

  与 POST 相比，GET 更简单也更快，并且在大部分情况下都能用。
 
  然而，在以下情况中，请使用 POST 请求：

    无法使用缓存文件（更新服务器上的文件或数据库）
    向服务器发送大量数据（POST 没有数据量限制）
    发送包含未知字符的用户输入时，POST 比 GET 更稳定也更可靠


  2. 
