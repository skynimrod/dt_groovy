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
                //console.log($(obj).val().length); //��ӡ������ַ�����
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
            
            // ���Ե��ú�̨��������֤���������Ƿ���ȷ�� ��������ȣ���get/post ������
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

. ����Ŀ¼�ṹ

        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>

  ��������е�src �� ʵ�ʶ�Ӧ���� http://localhost:8080/SMMS/js/jquery-1.11.3.js  

   ʵ���ϣ� ���js λ������  http://localhost:8080/SMMS/js/jquery-1.11.3.js  , ��Ӧ������·��(����·��)Ϊ:

        ./SMMS/web-app/js/jquery-1.11.3.js

  ע�⣬ SMMS ��Сд�����뿪�����һ�£� �������ַ��ʲ�������������Ҳ�����Ӧjs�ļ��� ��ҹҲ�Ͳ�������ִ����Ӧ�Ĺ�����.



