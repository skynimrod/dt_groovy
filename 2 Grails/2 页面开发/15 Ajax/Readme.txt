. XMLHttpRequest ���� �� AJAX�Ļ���

  ���е��ִ��������֧��  XMLHttpRequest ����( IE5 �� IE6 ʹ�� ActiveXObject)

  XMLHttpRequest �����ں�̨���������������. ����ζ�� �����ڲ����¼���������ҳ������£� ����ҳ��ĳ���ֽ��и���.

. ���� XMLHttpRequest ����

  �����ִ��������IE7+��Firefox��Chrome��Safari �Լ� Opera�����ڽ� XMLHttpRequest ����
  ���� XMLHttpRequest ������﷨��

  variable=new XMLHttpRequest();

  �ϰ汾�� Internet Explorer ��IE5 �� IE6��ʹ�� ActiveX ����

  variable=new ActiveXObject("Microsoft.XMLHTTP");

  Ϊ��Ӧ�����е��ִ������������ IE5 �� IE6������������Ƿ�֧�� XMLHttpRequest �������֧�֣��򴴽� XMLHttpRequest ���������֧�֣��򴴽� ActiveXObject ��

  var xmlhttp;
  if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
  }
  else
  {// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }

. XMLHttpRequest �������ںͷ�������������

  1. ���������������

     ���轫�����͵��������� ����ʹ�� XMLHttpRequest ����� open() �� send() ����:

     xmlhttp.open("GET", "test1.txt", true)
     xmlhttp.send();

     ����:

     open( method, url, async)
 
          �涨��������͡�url�Լ��Ƿ��첽��������.

          method : ���������; GET �� POST

          url : �ļ��ڷ������ϵ�λ��

          async: true(�첽) �� false (ͬ��)

    send(string)  

          �������͵�������

          string: ������post ����

   
  GET ���� POST��

  �� POST ��ȣ�GET ����Ҳ���죬�����ڴ󲿷�����¶����á�
 
  Ȼ��������������У���ʹ�� POST ����

    �޷�ʹ�û����ļ������·������ϵ��ļ������ݿ⣩
    ����������ʹ������ݣ�POST û�����������ƣ�
    ���Ͱ���δ֪�ַ����û�����ʱ��POST �� GET ���ȶ�Ҳ���ɿ�


  2. 
