package com.fresh.controller.wifirecv;
import com.fresh.controller.BaseFreshController;
import com.fresh.service.wifimac.WifiMacManager;

import javax.annotation.Resource;

/**
 * 消息列表基础Controller
 *
 * @author XCG
 * @since 2017/5/8.
 */

public class BaseWifiMacController extends BaseFreshController {
    public static final int DEFAULT_PORT = 9002;//
    public static final int MAX_MSG_LEN = 1600; //
    public String ENTER_NUM = "-62"; //

    @Resource(name = "wifimacService")
    protected WifiMacManager wifiMacService;
}
