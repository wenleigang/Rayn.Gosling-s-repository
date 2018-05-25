package com.chaosquark.backend.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
  *
  * @ClassName:      PureNetUtils
  * @Description:    java类作用描述
  * @Author:         唐朝
  * @CreateDate:     2018/4/28/028 16:32
  * @UpdateUser:     更新者
  * @UpdateDate:     2018/4/28/028 16:32
  * @UpdateRemark:   更新内容
  * @Version:        1.0
  */
public class PureNetUtils {

    public static void main(String[] args) throws IOException {
        //String weatherInfo = getWeatherInfo("http://wthrcdn.etouch.cn/weather_mini?city=北京市");
        //System.err.println(weatherInfo);
        Date date = new Date();
        System.err.println(date);
    }
    // 请求器的配置
    private RequestConfig requestConfig;


    public static String getWeatherInfo(String url) throws IOException {

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;

        try {
            URL readUrl = new URL(url);
            connection = (HttpURLConnection) readUrl.openConnection();
            connection.setRequestMethod(RequestMethod.GET.toString());
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String line;
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
            if(inputStream != null) {
                inputStream.close();
            }
            if(reader != null) {
                reader.close();
            }
        }
        return null;
    }

    /**
     * 发送Get请求
     *
     * @param httpGet
     * @return
     */
    private HttpEntity sendHttpGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        String s = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            s = JSON.toJSONString(responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    /**
     * 发送 get请求
     *
     * @param httpUrl
     */
    public HttpEntity sendHttpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求
        return sendHttpGet(httpGet);
    }
}
