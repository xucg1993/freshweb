package com.fresh.controller;

import com.fresh.common.controller.BaseController;
import com.fresh.common.util.Json.JsonUtil;
import com.fresh.common.util.constant.Constant;
import com.fresh.common.util.string.StringUtil;
import com.fresh.model.CommonJsonObject;
import com.fresh.model.Message;
import com.fresh.model.PageData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Properties;

/**
 * app基础类
 *
 * @author lq
 * @since 17/5/9
 */
public class BaseFreshController extends BaseController {

    private Logger log = Logger.getLogger(BaseFreshController.class);

    protected static final String STATUS_ERROR = "0";    //结果状态，失败
    protected static final String STATUS_SUCCESS = "1";    //结果状态，成功


    @Autowired
    protected Properties systemConfig;

    public Message buildMessage(int status, String message) {
        Message m = new Message();
        m.setStatus(status);
        m.setMessage(message);
        return m;
    }

    public Message buildMessage(int status, String message, Object data) {
        Message m = new Message();
        m.setStatus(status);
        m.setMessage(message);
        m.setData(data);
        return m;
    }

    public Message buildMessage(int status, String message, List<Object> dataList) {
        Message m = new Message();
        m.setStatus(status);
        m.setMessage(message);
        m.setDataList(dataList);
        return m;
    }

    public Message buildSuccessMessage() {
        Message message = new Message();
        message.setStatus(Message.STATUS_SUCCESS);
        message.setMessage("成功");
        return message;
    }

    public Message buildFailMessage() {
        Message message = new Message();
        message.setStatus(Message.STATUS_FAIL);
        message.setMessage("失败");
        return message;
    }

    public Message buildSystemErrorMessage() {
        Message message = new Message();
        message.setStatus(Message.STATUS_SYSTEM_ERROR);
        message.setMessage("系统错误");
        return message;
    }

    public ModelAndView errorModel() {
        return new ModelAndView("redirect:" + formatUrlForM(""));
    }

    public ModelAndView redirectModel(String url) {
        return new ModelAndView("redirect:" + url);
    }

    public String getConfigProperty(String key, String defaultValue) {
        return systemConfig.getProperty(key, defaultValue);
    }

    protected String formatUrlForM(String url) {
        return String.format("http://%s/%s", systemConfig.getProperty("url.m"), url);
    }

    protected String getProperty(String key) {
        return systemConfig.getProperty(key);
    }

    /**
     * 验证用户是否登录
     *
     * @param str
     * @param response
     * @author Xucg
     */
    public boolean validateLogon(String str, HttpServletResponse response) {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        if (StringUtil.isNullorEmpty(str)) {
            commonJsonObject.setErrorCode("1");
            commonJsonObject.setMessage("用户未登录");
            outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
            return false;
        }
        return true;
    }

    /**
     * 验证用户信息
     *
     * @param str
     * @param response
     * @author Xucg
     */
    public boolean authenticatedUser(String str, HttpServletResponse response) throws Exception {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        PageData pageData = new PageData();
        pageData.put("USERNAME", str);
//        PageData byAppUserName = staffService.findByAppUserName(pageData);
//        if (byAppUserName == null) {
        commonJsonObject.setErrorCode("1");
        commonJsonObject.setMessage("获取用户信息失败");
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
        return false;
//        }
//        return true;
    }

    /**
     * 参数是否缺失
     *
     * @param str
     * @param response
     * @author Xucg
     */
    public boolean parameterVerification(String str, HttpServletResponse response) {
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        if (StringUtil.isNullorEmpty(str)) {
            commonJsonObject.setErrorCode("1");
            commonJsonObject.setMessage("参数缺失");
            outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
            return false;
        }
        return true;
    }

    /**
     * 取服务器IP地址
     *
     * @return
     */
    public String getServerAddress() {
        return getProperty(Constant.SERVER_ADDRESS);
    }

}
