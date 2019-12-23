//package com.book.common;
//
//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.UUID;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
// 
// 
//import javax.servlet.http.HttpServletRequest;
// 
// 
//import net.englishvod.common.security.Cryptos;
//import net.englishvod.common.security.Digests;
// 
// 
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.LocaleResolver;
// 
// 
///**
// * 字符串工具类
// * 
// * @author leon
// * @version Apr 10, 2014
// */
//public class StringUtils extends org.apache.commons.lang3.StringUtils {
// 
// 
//	public static String lowerFirst(String str) {
//	if (isBlank(str)) {
//	return "";
//	} else {
//	return str.substring(0, 1).toLowerCase() + str.substring(1);
//	}
//	}
//	 
//	 
//	public static String upperFirst(String str) {
//	if (StringUtils.isBlank(str)) {
//	return "";
//	} else {
//	return str.substring(0, 1).toUpperCase() + str.substring(1);
//	}
//	}
//	 
//	 
//	/**
//	* 替换掉HTML标签方法
//	*/
//	public static String replaceHtml(String html) {
//	if (isBlank(html)) {
//	return "";
//	}
//	String regEx = "<.+?>";
//	Pattern p = Pattern.compile(regEx);
//	Matcher m = p.matcher(html);
//	String s = m.replaceAll("");
//	return s;
//	}
//	 
//	 
//	/**
//	* 缩略字符串（不区分中英文字符）
//	* 
//	* @param str
//	*            目标字符串
//	* @param length
//	*            截取长度
//	* @return
//	*/
//	public static String abbr(String str, int length) {
//	if (str == null) {
//	return "";
//	}
//	try {
//	StringBuilder sb = new StringBuilder();
//	int currentLength = 0;
//	for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
//	currentLength += String.valueOf(c).getBytes("GBK").length;
//	if (currentLength <= length - 3) {
//	sb.append(c);
//	} else {
//	sb.append("...");
//	break;
//	}
//	}
//	return sb.toString();
//	} catch (UnsupportedEncodingException e) {
//	e.printStackTrace();
//	}
//	return "";
//	}
//	 
//	 
//	/**
//	* 缩略字符串（替换html）
//	* 
//	* @param str
//	*            目标字符串
//	* @param length
//	*            截取长度
//	* @return
//	*/
//	public static String rabbr(String str, int length) {
//	return abbr(replaceHtml(str), length);
//	}
//	 
//	 
//	/**
//	* 转换为Double类型
//	*/
//	public static Double toDouble(Object val) {
//	if (val == null) {
//	return 0D;
//	}
//	try {
//	return Double.valueOf(trim(val.toString()));
//	} catch (Exception e) {
//	return 0D;
//	}
//	}
//	 
//	 
//	/**
//	* 转换为Float类型
//	*/
//	public static Float toFloat(Object val) {
//	return toDouble(val).floatValue();
//	}
//	 
//	 
//	/**
//	* 转换为Long类型
//	*/
//	public static Long toLong(Object val) {
//	return toDouble(val).longValue();
//	}
//	 
//	 
//	/**
//	* 转换为Integer类型
//	*/
//	public static Integer toInteger(Object val) {
//	return toLong(val).intValue();
//	}
//	 
//	 
//	/**
//	* 获得i18n字符串
//	*/
//	public static String getMessage(String code, Object[] args) {
//	LocaleResolver localLocaleResolver = SpringContextHolder.getBean(LocaleResolver.class);
//	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//	Locale localLocale = localLocaleResolver.resolveLocale(request);
//	return SpringContextHolder.getApplicationContext().getMessage(code, args, localLocale);
//	}
//	 
//	 
//	/**
//	* 获得用户远程地址
//	*/
//	public static String getRemoteAddr(HttpServletRequest request) {
//	String remoteAddr = request.getHeader("X-Real-IP");
//	if (isNotBlank(remoteAddr)) {
//	remoteAddr = request.getHeader("X-Forwarded-For");
//	} else if (isNotBlank(remoteAddr)) {
//	remoteAddr = request.getHeader("Proxy-Client-IP");
//	} else if (isNotBlank(remoteAddr)) {
//	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
//	}
//	return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
//	}
//	 
//	 
//	/**
//	* 获取uuid
//	* 
//	* @return
//	*/
//	public static String getUuid() {
//	return UUID.randomUUID().toString().replace("-", "");
//	}
//	 
//	 
//	/**
//	* 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
//	*/
//	public static String entryptPassword(String plainPassword) {
//	byte[] salt = Digests.generateSalt(Cryptos.SALT_SIZE);
//	byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, Cryptos.HASH_INTERATIONS);
//	return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
//	}
//	 
//	 
//	/**
//	* 根据当前时间返回唯一id值
//	* 
//	* @return
//	*/
//	public synchronized static String getNowString() {
//	Calendar now = Calendar.getInstance();
//	return new String("" + now.get(Calendar.YEAR) + getDigit(2, (now.get(Calendar.MONTH) + 1)) + getDigit(2, now.get(Calendar.DAY_OF_MONTH))
//	+ getDigit(2, now.get(Calendar.HOUR_OF_DAY)) + getDigit(2, now.get(Calendar.MINUTE)) + getDigit(2, now.get(Calendar.SECOND))
//	+ getDigit(3, now.get(Calendar.MILLISECOND)));
//	}
//	 
//	 
//	/**
//	* 返回指定位数的字符串
//	* 
//	* @param digit
//	*            位数
//	* @param num
//	* @return
//	*/
//	public static String getDigit(int digit, int num) {
//	String str = "";
//	for (int i = 0; i < digit; i++) {
//	str = str + "0";
//	}
//	str = str + num;
//	str = str.substring((str.length() - digit), str.length());
//	return str;
//	}
//	 
//	 
//	/**
//	* 密码加密方法
//	* 
//	* @param password
//	* @param algorithm
//	* @return
//	*/
//	public static String encodePassword(String password, String algorithm) {
//	byte[] unencodedPassword = password.getBytes();
//	 
//	 
//	MessageDigest md = null;
//	 
//	 
//	try {
//	md = MessageDigest.getInstance(algorithm);
//	} catch (Exception e) {
//	return password;
//	}
//	md.reset();
//	md.update(unencodedPassword);
//	byte[] encodedPassword = md.digest();
//	StringBuffer buf = new StringBuffer();
//	 
//	 
//	for (int i = 0; i < encodedPassword.length; i++) {
//	if ((encodedPassword[i] & 0xff) < 0x10) {
//	buf.append("0");
//	}
//	buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
//	}
//	return buf.toString();
//	}
//}
