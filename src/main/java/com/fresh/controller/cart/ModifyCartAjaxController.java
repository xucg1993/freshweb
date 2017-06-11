package com.fresh.controller.cart;

import com.fresh.common.util.Json.JsonUtil;
import com.fresh.model.CommonJsonObject;
import com.fresh.model.PageData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 购物车
 *
 * @author lq
 * @since 17/5/9
 */
@Controller
@RequestMapping("cart")
public class ModifyCartAjaxController extends BaseCartController {

    private Logger log = Logger.getLogger(ModifyCartAjaxController.class);

    /**
     * 购物车
     *
     * @throws Exception
     */
    @RequestMapping("insertCart")
    public void insertCart(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        //根据物品Id去查询购物车是否已有该物品
        PageData pa = cartService.findByGoodsId(pd);
        if (pa == null) {
            pd.put("cartid", this.get32UUID());
            cartService.save(pd);
        } else {
            Double weightnumber1 = Double.parseDouble(pa.get("weightnumber").toString());
            Double price1 = Double.parseDouble(pa.get("price").toString());

            Double weightnumber2 = Double.parseDouble(pd.get("weightnumber").toString());
            Double price2 = Double.parseDouble(pd.get("price").toString());

            pd.put("weightnumber", weightnumber1 + weightnumber2);
            pd.put("price", price1 + price2);
            cartService.editByGoodsId(pd);
        }
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("加入购物车成功");
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @RequestMapping("editCartList")
    public void editCartList(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        cartService.editByGoodsId(pd);
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("修改成功");
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }
    /**
     * 删除
     *
     * @throws Exception
     */
    @RequestMapping("deleteGoods")
    public void deleteGoods(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        cartService.deleteGoods(pd);
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("删除成功");
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }
}
