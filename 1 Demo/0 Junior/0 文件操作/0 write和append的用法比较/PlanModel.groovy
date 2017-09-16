/**
 *   创建 计划文件模板, 便于进行操作. 
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
		week = "星期五"
		weather = "多云转晴"
		
		ColHead = date + "   " + week + "   " + weather
		
		
		suffix = ". \r\n\r\n"
		
		println date
		println week
		println weather
		println ColHead
		
		
		// 写栏头
		planFile = new File(date+".txt")
		
		planFile.write( ColHead + suffix )
		
		// 写计划序号
		10.times{ i ->
			planFile.append( "  " + (i+1) + suffix )
		}
		
		println planFile.path
		
		
		
		
	}

}
