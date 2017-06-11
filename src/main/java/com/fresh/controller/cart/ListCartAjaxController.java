package com.fresh.controller.cart;

import com.fresh.common.util.Json.JsonUtil;
import com.fresh.controller.food.BaseFoodController;
import com.fresh.model.CommonJsonObject;
import com.fresh.model.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 购物车
 *
 * @author XCG
 * @since 2017/5/19.
 */
@Controller
@RequestMapping(value = "/cart")
public class ListCartAjaxController extends BaseCartController {
    /**
     * 购物车列表
     *
     * @throws Exception
     */
    @RequestMapping("getCartList")
    public void getCartList(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        //根据物品Id去查询购物车是否已有该物品
        List<PageData> list = cartService.list(pd);
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("购物车列表");
        commonJsonObject.setData(list);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }

}
