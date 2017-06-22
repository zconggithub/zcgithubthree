package com.example.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * 
 * @author	周聪   功能（对接第三方入口封装） 
 *	
 */
public class AuthUtil {

		/**
		 * APPID/APPIDSECRET是从第三方平台获取到的
		 */
	private static final String APPID="wx0585adf01c929f47";
	private static final String APPSECRET="793ff143208c7900988dbafcc4644f42";
	//private static final String CALLBACKURL="Https://localhost:8080/back.html";
	/**
	 * 【接口调试,公众平台的API调用所需的access_token的使用及生成：】
	 * @return	jsonObject(从第三方服务器获取返回的数据)
	 * 具体接口要求请参看：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject getAccess_token() throws ClientProtocolException, IOException{
		JSONObject jsonObject=null;
		//点击第三方图标后会调用下面的入口地址，即第三方的入口接口地址
	String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
		+"&appid="+APPID
		+"&secret="+APPSECRET;	
	
	 //1.创建客户端访问服务器的httpclient对象   打开浏览器  
	@SuppressWarnings("deprecation")
	HttpClient httpclient=new DefaultHttpClient();  
	  //2.以请求的连接地址创建get请求对象     浏览器中输入网址  
    HttpGet httpGet=new HttpGet(url);  
    //3.向服务器端发送get请求 并且获取响应对象  浏览器中输入网址点击回车  
    HttpResponse response=httpclient.execute(httpGet);  
    //4.从返回对象中获取HttpEntity消息载体对象  可以接收和发送消息  
    HttpEntity entity=response.getEntity(); 
    if (entity!=null) {
    	//EntityUtils中的toString()方法转换服务器的响应数据  
        String str=EntityUtils.toString(entity, "utf-8"); 
        jsonObject=JSONObject.fromObject(str);
        System.out.println("服务器的响应是:"+jsonObject);
        return jsonObject;
	}
		return jsonObject;
	}
	
	
	public static JSONObject getJsonObgectResultDemo() throws ParseException, IOException{
		JSONObject jsonObject=null;
		//点击第三方图标后会调用下面的入口地址，即第三方的入口接口地址
	String url="https://open.weixin.qq.com/connect/oauth2/authorize?"
			+ "+appid="+APPID
			//+"&redirect_uri="+CALLBACKURL
			+ "+&response_type=code"
			+ "&scope=SCOPE"
			+ "&state=STATE#wechat_redirect" ;	
	
	 //1.创建客户端访问服务器的httpclient对象   打开浏览器  
	@SuppressWarnings("deprecation")
	HttpClient httpclient=new DefaultHttpClient();  
	  //2.以请求的连接地址创建get请求对象     浏览器中输入网址  
    HttpGet httpGet=new HttpGet(url);  
    //3.向服务器端发送get请求 并且获取响应对象  浏览器中输入网址点击回车  
    HttpResponse response=httpclient.execute(httpGet); 
   
/*    //获取返回的code（第三方给的）
    String code=request.getParameter("code");		
    System.out.println(code);*/
    
    //5.从返回对象中获取HttpEntity消息载体对象  可以接收和发送消息  
    HttpEntity entity=response.getEntity(); 
    if (entity!=null) {
    	//EntityUtils中的toString()方法转换服务器的响应数据  
        String str=EntityUtils.toString(entity, "utf-8"); 
        jsonObject=JSONObject.fromObject(str);
      //  System.out.println("服务器的响应是:"+jsonObject);
        return jsonObject;
	}
		return jsonObject;
}
}
