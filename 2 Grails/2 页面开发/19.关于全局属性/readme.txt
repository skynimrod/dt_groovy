. 参见:

       http://www.w3.org/TR/2014/REC-html5-20141028/dom.html#the-id-attribute

. Global Attribute

  全局属性可以指定到所有的HTML 元素中去.

  accesskey

   class

   contenteditable

   dir

   hidden

   id

   lang

   spellcheck

   style

   tabindex

   title

   translate

. 1. id 属性

     指定元素的唯一性.  必须是唯一的。 

. 2. title 属性

     类似于tooltip . 用来提示

. 3. lang 和 xml:lang 属性

   
. 4. translate 属性

     枚举属性. yes 和 no, 如果为空则为yes.  还有个状态 是 继承状态。。。。

     下面的属性是可以传递(translatable)的属性

     th 元素 的 abbr 属性

     area, ima, 和 input 元素的alt 属性

     meta 元素的content 属性. 如果name 属性指定了 metadata 名字， 则可传递

     a 和 area 元素的 download 属性

     optgroup, option 和 track 元素的label  属性

     HTML元素的 lang 属性. 必须能传递匹配语言

     input 和 textarea 元素的 placeholder 属性

     iframe 元素的 srcdoc 属性, 必须可被解析 并且 能递归处理

     HTML 元素的 style 属性， 必须可解析 并且能递归处理

     所有HTML元素的title 属性

     input 属性的value 属性。

. 5. xml:base 属性(仅对 XML) 

     在XML 中的定义

. 6. dir 属性

     枚举属性. 指定元素的 text directionality. 文本对齐方式

     ltr 关键字: ltr 状态

          left-to-right 对齐。   从左往右对齐   

     rtl :  right-to-left      从右往左对齐

     auto : 

     下面的属性是可对齐(directionality-capable)的属性:

         th 元素的 abbr 属性

         area, img, input 元素的 alt 属性

         meta 元素的content 属性

         optgroup, option, track 元素的label 属性

         input, textarea 元素的 placeholder 属性

         所有HTML元素的 title 属性

. 7. class 属性

. 8. style 属性

. 9. data-*属性   嵌入式的对用户不可见

     ？？

. 10.  

. 下面是事件句柄属性， 可以指定到任何一个HTML 元素中

  1. 

     