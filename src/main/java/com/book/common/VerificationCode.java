package com.book.common;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.HtmlEmail;

/**
 * 验证码类
 * @author Lenovo
 *
 */
public class VerificationCode {
	
	static String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
	static String num;
	
	//生成随机6位数字
	public static String getCodeSix() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 100; i++){
			Random rand = new Random();
			StringBuffer flag = new StringBuffer();
			for (int j = 0; j < 6; j++){
				flag.append(sources.charAt(rand.nextInt(9)) + "");
			}
			num = flag.toString();
			break;
		}
		return num;
	}
	//生成随机任意位数字,自定义输入的数字或字母
	public static String getCodeToSix(String sources) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 100; i++){
			Random rand = new Random();
			StringBuffer flag = new StringBuffer();
			for (int j = 0; j < 6; j++){
				flag.append(sources.charAt(rand.nextInt(9)) + "");
			}
			num = flag.toString();
			break;
		}
		return num;
	}
	//生成随机任意位数字,自定义输入的数字或字母
	public static String getCodeToN(String sources,int number) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 100; i++){
			Random rand = new Random();
			StringBuffer flag = new StringBuffer();
			for (int j = 0; j < number; j++){
				flag.append(sources.charAt(rand.nextInt(9)) + "");
			}
			num = flag.toString();
			break;
		}
		return num;
	}
	
	private final static int codeLength =5;
    /**
     * @see 产生随机验证码 5位 全数字
     * @return 验证码字符串
     */
	public static String getCodeFive(){
		 Random rand = new  Random();
		 int  a ;
		 String  result ="";
		 for( int j =0; j<codeLength; j++ ){
			 a = Math.abs( rand.nextInt()%9 );
			 result += String.valueOf(a);
		 }
		 return  result;
	}
    /**
     * @see 产生随机验证码任意位,全数字
     * @return 验证码字符串
     */
	public static String getCodeToN(int codeLength){
		 Random rand = new  Random();
		 int  a ;
		 String  result ="";
		 for( int j =0; j<codeLength; j++ ){
			 a = Math.abs( rand.nextInt()%9 );
			 result += String.valueOf(a);
		 }
		 return  result;
	}
	
	//发送邮箱(封装)
	//借鉴网址:https://blog.csdn.net/j18423532754/article/details/80324700
	public static String verificationCode; 
	public static String verificationCode(EmailCode eCode){
//		HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
//		email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
//		email.setCharset("utf-8");//设置发送的字符类型
//		email.addTo("1985829477@qq.com");//设置收件人
//		email.setFrom("206323705@qq.com","方亚伟");//发送人的邮箱为自己的，用户名可以随便填
//		email.setAuthentication("206323705@qq.com","rmmnxblkisbhbgda");//设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
//		email.setSubject("图书管理系统验证码");//设置发送主题
//		email.setMsg(eCode.getMessage());//设置发送内容
//		email.send();//进行发送
		try {
			HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
			email.setHostName(eCode.getServerSMTP());//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
			email.setCharset(eCode.getCharset());//设置发送的字符类型
			email.addTo(eCode.getAddressee());//设置收件人
			email.setFrom(eCode.getSender(),eCode.getUsername());//发送人的邮箱为自己的，用户名可以随便填
			email.setAuthentication(eCode.getSender(),eCode.getAuthorizationCode());//设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
			email.setSubject(eCode.getTheme());//设置发送主题
			verificationCode = VerificationCode.getCodeSix();
			email.setMsg(eCode.getMessageStart()+verificationCode+eCode.getMessageEnd());//设置发送内容
			email.send();//进行发送
			
			//Runnable：实现了Runnable接口，jdk就知道这个类是一个线程  
			HelloThread thread = new HelloThread();
			// ScheduledExecutorService:是从Java SE5的java.util.concurrent里，
			// 做为并发工具类被引进的，这是最理想的定时任务实现方式。
			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
			// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
			// 10：秒   5：秒
			// 第一次执行的时间为10秒，然后每隔五秒执行一次
			service.scheduleAtFixedRate(thread, 0, 60*5, TimeUnit.SECONDS);
			service.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			verificationCode="获取验证码失败!";
			e.printStackTrace();
		}
		return verificationCode;
	}
}

class HelloThread implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			VerificationCode.verificationCode="";
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //中断状态在抛出异常前，被清除掉，因此在此处重置中断状态
            Thread.currentThread().interrupt();
        }
	}
	
	
}
