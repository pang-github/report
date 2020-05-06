package com.sweet.core.util;import org.apache.http.HttpEntity;import org.apache.http.NameValuePair;import org.apache.http.client.entity.UrlEncodedFormEntity;import org.apache.http.client.methods.CloseableHttpResponse;import org.apache.http.client.methods.HttpPost;import org.apache.http.impl.client.CloseableHttpClient;import org.apache.http.impl.client.HttpClients;import org.apache.http.message.BasicNameValuePair;import org.apache.http.util.EntityUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.core.env.Environment;import org.springframework.stereotype.Component;import javax.annotation.PostConstruct;import java.io.IOException;import java.net.URISyntaxException;import java.net.URLEncoder;import java.util.*;@Componentpublic class JavaSmsApi {    @Autowired    private Environment env;    public static boolean isSendSms;    @PostConstruct    public void transValues() {        isSendSms = Boolean.valueOf(env.getProperty("system.sendSms"));    }    //智能匹配模版发送接口的http地址    public static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";    public static String single_tpl_utl = "https://sms.yunpian.com/v2/sms/tpl_single_send.json";    public static String tpl_url = "https://sms.yunpian.com/v2/sms/tpl_batch_send.json";    public static String apiKey = "fba4731e9e32b4c0e76782d54a9028b5";    public static String new_apiKey = "44933444684ba38f0bb291cb444f3632";    public static  String tpl_id = "3587720";    public static String order_tpl_id = "3118706";    public static String expense_tpl_id = "3118710";    public static String code_tpl_id = "3153768";    //注册奖励    public static String register_tpl_id = "3179484";    //邀请奖励    public static String invite_tpl_id = "3179460";    //编码格式。发送编码格式统一用UTF-8    private static String ENCODING = "UTF-8";    public static void main(String[] args) throws IOException, URISyntaxException {        //修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后用户中心首页看到        String apikey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";        //修改为您要发送的手机号        String mobile = "xxxxxxxxxxx";        /**************** 使用智能匹配模版接口发短信(推荐) *****************/        //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）        String text = "【云片网】您的验证码是1234";        //发短信调用示例        System.out.println(JavaSmsApi.sendSms(apikey, text, mobile));    }    public static String coverTplValue(Map map) throws Exception{        Integer i = 0;//记录循环次数        String tpl_value = "";        for(Object key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可            String value = String.valueOf(map.get(key));//            System.out.println("key:"+key+" vlaue:"+value);            if(i==0){                tpl_value += URLEncoder.encode("#"+key+"#", ENCODING) + "=" +                        URLEncoder.encode(value, ENCODING);                i++;            }else{                tpl_value +="&"+                        URLEncoder.encode("#"+key+"#", ENCODING) + "=" +                        URLEncoder.encode(value, ENCODING);            }        }        return tpl_value;    }    /**     * 智能匹配模版接口发短信     *     * @param apikey apikey     * @param text   　短信内容     * @param mobile 　接受的手机号     * @return json格式字符串     * @throws IOException     */    public static String sendSms(String apikey, String text, String mobile) throws IOException {        Map<String, String> params = new HashMap<String, String>();        params.put("apikey", apikey);        params.put("text", text);        params.put("mobile", mobile);        return post(URI_SEND_SMS, params);    }    //获取随机验证码    public static String createCode(){        String zi = "0123456789";        String ret = "";        Random random = new Random();        for (int i =0;i<4;i++){            int a=random.nextInt(zi.length());            char s = zi.charAt(a);            ret+=s;        }        return ret;    }    public static String tplSingleSend(String mobile, String tpl_id ,Map tplMap) {        Map<String, String> params = new HashMap<String, String>();        params.put("apikey", apiKey);        params.put("mobile", mobile);        params.put("tpl_id", tpl_id);        String tpl_value = "";        try {            tpl_value = JavaSmsApi.coverTplValue(tplMap);        } catch (Exception e) {}        params.put("tpl_value", tpl_value);        return post("https://sms.yunpian.com/v2/sms/tpl_single_send.json", params);    }    /**     * 发送短信apikey王旭磊     * @param mobile     * @param tpl_id     * @param tplMap     * @return     */    public static String tplSingleSendNew(String mobile, String tpl_id ,Map tplMap) {        if(!isSendSms){            return null;        }        Map<String, String> params = new HashMap<String, String>();        params.put("apikey", new_apiKey);        params.put("mobile", mobile);        params.put("tpl_id", tpl_id);        String tpl_value = "";        try {            tpl_value = JavaSmsApi.coverTplValue(tplMap);            params.put("tpl_value", tpl_value);        } catch (Exception e) {            e.printStackTrace();        }        return post("https://sms.yunpian.com/v2/sms/tpl_single_send.json", params);    }    public static String tplBatchSend( String mobile, String tpl_id , Map tplMap) {        if(!isSendSms){            return null;        }        Map<String, String> params = new HashMap<String, String>();        params.put("apikey", apiKey);        params.put("mobile", mobile);        params.put("tpl_id", tpl_id);        String tpl_value = "";        try {            tpl_value = coverTplValue(tplMap);            params.put("tpl_value", tpl_value);        } catch (Exception e) {        }        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);    }    public static void sendWeChatAlert(String text,String desp){        Map pushMap  = new HashMap();        pushMap.put("text",text);        pushMap.put("desp",desp);        String aletMsg =  post("https://sc.ftqq.com/SCU53837T37ba12534bdc1d2d353b7cc50b962e2a5d0b843f881c8.send",pushMap);    }    /**     * 基于HttpClient 4.3的通用POST方法     *     * @param url       提交的URL     * @param paramsMap 提交<参数，值>Map     * @return 提交响应     */    public static String post(String url, Map<String, String> paramsMap) {        CloseableHttpClient client = HttpClients.createDefault();        String responseText = "";        CloseableHttpResponse response = null;        try {            HttpPost method = new HttpPost(url);            if (paramsMap != null) {                List<NameValuePair> paramList = new ArrayList<NameValuePair>();                for (Map.Entry<String, String> param : paramsMap.entrySet()) {                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());                    paramList.add(pair);                }                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));            }            response = client.execute(method);            HttpEntity entity = response.getEntity();            if (entity != null) {                responseText = EntityUtils.toString(entity);            }        } catch (Exception e) {            e.printStackTrace();        } finally {            try {                response.close();            } catch (Exception e) {                e.printStackTrace();            }        }                                                                                                                                                                                                                                                                                                                       System.out.println(responseText);//此处打印在console后，会给出一个IP地址        return responseText;    }}