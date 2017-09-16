. i18n �� internationalization ����ĩ��ĸ i �� n , 18 Ϊ�м���ַ����� �ǹ��ʻ��ļ��. �ò�Ʒ(���������� Ӳ����) ����������ĸı������Ӧ��ͬ�����Ժ͵�������Ҫ.  ���ڳ������, �ڲ��޸��ڲ�����������, �ܸ��ݲ�ͬ���Լ�������ʾ��Ӧ�Ľ���. 

  ��ȫ�򻯵�ʱ��, ���ʻ���Ϊ��Ҫ, ��Ϊ��Ʒ��Ǳ���û�������������ĸ�������. ͨ���� i18n ��صĻ���L10n(���ػ��ļ��)


.i18n �� L10n �Ĺ�����֯�� Openi18n ��֯�� ��ǰ���� li18nux ��֯�� ��ԭ����ָ�� GNU/Linux���ɲ���ϵͳ�����ȫ�� ��׼�Ĺ��ʼƻ�, �������䵽GNU/Linux֮�����п���Դ����ļ�������, �������Ϊ Open Internationalization Initiative , �з�Ӫ����֯ Free Standard Group ������ ��Ϊ�����������֧��, ����GNU/Linux ϵͳ�ϵĶ���������ִ������ͻ����о����Ե�Ӱ��.  ������Դ���������֯ͨ�����и���"���ʻ�"��"���ػ�" �����ķ�֧����.

  i18n ��Ҫʹ�� gettext����� ʹ���ʵ�ֹ��ʻ�֧��. ��ʵ������һ���� i18n �������. ���ڿ�Դ�����У��ձ�ͨ�����������ļ�, Ȼ��ͨ��gettext�������ʵ�ֹ��ʻ���չ.

. Grails �� i18n ������Ǵ������̵�ʱ��ȱʡ��װ��.

  �μ�:

      http://www.kuqin.com/grails-doc-1.0/guide/10.%20Internationalization.html
 
      http://grails.github.io/grails-doc/2.4.2/guide/i18n.html

  Grailsͨ��Spring MVC���ṩ�Ĺ���֧�ֹ��ʻ���i18n������Grails��,����Ը����û���Locale�Զ���������ͼ�е��ı���Java����Locale��javadoc�������£�

    һ�� Locale ����������һ���ض�����ġ����εĺ��Ļ������Ի�����һ��Ҫ�� Locale ִ�е���������� ���Ի������е� ����ʹ�� Locale ��Ϊ�û��ü���Ϣ�����磬��ʾһ�����������Ի������еĲ���--����Ӧ�����û��Ĺ��ҡ��������Ļ��ķ���/��ͳ����ʽ���� 

Locale�������Դ��� �� ���Ҵ�����ɡ����磬"en_US"������Ӣ��������룬��"en_GB"����Ӣ��Ӣ� 

. 1. �����Ϣ��

  ��Ȼ���Ѿ�����Locales�ĸ��Ϊ����Grails���������ǣ������Ҫ������ϣ��չ�ֵĲ�ͬ���Ե���Ϣ�󶨡�Grails����Ϣ����һЩ�򵥵�Java�����ļ�,����λ��grails-app/i18nĿ¼�¡�

  ÿһ���󶨵�����ϰ���϶����� messages��ʼ��������locale������Grails�� grails-app/i18nĿ¼���Դ��˺ܶ಻ͬ���Ե���Ϣ�󶨡����磺

messages.properties
messages_de.properties
messages_es.properties
etc.

ȱʡ����£�Grails����messages.properties������Ϣ�������û�ָ�����Լ���locale����Ҳ���Դ������Լ�����Ϣ�󶨣�ֻ��Ҫ�򵥵ش�  ��һ�������ļ������ļ�Ҫ�������Ȥ��locale��β������ messages_en_GB.properties �������Ӣ��Ӣ� 

. 2. �ı�Locales

  ȱʡ����£��û���locale��ͨ��HTTP��Ϣͷ��header���е� Accept-Language�����ġ�������Ҳ���Լ򵥵���Grails����������д��� lang�������л��û��Ͽɵ�locale�����磺

/book/list?lang=es

  Grails���Զ����л����û���locale�����ҽ��䱣����cookie�У���˽�����������ʹ���µ���Ϣͷ�� 

. 3. ��ȡ��Ϣ

����ͼ�ж�ȡ��Ϣ

������Ҫ��Ϣ�ĵط�������ͼ�У�Ҫ����ͼ�ж�ȡ��Ϣ��ֻ��Ҫʹ��message��ǩ��

<g:message code="my.localized.content" />

ֻҪ����� messages.properties ����ȻҪ���ʵ���locale��׺��������Ӧ�Ĺؼ��֣���������ʾ����Grails���������в�����Ϣ��

my.localized.content=Hola, Me llamo John. Hoy es domingo.

ע�⣬��ʱ���������Ҫ����һЩ��������Ϣ������ message��ǩ��Ҳ�ǿ��������ģ����磺

<g:message code="my.localized.content" args="${ ['Juan', 'lunes'] }" />

�������Ϳ�������Ϣ��ʹ����Щλ�ò����ˣ�

my.localized.content=Hola, Me llamo {0}. Hoy es {1}.

�ڿ������ͱ�ǩ���ж�ȡ��Ϣ

��Ȼ������ڿ�����������÷���һ�����ñ�ǩ����Ҳ���Ժ����׵��ڿ������ڶ�ȡ��Ϣ��

def show = {
	def msg = message(code:"my.localized.content", args:['Juan', 'lunes'])
}

ͬ����Ҳ�����ڱ�ǩ����ʹ�ã�����Ҫע�⣺�����ı�ǩ���в�ͬ�������ռ䣬����Ҫ��һ��ǰ׺ g.��

def myTag = { attrs, body ->
	def msg = g.message(code:"my.localized.content", args:['Juan', 'lunes'])
}

. 4. ʵ�ʲ���

  �޸� grails-app/i18n/Ŀ¼�µ�message.properties �� ��Ӧ�����Ե�message�ļ�, ���� message_zh_CN.properties 

  ���ڹ���Ŀ¼�����ԣ���target/work.resources.grails-app.i18n/Ŀ¼�µ� message.properties �� ���������ļ�(���� ��Ӧ���ĵ���

     messages_zh_CN.properties)

  ��Ӷ�Ӧ��message ���塣

  ��gsp �У� Ҳ����Ƕ����JavaScript ��ֱ��ʹ��

  <g:message code="menu.gsp.popmenu.refresh" />

  �����Ĵ����������Ӧ���ı���Ϣ�� ����Ҳ��������������ʾ���⡣ 

  ***  ���Ե�ʱ�� �޸ĵ��ļ��� target\work\resources\grails-app\i18n Ŀ¼����ģ���Ϊ �ڹ����ļ��ṹ����ʾ��i18n �������Ŀ¼�����. 

  �������ˣ� ����ֱ���ڹ��̽ṹ�е� ��Ϣ����message packages�� ���޸Ķ�Ӧ����Ϣ����

  ��ʵ2��λ�õ�message ��������, ��������ʹ�õ��� grails-app/i18n/����ġ�

  ��Щ�ļ��ı��뷽ʽ���� ansi , ������Ϣ�е����� ��Ӣ�Ĳ��ֶ���ʹ�õ����룬 ���纺����  \u5237\u65b0\u6d4b\u8bd5 ��

. ����message �ķ��ʲ�����Բμ�:

   ..\2 ҳ�濪��\18 ��̨��ǰ̨���ݲ���

  ��Ҫ���漰 js �ж� i18n ��message �ķ���.

  �� gsp ����Ҫ���ʵ� i18n message ȫ����controller �з��ʺ��������ϣ���У� Ȼ��ͨ���������ݸ�gsp �� ���� gsp �е�js ���������ͷǳ�������. 

. ����ע��

  ע���� //

  ע��ֻ�ܵ���һ��

  ע�Ͳ��ܷ�����Ϣ��β�� ��Ȼ����Ϊ��Ϣ��ֵ��ȡ��

. 5. ��JavaScript �з���

   alert("${message(code:'smms.main.reportProc')}")
 
   Ҳ���õ�${}, ���ǩ��ʹ��һ����
  