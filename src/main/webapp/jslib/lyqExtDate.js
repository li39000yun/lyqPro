var lyq = lyq || {};
lyq.Time = lyq.Time || {};// 时间操作控件
lyq.lastDay = {"1":"31","2":"29","3":"31","4":"30","5":"31","6":"30","7":"31","8":"31","9":"30","10":"31","11":"30","12":"31"};
lyq.Time.getNow = function() {// 显示时间
	var currentDT = new Date();
	var y, m, date, day, hs, ms, ss, theDateStr;
	y = currentDT.getFullYear(); // 四位整数表示的年份
	m = currentDT.getMonth() + 1; // 月
	date = currentDT.getDate(); // 日
	day = currentDT.getDay(); // 星期
	hs = currentDT.getHours(); // 时
	ms = currentDT.getMinutes(); // 分
	ss = currentDT.getSeconds(); // 秒
	return y + "-" + m + "-" + date + " " + hs + ":" + ms + ":" + ss;
};
lyq.Time.getFirstDayForNow = function() {
	var currentDT = new Date();
	var y, m;
	y = currentDT.getFullYear(); // 四位整数表示的年份
	m = currentDT.getMonth() + 1; // 月
	if (m > 9) {
		return y + "-" + m + "-01 00:00:00";
	}
	return y + "-0" + m + "-01 00:00:00";
};
lyq.Time.getLastDayForNow = function() {
	var currentDT = new Date();
	var y, m;
	y = currentDT.getFullYear(); // 四位整数表示的年份
	m = currentDT.getMonth() + 1; // 月
	if (m > 9) {
		return y + "-" + m + "-" + lyq.lastDay[m] + " 23:59:59";
	}
	return y + "-0" + m + "-" + lyq.lastDay[m] + " 23:59:59";
};