package com.fresh.service.cart;

import com.fresh.model.PageData;

import java.util.List;

/**
 * 说明： 购物车
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
public interface CartManager {

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception;

    /**
     * 菜品列表
     */
    public List<PageData> list(PageData pd) throws Exception;
    /**
     * 根据物品Id查询
     */
    public PageData findByGoodsId(PageData pd) throws Exception;
    /**
     * 根据物品Id查询
     */
    public void editByGoodsId(PageData pd) throws Exception;
    /**
     * 根据物品Id删除
     */
    public void deleteGoods(PageData pd) throws Exception;
    /**
     * 按每小时查询进店人数
     */
    public int listByDayEnterCount(PageData pd) throws Exception;
}

