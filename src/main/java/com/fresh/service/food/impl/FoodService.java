package com.fresh.service.food.impl;

import com.fresh.dao.DaoSupport;
import com.fresh.model.Page;
import com.fresh.model.PageData;
import com.fresh.service.food.FoodManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明： 蔬菜类
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
@Service("foodService")
public class FoodService implements FoodManager {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception {
        dao.save("FoodMapper.save", pd);
    }

    @Override
    public List<PageData> list(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("FoodMapper.datalistPage",pd);
    }

    @Override
    public PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("FoodMapper.findById",pd);
    }

    @Override
    public int listByDayEnterCount(PageData pd) throws Exception {
        return (Integer)dao.findForObject("FoodMapper.listByDayEnterCount",pd);
    }
}

