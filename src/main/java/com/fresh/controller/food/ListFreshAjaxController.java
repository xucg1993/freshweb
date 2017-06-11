package com.fresh.controller.food;

import com.fresh.common.util.Json.JsonUtil;
import com.fresh.model.CommonJsonObject;
import com.fresh.model.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 菜品
 *
 * @author XCG
 * @since 2017/5/19.
 */
@Controller
@RequestMapping(value = "/food")
public class ListFreshAjaxController extends BaseFoodController {
    /**
     * 菜品列表
     *
     * @throws Exception
     */
    @RequestMapping("getFoodList")
    public void getFoodList(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        List<PageData> list = foodService.list(pd);
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("菜类列表");
        commonJsonObject.setData(list);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }
    /**
     * id查询
     */
    @RequestMapping("getFoodByFoodId")
    public void getFoodByFoodId(HttpServletResponse response) throws Exception {
        PageData pd = this.getPageData();
        PageData pa = foodService.findById(pd);
        CommonJsonObject commonJsonObject = new CommonJsonObject();
        commonJsonObject.setErrorCode("0");
        commonJsonObject.setMessage("菜品详情");
        commonJsonObject.setData(pa);
        outWriteUTF8(response, JsonUtil.toJson(commonJsonObject));
    }
}
