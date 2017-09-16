.  def date = new Date()

   上面可以获取到时间对象

. 1. 获取日历形式的日期， 类似:   日期2015-07-12T06:17:40.140+0800

   println "日期:" + date.calendarDate

. 2. 获取 单个年，月，日

   println "日期" + date.year + "-" + date.month + "-" + date.date

   日期115-6-12
   
   所以， 得到的year 需要+ 1900 才是正确的年, 得到的月 需要 +1 才是正确的月,  得到日期 用date 而不是day.

. 3. 获取单个 日 分 秒

   println  "时间“ + date.hours + ":" + date.minutes + ":" + date.seconds 

   需要注意的是， 这儿获取的时间是本机的时间， 即如果本机时间不准确， 可能会造成获取的时间也不准确.

. 4. 格式化日期字符串

   println "格式化" + date.format("YYYY-MM-DD")

   格式化2015-07-193   ， 输出的日期不对。 原因是 这儿不能用大写的DD, 大写的DD 是指年中的天数， 用小写的dd, 则表示月中的天数.

   println "格式化" + date.format("YYYY-MM-dd")

   字母	日期或时间元素	表示	示例
G	Era 标志符	Text	AD
y	年	Year	1996; 96
M	年中的月份	Month	July; Jul; 07
w	年中的周数	Number	27
W	月份中的周数	Number	2
D	年中的天数	Number	189
d	月份中的天数	Number	10
F	月份中的星期	Number	2
E	星期中的天数	Text	Tuesday; Tue
a	Am/pm 标记	Text	PM
H	一天中的小时数（0-23）	Number	0
k	一天中的小时数（1-24）	Number	24
K	am/pm 中的小时数（0-11）	Number	0
h	am/pm 中的小时数（1-12）	Number	12
m	小时中的分钟数	Number	30
s	分钟中的秒数	Number	55
S	毫秒数	Number	978
z	时区	General time zone	Pacific Standard Time; PST; GMT-08:00
Z	时区	RFC 822 time zone	-0800