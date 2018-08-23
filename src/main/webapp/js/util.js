function QueryString(val) {
	var uri = window.location.search;
	var re = new RegExp("" + val + "=([^&?]*)", "ig");
	return ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1)) : null);
}

/**
 * 判断一个字符串是否为空
 * 
 * @param str
 * @returns
 */
function isEmpty(str) {
	if (str == undefined || str == "undefined" || str == null || str == "")
		return true;
	return false;
}

/**
 * 判断一个字符串是否为非空
 * 
 * @param str
 * @returns
 */
function isNotEmpty(str) {
	return !isEmpty(str);
}

/**
 * 设置cookie
 * 
 * @param name
 * @param val
 */
function setCookie(name, val) {
	$.cookie(name, val, {
		expires : 365,
		path : "/"
	});
}

/**
 * 获取cookie
 * 
 * @returns cookie value
 */
function getCookie(name) {
	return $.cookie(name);
}

/**
 * 删除cookie
 * 
 * @param name
 * @returns true false
 */
function deleteCookie(name) {
	$.cookie(name, null, {
		expires : -1,
		path : "/"
	});
}

function getClientType() {
	var ua = navigator.userAgent.toLowerCase();
	var osType = "unknown";
	if (/macintosh/i.test(ua)) {
		osType = "Mac";
	} else if (/iphone/i.test(ua)) {
		osType = "ios";
	} else if (/ipad/i.test(ua)) {
		osType = 'iPad';
	} else if (/android/i.test(ua)) {
		osType = "Android";
	} else if (/windows/i.test(ua)) {
		osType = "Windows";
	}
	return osType;
}

function guid() {
	function S4() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
	}
	return (S4() + S4() + S4() + S4() + S4() + S4() + S4() + S4());
}

function MathRand() {
	var Num = "";
	for (var i = 0; i < 8; i++) {
		Num += Math.floor(Math.random() * 10);
	}
	return Num;
}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function isExistsSpecial(str) {
	var regex = RegExp(/[(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\\)(\/)]+/);

	return (regex.test(str));
}

function md5(str) {
	return hex_md5(str);
}

function showMask(){  
    /*$("#mask").css("height",$(document).height());     
    $("#mask").css("width",$(document).width()); */    
    $("#mask").show(); 
    $("#maskDiv").show();
}  
//隐藏遮罩层  
function hideMask(){     
      
    $("#mask").hide();
    $("#maskDiv").hide();
} 