�μ�:

     http://blog.csdn.net/hongweigg/article/details/45223297

. Groovy �е��� R���� �����Ͼ��� JAVA����R���� 

. 1. ��R�����ء�Rserve����������װ

    ��װR ���Ի����� �����䰲װ Rserve ����  Ȼ������ Rserve��

  > library(Rserve)

> Rserve()
 

Starting Rserve...

 "D:\PROGRA~1\R\R-30~1.1\library\Rserve\libs\i386\Rserve.exe" 

> 

. 2. ����java���̣������Ҫ�İ���

package com.rTest;

 

import org.rosuda.REngine.REXP;

import org.rosuda.REngine.Rserve.RConnection;

 

public class Test {

    public static void main(String[] args) {

       try {

           RConnection c = new RConnection();

           REXP x = c.eval("R.version.string");

           System.out.println(x.asString());

       } catch (Exception e) {

            e.printStackTrace();

       }

    }

}


. 3. FAQ

2.3     ���ܳ��ֵĴ���
2.3.1  Connection refused: connect

org.rosuda.REngine.Rserve.RserveException: Cannot connect: Connection refused: connect

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:88)

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:60)

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:44)

    at com.rTest.Test.main(Test.java:9)

 

�������ڡ�Rserve�� ������û������������ԭ��������R�������������

 

> library(Rserve)

> Rserve()

 