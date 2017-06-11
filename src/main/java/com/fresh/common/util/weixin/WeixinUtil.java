package com.fresh.common.util.weixin;

import com.fresh.common.pattern.PatternUtil;
import com.fresh.common.util.date.DateUtil;
import com.fresh.common.util.encode.EncodeUtil;
import com.fresh.common.util.http.HttpUtil;
import com.fresh.common.util.request.RequestUtil;
import com.fresh.common.util.string.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Map;

public class WeixinUtil {

    /*************  服务号 **********/

    //通过media_id 获取图片绝对路径
    public final static String URL_APPID_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";
    public final static String URL_JS_API_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    public final static String URL_SNS_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public final static String URL_SNS_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    public final static String URL_SNS_USER_INFO = "https://api.weixin.qq.com/sns/userinfo";
    public final static String URL_PAY = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public final static String URL_SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    public final static String URL_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info";
    public final static String GET_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get";

    // 客服消息接口
    public final static String URL_KEFU_SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/kf/send?access_token=";

    // 添加客服
    public final static String URL_ADD_KEFU_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=";
    // 修改客服
    public final static String URL_UPDATE_KEFU_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=";
    // 删除客服
    public final static String URL_DELETE_KEFU_ACCOUNT = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=";
    // 上传客服头像
    public final static String URL_UPLOAD_KEFU_ACCOUNT_IMAGE = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=";

    // 公众号添加素材
    public final static String URL_ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
    // 公众号删除素材
    public final static String URL_DELETE_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";

    // 企业号添加素材
    public final static String URL_ADD_MATERIAL_QY = "https://qyapi.weixin.qq.com/cgi-bin/material/add_material?access_token=";
    // 企业号删除素材
    public final static String URL_DELETE_MATERIAL_QY = "https://qyapi.weixin.qq.com/cgi-bin/material/del?access_token=";

    // 创建关注二维码
    public final static String URL_CREATE_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
    // 显示或下载关注二维码
    public final static String URL_SHOW_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

    //创建分组
    public final static String URL_GROUPS_CREATE = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
    //查询所有分组
    public final static String URL_GROUPS_GET = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
    //查询用户所在分组
    public final static String URL_GROUPS_GETID = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=";
    //修改分组名
    public final static String URL_GROUPS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
    //移动用户分组
    public final static String URL_GROUPS_MEMBERS_UPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
    //批量移动用户分组
    public final static String URL_GROUPS_MEMBERS_BATCHUPDATE = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=";
    //删除分组
    public final static String URL_GROUPS_DELETE = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=";
    // 获取应用列表
    public final static String URL_AGENT_LIST = "https://qyapi.weixin.qq.com/cgi-bin/agent/list";


    /*************  企业号 ******************/
    public final static String URL_QIYE_JSAPI_TICKET = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";
    public final static String REDIS_QIYE_JSTICKET_KEY = "wx_qykefu_jsticket";
    public final static String URL_QIYE_GET_MEDIA = "https://qyapi.weixin.qq.com/cgi-bin/media/get?";

    // 创建成员接口
    public final static String URL_CREATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=";
    // 更新成员接口
    public final static String URL_UPDATE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=";
    // 获取成员接口
    public final static String URL_GET_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/get";
    // 删除成员接口
    public final static String URL_DELETE_USER = "https://qyapi.weixin.qq.com/cgi-bin/user/delete";

    //获取部门成员(详情)
    public final static String URL_USER_LIST = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";

    public final static String URL_CORPID_ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public final static String URL_SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
    public final static String URL_QIYE_USER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";

    /*************  第三方平台 ******************/
    public final static String URL_COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
    //获取预授权码
    public final static String URL_PRE_AUTH_CODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
    //授权页
    public final static String URL_COMPONENT_LOGIN_PAGE = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=COMPONENT_APPID&pre_auth_code=PRE_AUTH_CODE&redirect_uri=REDIRECT_URI";
    //获取调用凭据
    public final static String URL_API_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";
    //刷新调用凭据
    public final static String URL_API_AUTHORIZER_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";
    //获取授权方的公众号帐号基本信息
    public final static String URL_GET_AUTHORIZER_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=";



    public final static String COMPONENT_APPID = "component_appid";
    public final static String COMPONENT_APPSECRET = "component_appsecret";
    public final static String COMPONENT_VERIFY_TICKET = "component_verify_ticket";
    //公众号取消授权事件
    public final static String UNAUTHORIZED = "unauthorized";
    public final static String AUTHORIZED = "authorized";
    public final static String PRE_AUTH_CODE = "pre_auth_code";
    public final static String QUERY_AUTH_CODE = "auth_code";
    public final static String COMPONENT_ACCESS_TOKEN = "component_access_token";
    //全网发布测试
    public final static String AUTHORIZATION_CODE = "AuthorizationCode";

    public final static String AUTHORIZER_ACCESS_TOKEN = "authorizer_access_token";
    public final static String AUTHORIZER_REFRESH_TOKEN = "authorizer_refresh_token";

    public final static String AUTHORIZER_APPID = "authorizer_appid";
    public final static String AUTHORIZATION_INFO = "authorization_info";

    public final static String MSG_AUTHORIZER_APPID = "AuthorizerAppid";


    public final static String WEIXIN_COMPONENT_VERIFY_TICKET = "ComponentVerifyTicket";
    public final static String WEIXIN_INFO_TYPE = "InfoType";

    public final static String PLATFORM_APPID_VALUE = "wx.platform.appid";
    public final static String PLATFORM_APPID_SECRET_VALUE = "wx.platform.appid.secret";
    public final static String WEIXIN_QY_AGENTID = "wx.qy.agentid";

    public final static String REDIS_COMPONENT_VERIFY_TICKET = "wx_component_verify_ticket";
    public final static String REDIS_PLATFORM_APPID_ACCESS_TOKEN = "wx_platform_appid_access_token";
    public final static String REDIS_PRE_AUTH_CODE = "wx_pre_auth_code";

    public final static int REDIS_PLATFORM_WX_KEY_TTL = 500;  // 单位秒
    public final static int REDIS_SERVICE_NUMBER_WX_KEY_TTL = 6000;


    public final static String URL_PLATFORM_AUTHORIZE = "url.platform.authorize";
    public final static String URL_PLATFORM_AUTH = "url.platform.auth";
    public final static String URL_PLATFORM_PAGE = "url.platform.page";
    public final static String URL_PLATFORM_PIC_URL = "url.platform.pic.url";

    //reion企业号
    public final static String REDIS_CORPID_ACCESS_TOKEN = "qykefu_wx_corpid_access_token";

    //endregion

    public final static String APPID_KEY = "appid";
    public final static String CORPID_KEY = "corpid";
    public final static String SECRET_KEY = "secret";
    public final static String SECRET_CORP_KEY = "corpsecret";

    public final static String CALLBACK_TOKEN = "wx.callback.token";
    public final static String CALLBACK_ENCODINGAESKEY = "wx.callback.encodingaeskey";

    public final static String APPID_VALUE = "wx.appid";
    public final static String CORPID_VALUE = "wx.corpid";

    public final static String APPID_SECRET_VALUE = "wx.appid.secret";
    public final static String CORPID_SECRET_VALUE = "wx.corpid.secret";
    public final static String CORPID_KEFU_SECRET_VALUE = "wx.corpid.kefu.secret";

    public final static String CODE_KEY = "code";
    public final static String GRANT_TYPE = "grant_type";
    public final static String AUTH_CODE = "authorization_code";
    public final static String CLIENT_CREDENTIAL = "client_credential";
    public final static String ACCESS_TOKEN = "access_token";
    public final static String TYPE = "type";
    public final static String TICKET = "ticket";
    public final static String JS_API = "jsapi";
    public final static String KEFU_DEPARTMENT = "wx.kefu.department";

    public final static int REDIS_WX_KEY_TTL = 3600;  // 单位秒
    public final static String REDIS_FUWU_JSTICKET_KEY = "wx_fw_jsticket";

    public final static String REDIS_APPID_ACCESS_TOKEN = "wx_appid_access_token";

    public final static String USER_ID = "UserId";
    public final static String OPEN_ID = "OpenId";
    public final static String OPEN_id = "openid";
    public final static String NICK_NAME = "nickname";
    public final static String HEAD_IMG_URL = "headimgurl";
    public final static String FROM_USER_NAME = "FromUserName";
    public final static String TO_USER_NAME = "ToUserName";
    public final static String MSG_TYPE = "MsgType";
    public final static String EVENT = "Event";
    public final static String EVENT_TEXT = "text";
    public final static String EVENT_IMAGE = "image";
    public final static String EVENT_LOCATION = "location";
    public final static String EVENT_SUBSCRIBE = "subscribe";
    public final static String EVENT_UNSUBSCRIBE = "unsubscribe";
    public final static String EVENT_SCAN = "scan";
    public final static String EVENT_CLICK = "CLICK";
    public final static String EVENT_VIEW = "VIEW";
    public final static String EVENT_KEY = "EventKey";
    public final static String CREATE_TIME = "CreateTime";
    public final static String LATITUDE = "Latitude";
    public final static String LONGITUDE = "Longitude";
    public final static String CONTENT = "Content";
    public final static String MSGTYPE = "MsgType";
    public final static String MEDIAID = "MediaId";
    public final static String MSGID = "MsgId";
    public final static String AGENTID = "AgentID";
    public final static String PICURL = "PicUrl";
    //public final static String THUMBMEDIAID = "ThumbMediaId";

    public final static String ENTER_AGENT = "enter_agent";


    /**
     * 加密签名, 前台js接口用, SHA-1 加密
     */
    public static String getJsSignature(String ticket, String noncestr, long timestamp, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("jsapi_ticket=").append(ticket);
        sb.append("&noncestr=").append(noncestr);
        sb.append("&timestamp=").append(timestamp);
        sb.append("&url=").append(url);
        return EncodeUtil.getSHA1(sb.toString());
    }

    public static boolean isWeixinBrowser(HttpServletRequest request) {
        String userAgent = RequestUtil.getUserAgent(request);
        String regrex = "MicroMessenger/[0-9]";
        return PatternUtil.isFind(userAgent, regrex);
    }

    public static boolean isWeixinVersionOK(HttpServletRequest request) {
        String userAgent = RequestUtil.getUserAgent(request);
        String regrex = "MicroMessenger/[5-9]";
        return PatternUtil.isFind(userAgent, regrex);
    }

    public static String getPaySignature(Map<String, Object> paraMap) {
        return EncodeUtil.getMD5For32(getSignatureStr(paraMap));
    }

    // key=value1&key2=value2&key3=value3
    public static String getSignatureStr(Map<String, Object> paraMap) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String key : paraMap.keySet()) {
            String value = String.valueOf(paraMap.get(key));
            if (!StringUtil.isNullorEmpty(value)) {
                sb.append((count++) == 0 ? "" : "&").append(key).append("=").append(paraMap.get(key));
            }
        }
        return sb.toString();
    }

    public static String prepPay(String xml) {
        return HttpUtil.post(URL_PAY, xml);
    }

    public static String text(String fromUserName, String toUserName, String content) {
        return send(fromUserName, toUserName, content, "text");
    }

    public static String send(String fromUserName, String toUserName, String content, String msgType) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>");
        sb.append("<CreateTime>").append(DateUtil.getCurrentTimeSecond()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[").append(msgType).append("]]></MsgType>");
        sb.append("<Content><![CDATA[").append(content).append("]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

    public static String sendNews(String fromUserName, String toUserName, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>");
        sb.append("<CreateTime>").append(DateUtil.getCurrentTimeSecond()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[").append("news").append("]]></MsgType>");

        sb.append("<ArticleCount>").append(content).append("</ArticleCount>");
        sb.append("<Articles>");

        sb.append("<item>");
        sb.append("<Title><![CDATA[").append(content).append("]]></Title>");
        sb.append("<Description><![CDATA[").append(content).append("]]></Description>");
        sb.append("<PicUrl><![CDATA[").append(content).append("]]></PicUrl>");
        sb.append("<Url><![CDATA[").append(content).append("]]></Url>");

        sb.append("</item>");
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }

    // 多客服
    public static String duokefu(String fromUserName, String toUserName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>");
        sb.append("<CreateTime>").append(DateUtil.getCurrentTimeSecond()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[transfer_customer_service]]></MsgType>");
        sb.append("</xml>");
        return sb.toString();
    }

    public static String duokefu(String fromUserName, String toUserName, String kfAccount) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<FromUserName><![CDATA[").append(fromUserName).append("]]></FromUserName>");
        sb.append("<ToUserName><![CDATA[").append(toUserName).append("]]></ToUserName>");
        sb.append("<CreateTime>").append(DateUtil.getCurrentTimeSecond()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[transfer_customer_service]]></MsgType>");
        if (StringUtil.isNullorEmpty(kfAccount)) {
            sb.append("<TransInfo>");
            sb.append("<KfAccount><![CDATA[").append(kfAccount).append("]]></KfAccount>");
            sb.append("</TransInfo>");
        }
        sb.append("</xml>");
        return sb.toString();
    }


    public static boolean isLocation(Map<String, String> map) {
        return EVENT_LOCATION.equalsIgnoreCase(map.get(EVENT));
    }

    public static boolean isSubscribe(Map<String, String> map) {
        return EVENT_SUBSCRIBE.equalsIgnoreCase(map.get(EVENT));
    }

    public static boolean isScan(Map<String, String> map) {
        return EVENT_SCAN.equalsIgnoreCase(map.get(EVENT));
    }

    public static boolean isUnSubscribe(Map<String, String> map) {
        return EVENT_UNSUBSCRIBE.equalsIgnoreCase(map.get(EVENT));
    }

    public static boolean isMsgType(Map<String, String> map) {
        return !StringUtil.isNullorEmpty(map.get(MSG_TYPE));
    }

    public static boolean isKefu(Map<String, String> map) {
        return EVENT_CLICK.equalsIgnoreCase(map.get(EVENT)) && "kefu".equals(map.get(EVENT_KEY));
    }

    public static boolean isKefuMess(Map<String, String> map) {
        return EVENT_TEXT.equalsIgnoreCase(map.get(MSG_TYPE)) && "客服".equals(map.get(CONTENT));
    }

    public static boolean isEnterAgent(Map<String, String> map) {
        return ENTER_AGENT.equalsIgnoreCase(map.get(EVENT));
    }

    public static String getContent(Map<String, String> map) {
        return map.get(CONTENT);
    }

    public static String getEventKey(Map<String, String> map) {
        return map.get(EVENT_KEY);
    }

    public static boolean isText(Map<String, String> map) {
        return EVENT_TEXT.equalsIgnoreCase(map.get(MSG_TYPE));
    }

    public static boolean isImage(Map<String, String> map) {
        return EVENT_IMAGE.equalsIgnoreCase(map.get(MSG_TYPE));
    }

    public static String getFromUserName(Map<String, String> map) {
        return map.get(FROM_USER_NAME);
    }

    public static String getToUserName(Map<String, String> map) {
        return map.get(TO_USER_NAME);
    }

    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileEndWitsh(String contentType) {
        String fileEndWitsh = "";
        if ("image/jpeg".equals(contentType))
            fileEndWitsh = ".jpg";
        else if ("audio/mpeg".equals(contentType))
            fileEndWitsh = ".mp3";
        else if ("audio/amr".equals(contentType))
            fileEndWitsh = ".amr";
        else if ("video/mp4".equals(contentType))
            fileEndWitsh = ".mp4";
        else if ("video/mpeg4".equals(contentType))
            fileEndWitsh = ".mp4";
        return fileEndWitsh;
    }

    public static void main(String[] args) {
        System.out.println(URLEncoder.encode("http://beta.fresh.com/wx/getQyAuthCode.action"));

    }
}
