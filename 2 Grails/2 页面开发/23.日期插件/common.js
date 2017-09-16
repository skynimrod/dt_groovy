//时间格式化
Date.prototype.format = function(format) {
	if (!format) {
		format = "yyyy-MM-dd HH:mm";
	}
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"H+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	};
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format.replace(" 00:00","");
};

function fomatDate(date, str) {
	return (new Date(date)).format(str);
}

function fomatcommonDate(date) {
	return date;
}

/**
 * 全角转半角
 */
function CtoH(vObj) { 
	var str=vObj;
	var result="";
	if (str == null || str == "") {
		return result;
	}
	for (var i = 0; i < str.length; i++) {
		if (str.charCodeAt(i)==12288) {
			result+= String.fromCharCode(str.charCodeAt(i)-12256);
			continue;
		}
		if (str.charCodeAt(i)>65280 && str.charCodeAt(i)<65375)
			result+= String.fromCharCode(str.charCodeAt(i)-65248);
		else
			result+= String.fromCharCode(str.charCodeAt(i));
	}
	return result;
}

/**
 * 字符处理 null
 */
function handleString(str){
	if(str  == null){
		return '';
	} else {
		return str;
	}
}

/**
 * 数据处理状态进度条
 * suffix 要写入的标签
 * msgType 加载的类型  0：数据正在加载，1：数据处理异常 刷新当前页面，2：空数据提示
 * @returns
 */
function dataLoadingProgress(suffix,msgType){
	$('#'+suffix).empty();
	var msg = '';
	if(msgType == 0){
		msg = '<div class="uc-os-more"><a><img src="../images/loading.gif" /> 正在加载中，请稍后...</a></div>';
	}else if(msgType == 1){
		msg = '<div class="tip-news"><a href="javascript:window.location.reload();">数据加载异常，请点击刷新重试。</a></div>';
	}else if(msgType == 2){
		msg = '<div class="tip-blank" text-align="center"><a>没有查询到数据！</a></div>';
	} 
	$('#'+suffix).append(msg);
}

/**
 * 深市
 */
var COMMON_SZ = "sz";
 /**
  * 深市主板
  */
var COMMON_SZMB = "szmb";
 /**
  * 深市中小板
  */
var COMMON_SZME = "szme";
 /**
  * 深市创业板
  */
var COMMON_SZCN = "szcn";	
/**
 * 沪市
 */
var COMMON_SH = "sh";
 /**
  * 沪市主板
  */
var COMMON_SHMB = "shmb";	
/**
  * 港市
  */
var COMMON_HK = "hk";	
/**
  * 香港主板
  */
var COMMON_HKMB = "hkmb";	
/**
  * 香港创业板
  */
var COMMON_HKCN = "hkcn";

/**
 * 其他
 */
var COMMON_OTHER = "other";