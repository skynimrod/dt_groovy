. �μ�:

      http://grails-plugins.github.io/grails-resources/

.�������ֹ���

   1. ȷ�� JQuery ����Ѿ���װ

     grails install-plugin jquery*

   2. ��װJquery UI ��  Blueprint ���

     grails install-plugin jquery-ui
     grails install-plugin blueprint

  3. ��ʾ�Ѱ�װ�Ĳ��
  
     ��Grails ��ʼ�� ��װ�������ͨ���������ˣ� ���Բ鿴�Ѿ���װ�Ĳ�����Բ鿴 BuildConfig.groovy �ļ���������֪��

     ���������1��2 ����Ҳ�ʹ��ˡ�

     ��װ�������:


     Example:
     grails.project.dependency.resolution = {
          ...
          plugins {
               compile ":jquery:1.11.1"
          }
     }

. �μ�:

  http://grails-plugins.github.io/grails-resources/

.  �������ṩ��Grails ����Դ��ܣ� Resources ��ܴ�����������:

  1. Web Ӧ�� ���ܵ������� (Web application performance tuning is difficult)

  2. ���� ��Դ������˳�� �ر�����Щ������������Դ��( Correct load order for resources that depend on others)

  3. �ӳٰ���JavaScript �ű�ֱ���ļ���β(Deferring inclusion of JavaScript to the end of the document)

  4. Gails�����¶��̬��Դ��һ�ֱ�׼��ʽ����Ҫ(The need for standard way to for Grails plugins to expose static resources)

  5. �Ż���Դ����չ������Ƶ���Ҫ( The need for an extensible processing chain to optimize resources)

  6. ��ֹ��ΰ���ͬ������Դ( Preventing inclusion of the same resource multiple times)

  7. �����Ͳ�Ʒ���׶� ������Ϊ����Ҫ(The need for identical behaviour in development and production)

  Resources ����ܴ����ЩĿ�꣬ ��Ҫ��ͨ���µĹ������Լ�ͨ���������˵ı����ļ�ϵͳ������Դ����.

  