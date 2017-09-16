参见:

     http://blog.csdn.net/hongweigg/article/details/45223297

. Groovy 中调用 R语言 本质上就是 JAVA调用R语言 

. 1. 在R里下载“Rserve”包，并安装

    安装R 语言环境后， 再在其安装 Rserve 包，  然后启动 Rserve：

  > library(Rserve)

> Rserve()
 

Starting Rserve...

 "D:\PROGRA~1\R\R-30~1.1\library\Rserve\libs\i386\Rserve.exe" 

> 

. 2. 建立java工程，导入必要的包，

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

2.3     可能出现的错误
2.3.1  Connection refused: connect

org.rosuda.REngine.Rserve.RserveException: Cannot connect: Connection refused: connect

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:88)

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:60)

    at org.rosuda.REngine.Rserve.RConnection.<init>(RConnection.java:44)

    at com.rTest.Test.main(Test.java:9)

 

这是由于“Rserve” 服务器没有启动起来的原因，试试在R内运行如下语句

 

> library(Rserve)

> Rserve()

 