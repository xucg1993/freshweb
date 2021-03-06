package com.fresh.service.food;

import com.fresh.model.Page;
import com.fresh.model.PageData;

import java.util.List;

/**
 * 说明： 蔬菜
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
public interface FoodManager {

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
     * 菜品列表
     */
    public PageData findById(PageData pd) throws Exception;



    /**
     * 按每小时查询进店人数
     */
    public int listByDayEnterCount(PageData pd) throws Exception;
}

