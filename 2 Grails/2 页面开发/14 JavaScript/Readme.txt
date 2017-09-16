<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
        <script>
            
            function firstChange(obj) {
                
                alert( obj.name ); alert( obj.value);
                //console.log($(obj).val().length); //打印输入框字符长度
                var smObj = document.getElementsByName("stockcode");
                alert( smObj.length ); 
                //var sObj = document.getElementById("stockcode1");
                var sObj = document.getElementsByName("stockcode");
                alert(sObj.length); //alert( sObj.name);
                
                for ( var i = 0; i <sObj.length; i ++ ) {
                    alert(sObj[i].id)
                    sObj[i].hidden = !sObj[i].hidden;
                }
            }
            
            // 可以调用后台方法来验证输入内容是否正确， 比如密码等，用get/post 来处理
            function ifProcessedChange(obj) {
                alert("maybe processed!")
            }
        </script>
        <script language="javascript" type="text/javascript">
            function bigChange(obj) {
                alert("big")
                if (obj.checked == false) {
                    var smObj = document.getElementsByName("smallclassauthorize");
                    for (var i = 0; i < smObj.length; i++)
                        smObj[i].checked = false;
                }
            }
            function smallChange(obj) {
                alert("small")
                var smObj = document.getElementsByName("smallclassauthorize");
                
                alert( smObj.length );
                var bigObj = document.getElementById("bigclassauthorize");
            
                if (obj.checked == true)
                    bigObj.checked = true;
                else {
                    b = true;
                
                for (var i = 0; i < smObj.length; i++) {
                    if (smObj[i].checked == true)
                        b = false;
                }
                
                if (b == true)
                    bigObj.checked = false;
                }
            }
        </script> 
    </head>
    <body>
        
        <g:form name="myForm" url="[action:'reportProc',controller:'Homepage']">
            <label>${message(code:'smms.reportProc.search.dateLabel')}</label>
            <g:datePicker name="myDate" value="${new Date()}" precision="day"  relativeYears="[-2..7]"/>
            <input name="searchButton" type="submit" value="${message(code:'smms.reportProc.search.button1')}" />
            <br />
            
            <input name="checkBox1" id="checkbox1" type="checkbox" onclick="firstChange(this)" value="${true}"/>
            <label>${message(code:'smms.reportProc.search.checkbox1')}</label>
            <g:checkBox name="checkBox2" value="${true}" />
            <label>${message(code:'smms.reportProc.search.checkbox2')}</label>
            <g:checkBox name="checkBox3" value="${true}" />
            <label>${message(code:'smms.reportProc.search.checkbox3')}</label>
            <g:checkBox name="checkBox4" value="${true}" onclick="firstChange(this)" />
            <label>${message(code:'smms.reportProc.search.checkbox4')}</label>
            <input name="checkBox4" id="checkbox5" type="checkbox" onclick="ifProcessedChange(this)" value="${false}"/>
            <label>${message(code:'smms.reportProc.search.checkbox5')}</label>
            
            <br />

            <label id="stockcode1" name="stockcode">${message(code:'smms.reportProc.search.textfield1')}</label>
            <input id="stockcode2" type="text" name="stockcode" size="6"/> <br />

            <label>${message(code:'smms.reportProc.search.keysList')}</label>
            <g:currencySelect name="keysList" from="${index?.reportkeys}" /> <br />
            <input name="bigclassauthorize" id="bigclassauthorize" type="checkbox" onclick="bigChange(this)"/>big
            <div class="aaa">
            <input name="smallclassauthorize" type="checkbox" onclick="smallChange(this)" value="${false}"/>small1<br />
            <input name="smallclassauthorize" type="checkbox" onclick="smallChange(this)" value="${false}"/>small2<br />
            <input name="smallclassauthorize" type="checkbox" onclick="smallChange(this)" value="${false}"/>small3
            </div>

            
            <g:actionSubmit value="${message(code:'smms.reportListProc.label.date')}" action="reportProc" />
            <g:actionSubmit value="Delete" />
            <g:actionSubmit value="DeleteAll" onclick="return confirm('Are you sure???')" />      
        </g:form>
    </body>
</html>

. 关于目录结构

        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>

  上面这句中的src ， 实际对应的是 http://localhost:8080/SMMS/js/jquery-1.11.3.js  

   实际上， 这个js 位置在于  http://localhost:8080/SMMS/js/jquery-1.11.3.js  , 对应的物理路径(开发路径)为:

        ./SMMS/web-app/js/jquery-1.11.3.js

  注意， SMMS 大小写必须与开发设计一致， 否则会出现访问不到的情况，即找不到对应js文件， 当夜也就不会正常执行相应的功能了.



