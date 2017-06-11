package com.fresh.controller.food;
import com.fresh.controller.BaseFreshController;
import com.fresh.service.food.FoodManager;

import javax.annotation.Resource;

/**
 * 消息列表基础Controller
 *
 * @author XCG
 * @since 2017/5/8.
 */

public class BaseFoodController extends BaseFreshController {
    @Resource(name = "foodService")
    protected FoodManager foodService;
}
