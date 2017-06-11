package com.fresh.common.util.constant;

public class Constant {
    public final static String COMPANY_LOGO_PATH = "company.logo.path";
    public final static String SERVER_ADDRESS = "server.address";
    public final static String DEFAULT_SPLITER = ",";
    public final static String SKU_NUMBER_SPLITER = "_";
    public final static String HTML_LF = "<br/>";

    public final static int MONEY_YUAN_FEN_RATE = 100;     //元与分的比率
    public final static int DISCOUNT_CONVER = 10;          //折扣换算率

    public final static String POST = "POST";
    public final static String GET = "GET";

    public final static String LOCATION_PREFIX = "location_";
    public final static int LOCATION_TTL = 30 * 60;
    public final static int QRCODE_VALIDITY_TIME = 2 * 24 * 60 * 60;

    public final static String GBK_ENCODING = "GBK";
    public final static String UTF8_ENCODING = "UTF-8";

    public final static String SUCCESS = "1";
    public final static String ERROR = "0";

    public static final String DEFAULT_IMG_SUBFIX = ".jpg";

    public final static int TICKET_BATCH_NO_LENGTH = 2;
    public final static int TICKET_ID_SUBFIX_LENGTH = 8;
    public final static int CODE_SINGLE_LENGTH = 6;
    public final static int CODE_MULTIPLE_LENGTH = 4;

    public final static String MD5 = "MD5";
    public final static String SHA1 = "SHA-1";

    public final static String JSON = "json";
    public final static String XML = "xml";

    public final static String COOKIE_ORDER = "bx_tmp_order2";              //临时订单机构、配送方式、支付方式等信息
    public final static String COOKIE_ORDER_SKU = "bx_tmp_order_skus2";         //临时订单SKU清单
    public final static String COOKIE_ORDER_BUCKET = "bx_tmp_order_buckets2";      //临时订单桶清单
    public final static String COOKIE_ORDER_TRADE = "bx_tmp_order_trades2";       //临时订单商品券兑换信息
    public final static String COOKIE_ORDER_TRADE_LABEL = "bx_tmp_order_trades_label2"; //临时订单商品券兑换信息描述
    public final static String COOKIE_ORDER_TRADE_FIRST = "bx_tmp_order_trades_frist2"; //临时订单首次购买商品券及兑换信息
    public final static String COOKIE_ORDER_TICKET = "bx_tmp_order_ticket2";       //临时订单使用的优惠券信息

    public final static String COOKIE_SERVICE_BUCKET = "bx_tmp_service_bucket";      //售后服务-退桶
    public final static String COOKIE_USER = "qykefu_user";
    public final static String WEBSOCKET_KEFU = "websocket_qykefu";                       //websocket多客服
    public final static String COOKIE_USER_TOKEN = "user_token";                        //登录用户TOKEN

    public final static String COOKIE_KEFU_USER = "cookie_qykefu_user";                   //客服cookie
    public final static String COOKIE_KEFU_TOKEN = "cookie_qykefu_token";                 //客服cookie
    public final static String QYKEFU_DEPARTMENT = "wx.qykefu.department";


    public final static String COOKIE_ADMIN_USERID = "adminuserid";                     //后台用户id
    public final static String COOKIE_ADMIN_USERNAME = "adminusername";                 //后台用户name
    public final static String COOKIE_ADMIN_TOKEN = "admintoken";                       //后台用户token
    public final static String TOKEN_SIGN = "f32abs3.32@$fdsfw";                        //后台用户token的签名
    public final static int COOKIE_ADMIN_TTL = 4 * 60 * 60;                             //后台用户失效时间


    public final static String REDIS_QRCODE_CODE = "qrcode_";

    public final static String REDIS_WX_NEWS = "wx_news";

    public final static String REDIS_WX_REPLY_KEY = "wx_reply_key";
    public final static String REDIS_WX_REPLY = "wx_reply";
    public final static String REDIS_WX_MENU = "wx_menu";

    public final static String REDIS_SYS_PIC = "sys_pic";

    public final static String REDIS_KEFU_USER_PREFIX = "qykefu_user_";
    public final static String REDIS_KEFU_USER_MAP = "qykefu_user_map";

    public final static String REDIS_KEFU_ACCOUNT_PREFIX = "qykefu_account_";

    public final static String REDIS_KEFU_AUTH_KEY = "qykefu_auth_";
    public final static String REDIS_ORIGINAL_ID_KEY = "originalid_";
    public final static String REDIS_ALL_USER_MAP_KEY = "qykefu_all_user_map";

    public final static String REDIS_KEFU_SEND_NEWS_PREFIX = "qykefu_sendnews_";
    public final static int REDIS_KEFU_SEND_NEWS_TTL = 5 * 60;

    public final static String REDIS_KEFU_USER_SESSION = "qykefu_user_session_";
    public final static String REDIS_KEFU_QUEUE = "qykefu_queue_";
    public final static String REDIS_KEFU_QUEUE_STATUS = "qykefu_queue_status_";
    public final static String REDIS_KEFU_TEMP_STATUS = "qykefu_temp_status_";
    public final static String REDIS_AGENT_MAP = "qykefu_agent_map";

    public final static String DOMAIN = "tcl.com";

    public final static String SMS_TYPE_REGIST = "1";               // 注册时发验证码
    public final static String SMS_TYPE_RESET_LOGIN_PWD = "2";      // 重置密码
    public final static String SMS_TYPE_AUTH_MOBILE = "3";          // 注册时,验证手机号
    public final static String SMS_TYPE_PAY_PWD = "4";              // 设置支付密码
    public final static String SMS_TYPE_RESET_PAY_PWD = "5";        // 重置支付密码
    public final static String SMS_TYPE_WX_AUTHMOBILE = "6";        // 微信,验证手机号
    public final static String SMS_TYPE_LOGIN_DYNAMIC = "7";        // 手机动态密码登录
    public final static String SMS_TYPE_RECEIVE_CODE = "8";         // 收货码/提货码
    public final static String REGREX_SMS_TYPE = "^[1-8]$";         // 短信类型的 正则

    public final static String SMS_TYPE_PREFIX = "smstype_";
    public final static int SMS_TTL_SECONDS = 5 * 60 + 30;              // 验证码时效，五分钟
    public final static int SMS_RECEIVE_CODE_TTL_SECONDS = 7 * 24 * 3600; // 收货码验证码时效，7天


    public final static String LOCATION_FROM_URL = "location_fromurl";

    public final static String REDIS_NEW_ORGA_LIST = "list_new_orga";

    public final static String WEIXIN_URL_PREFIX = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4467aa07da8ef690&redirect_uri=http%3A%2F%2Fm.tcl.com%2Fwx%2FgetSnsAuthCode.action&response_type=code&scope=snsapi_base&state=";
    public final static String WEIXIN_URL_SUBFIX = "#wechat_redirect";

    public final static String SHORT_URL = "http://www.waisir.com/t.cn/";

    public final static String REDIS_SURVEY_MAP = "survey_user";

    public final static String REDIS_SUPER_USERS = "super_user";    // 超级用户，逗号隔开

    public final static String QRSENCE = "qrscene_";                // 带参数的二维码：用户第一次关注时的eventkey的前缀
    public final static int DEFAULT_CHANNELID = 1;                  // 默认的黑小伙的渠道

    public final static String ACTI_ANALYSE_UPDATE_TIME = "acti_analyse_updatetime";     // 活动分析更新的时间

}
