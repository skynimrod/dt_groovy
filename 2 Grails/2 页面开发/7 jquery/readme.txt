�μ�:

     jquery.com                    ����

     http://www.jquery123.com/     �ǳ��õ�jquery  ������ѧϰ��վ(BootStrap �ṩ��)

. $(function(){ }  ����jquery���,�ǵ��ĵ�������Ͼ�ִ��,����˼.

. ѧϰJQuery �ĵ�һ������: �������Ҫһ���¼����������ҳ����, �������$(document).ready()���������¼���  ���а�����$(document).ready() �����Ԫ�� �� �¼� �������� DOM ��ɼ���֮���������أ�������ҳ�����ݼ���֮ǰ��
  �����������:

  $(document).ready(function() {
     // put all your jQuery goodness in here.
  }); 



  �кܶ෽������ȷ���¼���ҳ������������, $(document).ready() ����������Ҫ�������ơ� ���ȣ� �㲻����HTML �Ϸ����κΡ���Ϊ�Եġ���ǡ�����, ����Խ�javaScript/jquery д��һ��������js �ļ�, ����������ά���� �ֱ�֤��js��ҳ�����ݵĸ���. ������������ҳʱ����ϸ�ģ� ��ͻᾭ������������������㽫�����ͣ��һ������ʱ�� ��ʱ״̬���� ����ʾ��javascript:void()����������Ϣ�� ��������һ���¼�ֱ�ӷ���<a href> ��ǩ������ɵ�.

  ��һЩʹ��traditional JavaScript ��ҳ�棬 �����<body>��ǩ�￴��"onload"���ԡ� ��ᵼ��һ������: ���޶�����body ��ֻ����һ�������¼��� �ǵģ� ��Ϊ��������������ӵġ���Ϊ�Եġ���ǩ�� ���������������⣬ ��ο� Jeremy Keith ����: DOM Scripting, ���潲���������һ��������js�ļ��ﴴ��һ��"addLoadEvent"����, ������������������body �ﱻ����. �������ַ�����ҪΪ�����ܼ򵥵������д�൱�����Ĵ���, ���⣬ ���ַ������ڼ���window ʱ������Щ�¼���, �ⲻ�ò�������һ������$(document).ready() �ĺô�. 

  ʹ��$(document).ready(), ����������¼���window ����֮ǰ���� �򴥷�. ������д�������������Ķ�׼���������ʱ�̼��ػ򴥷��� Ҳ����˵��һ��DOM ���������ע���, $(document).ready()�Ĵ���Ϳ�ʼִ��.  ����, �û��ڵ�һ�ۿ���ҳ��Ԫ��ʱ, ��Ч�Ϳ��������ˡ�

. ���ӣ�

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
                        var txt1="<p>Text.</p>";              // �� HTML ������Ԫ��
                        var txt2=$("<p></p>").text("Text.");  // �� jQuery ������Ԫ��
                        var txt3=document.createElement("p");
                        txt3.innerHTML="Text.";               // ͨ�� DOM �������ı�
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

  ˵���� 

      ��������� ���alert("here is top of the page!")  �ܱ�ִ�У� ˵��ǰ��Ľű�û���⣬ ����˵���ű��д���

      ʵ�ʲ��Թ����У� ���´���������⣺

   �����2���������������ã�һ��������Javascript �п��Է��ʲ��޸ĵ�gNumber�� һ���� Jquery �ű����涨���pagenumber, Ҳ������ÿ��ѡ�����¼��ж�̬���ʲ��޸�
  
   ����jquery �еļ������� ������script ���޸���Ч�� ���ڳ����������ˡ� 

. JQuery ����η��� Grails ��̨���ݹ����Ľ����������

  ���ʵ���������û�����⣬ ���Ƿ��ʽ�����ķ�ʽ������

  ʵ������JavaScript ���ʶ�����������⡣����������

  �Ѿ������ �μ�����̨��ǰ�˴��ݲ�����

. ��Ⱦ��ʱ�� ������ִ��jquery��ready() ������ ��ô����Ĳ������Ҳ�ᱻִ�У� ���ǰ󶨵��¼�����Ҫ��ز�����Żᱻִ�С�