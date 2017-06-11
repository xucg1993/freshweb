package com.fresh.controller.cart;
import com.fresh.controller.BaseFreshController;
import com.fresh.service.cart.CartManager;
import com.fresh.service.food.FoodManager;

import javax.annotation.Resource;

/**
 * 消息列表基础Controller
 *
 * @author XCG
 * @since 2017/5/8.
 */

public class BaseCartController extends BaseFreshController {
    @Resource(name = "cartService")
    protected CartManager cartService;
}
