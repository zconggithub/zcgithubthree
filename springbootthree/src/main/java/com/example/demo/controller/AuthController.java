package com.example.demo.controller;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.AuthUtil;

import net.sf.json.JSONObject;

@RestController
public class AuthController {
	
	
	@RequestMapping("/getToken")
			//调用第三方入口接口地址并从第三方获取返回的数据===>》【测试直接获取token】
	public JSONObject getData() throws ClientProtocolException, IOException{
		
		return AuthUtil.getAccess_token();
	}
	
	@RequestMapping("/getCode")
	public JSONObject getCode() throws ParseException, IOException{
		return AuthUtil.getJsonObgectResultDemo();
		
	}
}
