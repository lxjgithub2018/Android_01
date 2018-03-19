package com.hwua.client.util;

import android.text.TextUtils;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * 与服务器请求公共类
 */
public class HttpUtil
{
	//定义储存Cookie信息,以便记录用户的登录信息
	public static String cookies;
	// 创建HttpClient对象
	public static HttpClient httpClient = new DefaultHttpClient();
	//服务端请求根地址
	public static final String BASE_URL ="http://10.100.56.22:8080/auction/";

	/**
	 *
	 * @param url 发送请求的URL
	 * @return 服务器响应字符串
	 * @throws Exception
	 */
	public static String getRequest(final String url) throws Exception
	{
		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>()
				{
					@Override
					public String call() throws Exception
					{
						// 创建HttpGet对象。
						HttpGet get = new HttpGet(url);
						//设置请求的Cookie头信息
						setRequestCookies(get);
						// 发送GET请求
						HttpResponse httpResponse = httpClient.execute(get);
						//把新的Cookie头信息附加到旧的Cookie后面
						appendCookies(httpResponse);
						// 如果服务器成功地返回响应
						if (httpResponse.getStatusLine().getStatusCode() == 200)
						{
							// 获取服务器响应字符串
							String result = EntityUtils.toString(httpResponse.getEntity());
							return result;
						}
						return null;
					}
				});
		new Thread(task).start();
		return task.get();
	}

	/**
	 * @param url 发送请求的URL
	 * @param rawParams 请求参数
	 * @return 服务器响应字符串
	 * @throws Exception
	 */
	public static String postRequest(final String url, final Map<String ,String> rawParams) throws Exception
	{
		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>()
				{
					@Override
					public String call() throws Exception
					{
						// 创建HttpPost对象。
						HttpPost post = new HttpPost(url);
						//设置请求的Cookie头信息
						setRequestCookies(post);
						// 如果传递参数个数比较多的话可以对传递的参数进行封装
						List<NameValuePair> params = new ArrayList<>();
						for(String key : rawParams.keySet())
						{
							//封装请求参数
							params.add(new BasicNameValuePair(key, rawParams.get(key)));
						}
						// 设置请求参数
						post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
						// 发送POST请求
						HttpResponse httpResponse = httpClient.execute(post);
						//把新的Cookie头信息附加到旧的Cookie后面
						appendCookies(httpResponse);
						// 如果服务器成功地返回响应
						if (httpResponse.getStatusLine().getStatusCode() == 200)
						{
							// 获取服务器响应字符串
							String result = EntityUtils.toString(httpResponse.getEntity());
							return result;
						}
						return null;
					}
				});
		new Thread(task).start();
		return task.get();
	}

	/**
	 * 设置请求的Cookie头信息
	 * @param reqMsg
	 */
	public static void setRequestCookies(HttpMessage reqMsg) {
		if(!TextUtils.isEmpty(cookies)){
			reqMsg.setHeader("Cookie", cookies);
		}
	}

	/**
	 * 把新的Cookie头信息附加到旧的Cookie后面
	 * 用于下次Http请求发送
	 * @param resMsg
	 */
	public static void appendCookies(HttpMessage resMsg) {
		Header setCookieHeader=resMsg.getFirstHeader("Set-Cookie");
		if (setCookieHeader != null && TextUtils.isEmpty(setCookieHeader.getValue())) {
			String setCookie=setCookieHeader.getValue();
			if(TextUtils.isEmpty(cookies)){
				cookies=setCookie;
			}else{
				cookies=cookies+"; "+setCookie;
			}
		}
	}
}
