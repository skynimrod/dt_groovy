. �μ�:

      http://www.360doc.com/content/12/1127/07/820209_250456233.shtml

      http://tool.oschina.net/regex    ���߲��� ������ʽ ����վ

. �� /../ ����������ʽ

  Groovy ��ʹ�� slashy(б��)�﷨"//" ����������ʽ, ���ڳ����ڱ��ʽ�������ַ�, ���Զ�����ת��. ����

      def name = "Ted Naleid"

      assert ( /$name/ == "TedNaleid" )
      assert (/$name/ == "$name")

      assert( /Count is \d == "Count is \\d" )

. ������

  ��: �����ַ���֮ǰ, �ҽ��ַ��������Pattern. ����:

       def  shoutedWord = ~/\b[A-Z]+\b/

  =~: ����������ߵ��ַ������ұߵ�Pattern ���оֲ�ƥ��, ����ֵΪMatcher. �磺

     def matcher = ("finda" = ~/find/ )

     assert "find"=matcher[0]

  ==~: �÷��� =~ ���ƣ� ֻ��������еľ�ȷƥ��, ����ߵ������ַ������ұߵ�ģʽ����ƥ��, ==~�Ľ���� Matcher.matches() �Ľ����һ����. ����ֵΪBoolean. �磺

      def matcher = ( "finda" ==~ /find/ )

      assert java.lang.Boolean == matcher.getClass()

. ���ַ����ĸĽ�

   1. replaceFirst:  ������������ʽ�ĵ�һ���ַ��������滻, ���磺