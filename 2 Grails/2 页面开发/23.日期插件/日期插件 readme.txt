. 参见:

       http://www.cninfo.com.cn/cninfo-new/js/daterangepicker.jQuery.js
 
       http://www.cninfo.com.cn/cninfo-new/css/ui.daterangepicker.css

       Moment.js           JavaScript 日期处理类库

       common.js   不知道需不需要

       http://blog.csdn.net/classicbear/article/details/7533890    一个应用例子

. 部署

  在NetBeans 开发环境中，

  1. 将上面的js 文件拷贝到 "Web应用程序/js/"  目录下面.  对应的实际目录是: ./smms/web-app/js 

  2. 将ui.daterangepicker.css  拷贝到 "Web应用程序/css/"  目录下面.  对应的实际目录是: ./smms/web-app/css 

(document).ready

/*
                $('#rangeA').daterangepicker({
			datepickerOptions : {
				changeMonth : true,
				changeYear : true
			},
		});
                */

        <link rel="stylesheet" href="../css/ui.daterangepicker.css" type="text/css" />
        <link rel="stylesheet" href="../css/jquery-ui-1.7.1.custom.css" type="text/css" />
        
        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>
        <script language="javascript" type="text/javascript" src="../js/daterangepicker.jQuery.js" />
        <script language="javascript" type="text/javascript" src="../js/moment.min.js" />
        <script language="javascript" type="text/javascript" src="../js/common.js" />
        <script langugae="javascript" type="text/javascript" src="../js/jquery-ui-1.7.1.custom.min.js" />


上面的某个js可能有问题. 
. 使用说明

 
  1. 在目标页面<head>中增加下面的2 行代码来引入 daterangepicker 插件


        <link rel="stylesheet" href="../css/ui.daterangepicker.css" type="text/css" />
        
        <script language="javascript" type="text/javascript" src="../js/daterangepicker.jQuery.js" />

     注意， 由于 daterangepicker 插件需要使用jquery , 所以应该也要把jquery.js  引用， 如下:

        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>


  2. 