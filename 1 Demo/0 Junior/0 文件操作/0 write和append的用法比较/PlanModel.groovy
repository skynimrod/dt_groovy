/**
 *   ���� �ƻ��ļ�ģ��, ���ڽ��в���. 
 */
package Groovy

/**
 * @author Administrator
 *
 */
class PlanModel {
	public static void main( def args ) {
		
		def date, week, weather, ColHead, suffix
		def planFile
		
		
		date = "2014.06.27"
		week = "������"
		weather = "����ת��"
		
		ColHead = date + "   " + week + "   " + weather
		
		
		suffix = ". \r\n\r\n"
		
		println date
		println week
		println weather
		println ColHead
		
		
		// д��ͷ
		planFile = new File(date+".txt")
		
		planFile.write( ColHead + suffix )
		
		// д�ƻ����
		10.times{ i ->
			planFile.append( "  " + (i+1) + suffix )
		}
		
		println planFile.path
		
		
		
		
	}

}
