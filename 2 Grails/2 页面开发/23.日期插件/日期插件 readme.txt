. �μ�:

       http://www.cninfo.com.cn/cninfo-new/js/daterangepicker.jQuery.js
 
       http://www.cninfo.com.cn/cninfo-new/css/ui.daterangepicker.css

       Moment.js           JavaScript ���ڴ������

       common.js   ��֪���費��Ҫ

       http://blog.csdn.net/classicbear/article/details/7533890    һ��Ӧ������

. ����

  ��NetBeans ���������У�

  1. �������js �ļ������� "WebӦ�ó���/js/"  Ŀ¼����.  ��Ӧ��ʵ��Ŀ¼��: ./smms/web-app/js 

  2. ��ui.daterangepicker.css  ������ "WebӦ�ó���/css/"  Ŀ¼����.  ��Ӧ��ʵ��Ŀ¼��: ./smms/web-app/css 

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


�����ĳ��js����������. 
. ʹ��˵��

 
  1. ��Ŀ��ҳ��<head>�����������2 �д��������� daterangepicker ���


        <link rel="stylesheet" href="../css/ui.daterangepicker.css" type="text/css" />
        
        <script language="javascript" type="text/javascript" src="../js/daterangepicker.jQuery.js" />

     ע�⣬ ���� daterangepicker �����Ҫʹ��jquery , ����Ӧ��ҲҪ��jquery.js  ���ã� ����:

        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.3.js"></script>


  2. 