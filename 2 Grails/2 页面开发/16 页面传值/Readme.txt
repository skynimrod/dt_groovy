. 参见：

     http://baike.baidu.com/link?url=W5w_gZdOhNSxVO5qWEvEEPkkmNdCa7HEySCg7BoSWA7b1HNoAhOD_peSgLBikMDLKOmHf2i6swxGQHN5LtKvna


    http://zhidao.baidu.com/question/7109038.html?qbl=relate_question_0&word=%D2%B3%C3%E6%B4%AB%D6%B5
. 
 方法一：隐藏域
<input type="hidden" name="name" value="ABCD"> 
rquest.getParamenter("name"); 
方法二：将参数保存于请求
request.setAttribute("myname",ppg);// ppg是变量;
request.getAttribute("myname"); 
方法三：session
session.setAttribute("name",ppg);  //ppg变量; 
session.getAttribute("name"); 
方法四：超级链接
<a href ="hello.jsp?name=zhangsan&pass=123"> 