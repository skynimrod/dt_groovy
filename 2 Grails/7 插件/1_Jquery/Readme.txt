. 参见：

      http://grails.org/plugin/jquery

      https://github.com/gpc/grails-jquery   代码

. Grails 提供了从 java 到 JSON 数据转换的方法 render <java object> as JSON，大大简化了开发任务

. JQuery 语法

  JQuery 语法是为HTML 元素的选取编制的, 可以对元素执行某些操作.

  基础语法是:  $(selector).action()

   美元符号定义   JQuery

   选择符(selector)  "查询" 和 "查找" HTML 元素

   jquery 的 action() 执行对元素的操作.

  示例:

     $(this).hide() - 隐藏当前元素

     $("p").hide() - 隐藏所有段落

     $(".test").hide() - 隐藏所有 class="test" 的所有元素

     $("#test").hide() - 隐藏所有 id="test" 的元素

  ## JQuery 使用的语法是 XPath 与 CSS选择器 语法的组合. 