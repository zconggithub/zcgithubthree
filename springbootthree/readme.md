# [Springboot 学习3 demo]https://github.com/zconggithub/
create by 周聪 	QQ：2632652610	
					《第三方登录，微信网页授权》
知识点：
1、authori2.0知识
2.HttpClient知识

#具体步骤如下：
关于特殊场景下的静默授权
1、已经提到，对于以snsapi_base为scope的网页授权，就静默授权的，用户无感知； 
2、对于已关注公众号的用户，如果用户从公众号的会话或者自定义菜单进入本公众号的网页授权页，即使是scope为snsapi_userinfo，也是静默授权，用户无感知。 
具体而言，网页授权流程分为四步：
1、引导用户进入授权页面同意授权，获取code 
2、通过code换取网页授权access_token（与基础支持中的access_token不同） 
3、如果需要，开发者可以刷新网页授权access_token，避免过期 
4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制） 
目录
1 第一步：用户同意授权，获取code
2 第二步：通过code换取网页授权access_token
3 第三步：刷新access_token（如果需要）
4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
5 附：检验授权凭证（access_token）是否有效

#httpClient, 
#HttpClient get请求的方式获取服务器的返回数据
使用HttpClient发送请求、接收响应很简单，一般需要如下几步即可。
1. 创建HttpClient对象。
2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。
3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
6. 释放连接。无论执行方法是否成功，都必须释放连接