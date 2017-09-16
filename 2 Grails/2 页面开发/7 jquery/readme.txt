参见:

     jquery.com                    官网

     http://www.jquery123.com/     非常好的jquery  的中文学习网站(BootStrap 提供的)

. $(function(){ }  这是jquery里的,是当文档载入完毕就执行,的意思.

. 学习JQuery 的第一件事是: 如果你想要一个事件运行在你的页面上, 你必须在$(document).ready()里调用这个事件。  所有包括在$(document).ready() 里面的元素 或 事件 都将会在 DOM 完成加载之后立即加载，并且在页面内容加载之前。
  代码大致如下:

  $(document).ready(function() {
     // put all your jQuery goodness in here.
  }); 



  有很多方法可以确保事件在页面上正常工作, $(document).ready() 比其他方法要更有优势。 首先， 你不必在HTML 上放置任何“行为性的”标记。另外, 你可以将javaScript/jquery 写入一个独立的js 文件, 这样既容易维护， 又保证了js与页面内容的隔离. 如果你在浏览网页时更加细心， 你就会经常发现这种情况：当你将鼠标悬停在一个连接时， 有时状态连中 会显示“javascript:void()”这样的信息。 这就是你把一个事件直接放在<a href> 标签里所造成的.

  在一些使用traditional JavaScript 的页面， 你会在<body>标签里看见"onload"属性。 这会导致一个问题: 它限定了在body 上只能有一个函数事件。 是的， 因为它又往内容中添加的“行为性的”标签。 如果你想解决这个问题， 请参考 Jeremy Keith 的书: DOM Scripting, 里面讲述了如何在一个单独的js文件里创建一个"addLoadEvent"函数, 它允许多个函数可以在body 里被加载. 但是这种方法需要为本来很简单的问题编写相当数量的代码, 另外， 这种方法是在加载window 时触发这些事件的, 这不得不让我再一次想起$(document).ready() 的好处. 

  使用$(document).ready(), 你能让你的事件在window 加载之前加载 或触发. 所有你写在这个方法里面的都准备在最早的时刻加载或触发。 也就是说，一旦DOM 在浏览器中注册后, $(document).ready()的代码就开始执行.  这样, 用户在第一眼看见页面元素时, 特效就可以运行了。

. 例子：

        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>
            var gNumber = 0;
            $(document).ready( function() {
                var pagenumber = ${retcode}
                alert(gNumber);
                alert(pagenumber); 
                $("#Aaaa").click( function() {
                    if ( ${ retcode == 200 } ) {
                        alert("i don't know");
                        var ele1 = "<tr><td>22 | 600036</td><td><a href='http://news.sina.com.cn'>reportname</a></td></tr>"
                        var txt1="<p>Text.</p>";              // 以 HTML 创建新元素
                        var txt2=$("<p></p>").text("Text.");  // 以 jQuery 创建新元素
                        var txt3=document.createElement("p");
                        txt3.innerHTML="Text.";               // 通过 DOM 来创建文本
                        $("#omgtest").append(ele1);   
                        $("#heas").remove();
                        gNumber = gNumber+1;
                        pagenumber ++;
                        alert(gNumber);
                        alert(pagenumber); 
                        
                    }
                    alert("really????");
                } );
                $("#Baaa").click( function() {
                    alert("hello world");
                    $(this).hide();
                } );
            });
            alert("here is top of the page!")

  ...

              <a id = "Aaaa" href="javascript:void(0);">Hello world</a>
....

             <a id = "Baaa"href="javascript:void(0);">Hello world</a>

  说明， 

      这个例子中 如果alert("here is top of the page!")  能被执行， 说明前面的脚本没问题， 否则说明脚本有错误。

      实际测试过程中， 如下代码就有问题：

   这儿有2个计数器都可以用，一个是整个Javascript 中可以访问并修改的gNumber， 一个是 Jquery 脚本里面定义的pagenumber, 也可以在每个选择器事件中动态访问并修改
  
   但是jquery 中的计数器， 在其他script 中修改无效， 属于超出作用域了。 

. JQuery 中如何访问 Grails 后台传递过来的结果集？？？

  访问当个参数是没有问题， 但是访问结果集的方式？？？

  实际上是JavaScript 访问对象数组的问题。。。。。。

  已经解决， 参见“后台向前端传递参数”

. 渲染的时候， 会重新执行jquery的ready() 函数， 那么里面的部分语句也会被执行， 但是绑定的事件则需要相关操作后才会被执行。