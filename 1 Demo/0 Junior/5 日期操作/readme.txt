.  def date = new Date()

   ������Ի�ȡ��ʱ�����

. 1. ��ȡ������ʽ�����ڣ� ����:   ����2015-07-12T06:17:40.140+0800

   println "����:" + date.calendarDate

. 2. ��ȡ �����꣬�£���

   println "����" + date.year + "-" + date.month + "-" + date.date

   ����115-6-12
   
   ���ԣ� �õ���year ��Ҫ+ 1900 ������ȷ����, �õ����� ��Ҫ +1 ������ȷ����,  �õ����� ��date ������day.

. 3. ��ȡ���� �� �� ��

   println  "ʱ�䡰 + date.hours + ":" + date.minutes + ":" + date.seconds 

   ��Ҫע����ǣ� �����ȡ��ʱ���Ǳ�����ʱ�䣬 ���������ʱ�䲻׼ȷ�� ���ܻ���ɻ�ȡ��ʱ��Ҳ��׼ȷ.

. 4. ��ʽ�������ַ���

   println "��ʽ��" + date.format("YYYY-MM-DD")

   ��ʽ��2015-07-193   �� ��������ڲ��ԡ� ԭ���� ��������ô�д��DD, ��д��DD ��ָ���е������� ��Сд��dd, ���ʾ���е�����.

   println "��ʽ��" + date.format("YYYY-MM-dd")

   ��ĸ	���ڻ�ʱ��Ԫ��	��ʾ	ʾ��
G	Era ��־��	Text	AD
y	��	Year	1996; 96
M	���е��·�	Month	July; Jul; 07
w	���е�����	Number	27
W	�·��е�����	Number	2
D	���е�����	Number	189
d	�·��е�����	Number	10
F	�·��е�����	Number	2
E	�����е�����	Text	Tuesday; Tue
a	Am/pm ���	Text	PM
H	һ���е�Сʱ����0-23��	Number	0
k	һ���е�Сʱ����1-24��	Number	24
K	am/pm �е�Сʱ����0-11��	Number	0
h	am/pm �е�Сʱ����1-12��	Number	12
m	Сʱ�еķ�����	Number	30
s	�����е�����	Number	55
S	������	Number	978
z	ʱ��	General time zone	Pacific Standard Time; PST; GMT-08:00
Z	ʱ��	RFC 822 time zone	-0800