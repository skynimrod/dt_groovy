. Groovy ������� shell ����, �򿪺�, ������ R ����һ������ִ��.

. ������������: (���� windows ִ��: windows + R)

  > groovysh

  �ͻ�����groovy �� shell ����

. �����Eclipse �����Groovy Plugin �����е���. 

. ��Eclipse for JEE �д���Groovy Project �����п������ԵĲ���:

  1. New Project

     ѡ�� Groovy Project. 

     �����Ŀ���ֺ�, ѡ��JRE �汾, �Լ��Ƿ���ҪworkSpace. �ȵ�.

     ������ɺ�, ����Eclipse ����û��.... ��ʵ�Ѿ���������, ������װ��Eclipse ��ʵ�ǻ�ӭ����, ��� EE ͼ��(��ӭҳ�����Ͻǵģ� �������ȥ����ʾ)�� ����ʾ�� ��ǰ�������������Ŀ.

  2. Groovy ����Ŀ�Զ� �����Groovy Libraries ��������jar (jar�����Ƕ�Ӧ�ľ���·��)

     groovy-all-2.1.8.jar

     servlet-api-2.4.jar

     ivy-2.2.0.jar

     ivy-2.2.0-sources.jar

     bsf-2.4.0.jar

  3. Groovy ����Ŀ �Զ������ DSL ֧�� (Groovy DSL Support)   
   
     global_dsld-support -  c:\Documents and Setting\Administrator\.groovy\greclipse

     plugin_dsld_support - E:\1 RunEnv\1.1 Java\eclipse-jee-kepler-SR2-wine32\eclipse\plugins\org.codehaus.groovy_2.1.8xx-201405300180-e43j8\

  4. Ȼ��new һ��groovy class �����в���.

    �μ�:

        wiki-snapshot.pdf   -----> Groovy ��װ���Դ����ĵ�

        http://blog.csdn.net/kmyhy/article/details/4200563

    �����src �����ٽ�2����Ŀ¼  .\java �� .\groovy��  �ֱ����ڴ洢 java Դ�ļ��� groovyԴ�ļ�

     a. ��� groovy ����

        ����Ŀ ���һ� Groovy -> Add Groovy Nature, ����������Ŀ����� Groovy Libraries��

     b. ��� Groovy ��

         ����Ŀ Groovy Դ�ļ��� �Ҽ� -> New -> Other -> Groovy -> Groovy Class

         ������Ϊ HelloWorld �� �Զ����ɵĴ������£�

package Groovy

class HelloWorld {
	

}


        ���:

    	public static void main(def args) {
		println "hello  World!!!";
	}


       ���ڲ�������:

           ��Դ�ļ����Ҽ���Run As -> Groovy Script���ڿ���̨�в鿴���н���� ���ѡ�� Run As -> Groovy Console  ��ᵯ�� Groovy ��Console ����.   �ô�����Ҳ�������е��� Groovy ��.

. groovy �ļ�����������������ֱ��ִ��. 

  c:\>groovy helloworld.groovy

. groovy �ļ�����ֱ�������, ϵͳ���Զ�������ִ��. ����: helloworld.groovy

. groovy �ļ������main() ��ʽ��java ����, ���� ������def args .  ������ִ�е�ʱ�����ִ��main()

  ����:  $ groovy helloworld1.groovy

. ����ִ�ж��groovy �ļ�������ֻ��ִ�е�һ����main()�� �ڶ���main() �Ͳ��ᱻִ��.

   ## ������, ����ִ��2��groovy �ļ�. .....-----------

  ����, groovy ��Ҫ�� �ļ����Ʊ�������������ͬ.  ����:

     helloworld1.groovy ������� ����Ϊ HelloWorldtest  , ������Ȼ����ִ��(�μ� .\0 helloworld\��Ŀ¼�����run.bat)

. һ��groovy �ļ���, ����ж��class, ��ô��main()�������������ڵ�һ��. ����һ���ļ���ֻ����һ��main(). 

    