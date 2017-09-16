把解压所得 js 文件拷贝到 web-app\js\jquery 目录。
将 css 文件拷贝到 web-app\css 目录。
因为 Grails 采用 siteMesh( 见参考资源 ) 作为页面底层布局框架，所以可以通过修改项目的 MyCalendar\grails-app\views\layouts\main.gsp 文件将 jQuery 引用到各个页面中。

<g:javascript src="jquery/jquery-1.3.2.min.js" /> 
    <g:javascript src="jquery/fullcalendar.min.js" /> 
 <g:javascript src="jquery/jquery.ui.core.js" /> 
    <g:javascript src="jquery/jquery.ui.draggable.js" /> 
    <g:javascript src="jquery/qtip-1.0.0-rc3.min.js" /> 
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'fullcalendar.css')}" /> 