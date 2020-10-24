package com.hengyunsoft.platform;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

public class file {

    //设置APPID/AK/SK
    public static final String APP_ID = "10920197";
    public static final String API_KEY = "5ZIRkHjlFvlgc6KYZoiimFHr";
    public static final String SECRET_KEY = "xZNTAgZhfir9X2gLuC33p0LjnKrokdyM";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        //JSONObject res = client.asr("d:\\16k.wav", "pcm", 16000, null);
        JSONObject res = client.asr("d:\\0703.mp3", "pcm", 16000, null);
        System.out.println(res.toString(2));
        System.out.println(res.getString("err_msg"));
        System.out.println(res.getLong("err_no"));

    }


    public void synthesis(AipSpeech client) throws Exception{
        // 对本地语音文件进行识别
        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对网络上音频进行识别
        String url = "http://somehost/res/16k_test.pcm";
        String callback = "http://callbackhost/aip/dump";
        JSONObject res = client.asr(url, callback, "pcm", 16000, null);
        System.out.println(res);
    }
}
