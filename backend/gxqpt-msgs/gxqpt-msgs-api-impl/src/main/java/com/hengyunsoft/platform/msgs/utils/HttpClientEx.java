package com.hengyunsoft.platform.msgs.utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.activation.MimetypesFileTypeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
@SuppressWarnings("deprecation")
public class HttpClientEx {
	private String hostUrl;
	private static Random random = new Random();
	
	public HttpClientEx(String hostUrl, String charset) {
		this.hostUrl = hostUrl;
	}
	
	public static String doPost(String url,Map<String, String> params) throws Exception{
		if(params != null && params.size() > 0){
			List <NameValuePair> nvps = new ArrayList <NameValuePair>();			
			for(Map.Entry<String, String> entry: params.entrySet()){
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			
			HttpPost httpost = new HttpPost(String.format("%s?r=%s", url, random.nextLong()));
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			HttpResponse response;
			@SuppressWarnings("resource")
			HttpClient httpclient = new DefaultHttpClient();
			try {
				response = httpclient.execute(httpost);
				HttpEntity entity = response.getEntity();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
		        String s;
		        StringBuffer buf = new StringBuffer();
		        
		        while((s = reader.readLine()) != null){
		        	buf.append(s);
		        }		        
		        EntityUtils.consume(entity);
		        return buf.toString().trim();
			} finally{
				httpclient.getConnectionManager().shutdown();
			}		        
		}		
		return null;
	}
	
	public static String doGet(String url){
		String s = "";
		StringBuffer buffer = new StringBuffer();
		URL url_;  
        URLConnection urlconn;  
        try {  
        	url_ = new URL(url);  
            urlconn = url_.openConnection();  
            HttpURLConnection httpConnection = (HttpURLConnection) urlconn;  
            httpConnection.setConnectTimeout(1000000);  
            httpConnection.setReadTimeout(1000000);  
            InputStream in = httpConnection.getInputStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));    
            while((s = br.readLine()) != null) {  
                buffer.append(new String(s.getBytes("ISO-8859-1"),"UTF-8"));
            }  
            br.close();  
            in.close();  
        } catch(IOException e) {  
            e.printStackTrace();  
        }
		return buffer.toString();
	}	
	
	
	public String doGet(Map<String, String> params){
		String s = "";
		StringBuffer buffer = new StringBuffer();
		String pathValue = "r="+random.nextLong();
		if(params!=null&&params.size()>0){
			for (Map.Entry<String, String> entry: params.entrySet()) {
				pathValue =String.format("%s&%s=%s",pathValue, entry.getKey(),entry.getValue());
			}
		}
		URL url_;  
        URLConnection urlconn;  
        try {  
        	url_ = new URL(String.format("%s?%s", this.hostUrl,pathValue));  
            urlconn = url_.openConnection();  
            HttpURLConnection httpConnection = (HttpURLConnection) urlconn;  
            httpConnection.setConnectTimeout(1000000);  
            httpConnection.setReadTimeout(1000000);  
//          httpConnection.setRequestProperty("User-Agent", "new");  
//          httpConnection.setRequestMethod("POST");  
            InputStream in = httpConnection.getInputStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));  
  
            while((s = br.readLine()) != null) {  
                System.out.println(s); 
                buffer.append(s);
            }  
            br.close();  
            in.close();  
        } catch(IOException e) {  
            e.printStackTrace();  
        }
		return buffer.toString();
	}
	
	public String doGet(){
		String s = "";
		StringBuffer buffer = new StringBuffer();
		URL url_;  
        URLConnection urlconn;  
        try {  
        	url_ = new URL(this.hostUrl);  
            urlconn = url_.openConnection();  
            HttpURLConnection httpConnection = (HttpURLConnection) urlconn;  
            httpConnection.setConnectTimeout(1000000);  
            httpConnection.setReadTimeout(1000000);  
            InputStream in = httpConnection.getInputStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));  
  
            while((s = br.readLine()) != null) {  
                buffer.append(s);
            }  
            br.close();  
            in.close();  
        } catch(IOException e) {  
            e.printStackTrace();  
        }
		return buffer.toString();
	}	
	
	public static String doPost(String url, String params) throws Exception {          
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost httpPost = new HttpPost(url);// 创建httpPost     
        httpPost.setHeader("Accept", "application/json");   
        httpPost.setHeader("Content-Type", "application/json");  
        String charSet = "UTF-8";  
        StringEntity entity = new StringEntity(params, charSet);  
        entity.setContentType("application/json");
        httpPost.setEntity(entity);          
        CloseableHttpResponse response = null;            
        try {               
            response = httpclient.execute(httpPost);  
            StatusLine status = response.getStatusLine();  
            int state = status.getStatusCode();  
            if (state == HttpStatus.SC_OK) {  
                HttpEntity responseEntity = response.getEntity();  
                String jsonString = EntityUtils.toString(responseEntity);  
                return jsonString;  
            }  
            else{  
                 System.out.println("请求返回:"+state+"("+url+")");
            }  
        }  
        finally {  
            if (response != null) {  
                try {  
                    response.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
	
	/**
	 * 模拟post上传文件
	 * @param urlStr
	 * @param textMap
	 * @param fileMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String formUpload(String urlStr, Map<String, String> textMap,  
            Map<String, String> fileMap) {  
        String res = "";  
        HttpURLConnection conn = null;  
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符  
        try {  
            URL url = new URL(urlStr);  
            conn = (HttpURLConnection) url.openConnection();  
            conn.setConnectTimeout(5000);  
            conn.setReadTimeout(30000);  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("Connection", "Keep-Alive");  
            conn.setRequestProperty("User-Agent",  
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");  
            conn.setRequestProperty("Content-Type",  
                    "multipart/form-data; boundary=" + BOUNDARY);  
  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            // text  
            if (textMap != null&&!textMap.isEmpty()) {  
                StringBuffer strBuf = new StringBuffer();  
                Iterator iter = textMap.entrySet().iterator();  
                while (iter.hasNext()) {  
                    Map.Entry entry = (Map.Entry) iter.next();  
                    String inputName = (String) entry.getKey();  
                    String inputValue = (String) entry.getValue();  
                    if (inputValue == null) {  
                        continue;  
                    }  
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");  
                    strBuf.append("Content-Disposition: form-data; name=\""+ inputName + "\"\r\n\r\n");  
                    strBuf.append(inputValue);  
                }  
                out.write(strBuf.toString().getBytes());  
            }  
  
            // file  
            if (fileMap != null&&!fileMap.isEmpty()) {  
                Iterator iter = fileMap.entrySet().iterator();  
                while (iter.hasNext()) {  
                    Map.Entry entry = (Map.Entry) iter.next();  
                    String inputName = (String) entry.getKey();  
                    String inputValue = (String) entry.getValue();  
                    if (inputValue == null) {  
                        continue;  
                    }  
                    File file = new File(inputValue);  
                    String filename = file.getName();  
                    String contentType = new MimetypesFileTypeMap().getContentType(file);  
                    if (filename.endsWith(".png")) {  
                        contentType = "image/png";  
                    }else if(filename.endsWith(".jpeg")){
                    	contentType = "image/jpeg";
                    }else if(filename.endsWith(".gif")){
                    	contentType = "image/gif";
                    }
                    if (contentType == null || contentType.equals("")) {  
                        contentType = "application/octet-stream";  
                    }  
  
                    StringBuffer strBuf = new StringBuffer();  
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");  
                    strBuf.append("Content-Disposition: form-data; name=\""+inputName+"\";filelength="+file.length()+"; filename=\"" + filename + "\"\r\n");  
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  
  
                    out.write(strBuf.toString().getBytes());   
                    URL fileUrl = new URL(inputValue);
                    URLConnection conn1 = fileUrl.openConnection();
                    InputStream in = conn1.getInputStream();
                    //DataInputStream in = new DataInputStream(new FileInputStream(file));  
                    int bytes = 0;  
                    byte[] bufferOut = new byte[1024];  
                    while ((bytes = in.read(bufferOut)) != -1) {  
                        out.write(bufferOut, 0, bytes);  
                    }  
                    in.close();  
                }  
            }  
  
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
            out.write(endData);  
            out.flush();  
            out.close();  
  
            // 数据返回  
            StringBuffer strBuf = new StringBuffer();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                strBuf.append(line).append("\n");  
            }  
            res = strBuf.toString();  
            reader.close();  
            reader = null;  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (conn != null) {  
                conn.disconnect();  
                conn = null;  
            }  
        }  
        return res;  
    }  
}
