. �μ�:

       wiki-snapshot.pdf->1.2.3.7

       http://www.groovy-lang.org/syntax.html#all-strings    �ٷ������ĵ�

      http://www.ibm.com/developerworks/cn/java/j-pg10255.html

. 1. Groovy �е��ַ�������ʹ��˫����"�͵�����'�� �ǳ�����. 

  println "he said 'cheese' once"

  println 'he said "cheese" again'

. 2. �����ַ���

  def  text = """\
  hello  there ${name}
  how are you today?
  """

. 3. slashy String literals   ������ʽ���ַ���

  def  s = /.*foo.*/

  def dirname = /^.*\//

  def basename = /[Strings and GString^\/]+$/

. 4.

  def noParam = { -> println "I'm executed";
  return "no param"}

  def oneParam = { out -> println "Executed with a ${out.class}
  parameter"; out << "one param"}

  def printSum = {a, b -> print a+b }

  printSum(5+7)

  // prints "12"

. 5. �����ַ����е��ַ�������

          def content = 'var szzbAffiches=[["000707","finalpage/2014-09-12/1200226442.PDF","˫���Ƽ��������ٿ���˾2014����Ĵ���ʱ�ɶ�������ʾ�Թ���","PDF","250","2014-09-12","2014-09-12 00:00"],["000402","finalpage/2014-09-12/1200226440.PDF","�� �� �֣����ڻع��ɷ�������ǰʮ���ɶ��ֹ���Ϣ�Ĺ���","PDF","88","2014-09-12","2014-09-12 00:00"]]'
        for ( def i = 0; i < content.length(); i ++ ) {
            if ( content[i] == '[') {
                println "Yes , i find ["
                println content.substring(i,content.length())

                println content[0] + content[1] + content[2]
                break
            }
        }

. 6. �ַ����Ƚ�

  def a = "hello"
  def b = "hello"

  println a == b ? "-)" : "-("

. 7. �ж��ַ����Ƿ�Ϊ��

    
. 8. ɾ���ַ����еĿո�

     ɾ��ͷβ�Ŀո�: trim() 

     def s = "  a c d  "
     println s.trim()
 
       
. 9. ����ַ���

     def keys = keysList.split(",")
        for ( item in keys )  {
            println item
            item = item.replaceALL(/(^s*)|(s*$)/g,"")

            println item
        }

    ���� 

        def keys = keysList.tokenize(",")
        for ( item in keys )  {
            println item
            //item = item.replaceALL(/(^s*)|(s*$)/g,"")
            //println item
        }

    ��2�з���Ч��һ���� ������һ�ֺ���Ч�ʸ��ߵ㡣

. 10. �ж��ַ��������Ƿ�ȫ������ (��չ�� �ж��ַ��������Ƿ����ָ����ʽ)

    def f = ! (year ==~ /[\d]{4}/)

    ʹ��������ʽ�������ж��Ƿ�ƥ��

. 11. �������ַ���ת��Ϊ����

     def ab = "123"
     def bb = ab.parseInteger()			----��  �������ȷ�� û���������
     def bc = Integer.parseInt( ab )

. 12. ��ʽ���ַ���

     String.format("%04d-12-30", curyear )

     println String.format("-----%d---", k )    // ����println ʵ�ָ�ʽ�����һ�ַ���, Ӧ���� Integer.parseInt()


. 13. �ַ����Ӽ�

    println "1999"-1       // ������Ϊ999

    println "1999"+1       // ������Ϊ 19991

    println "1999"-9       // ������Ϊ 199

. 14. ��������ת�ַ���

    1.toString()

   println leapmap[1.toString()]

. 15. ȡ�ַ������Ӵ�

        def DateStr = "2014-11-23"
        println DateStr.substring(0,4)                   // ��һ�������ǿ�ʼ�±꣬ ��һ�������ǽ����±꣬����������±�����
        def year = datestr.substring(0,4) 
        def month = datestr.substring(5,7)
        def day = datestr.substring(8,10)

        println DateStr[0..3]				// ���ǵڶ���ȡ�Ӵ��ķ�ʽ
            year = Integer.parseInt( DateStr[0..3] )
            month = Integer.parseInt( DateStr[5..6] )
            day = Integer.parseInt( DateStr[8..9] )

. 16. �ж��ַ������Ƿ���Ŀ���Ӵ�  indexOf()

                if ( temp.indexOf( "startxref" ) != -1 ) {  // ������-1 ��ʾ�ҵ���startxref
                    temp = rd.readLine()
                    println "λ��:" + temp
                    xrefpos = Integer.parseInt( temp )
                    println xrefpos
                    break
                } 

. 17. ʮ�������ַ���ת��Ϊ����

     def  str = "0x0137"
     def  desnum = Integer.parseInt( str.substring(2,6), 16 )     // ��Ҫע�����ת����ʱ���ܰ���0x

. 18. ����ת��Ϊʮ�������ַ���

      Integer.toHexString(n).toUpperCase()

      ����2: 

            	def n = 311
        
        	println String.format("%04x", n )       // ��������� 0137, ����0x�ģ� 
							//�����д��X, ��������01A8, �����Сд��x, ��������01a8