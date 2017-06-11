package com.fresh.service.cart.impl;

import com.fresh.dao.DaoSupport;
import com.fresh.model.PageData;
import com.fresh.service.cart.CartManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明：购物车
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
@Service("cartService")
public class CartService implements CartManager {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception {
        dao.save("CartMapper.save", pd);
    }

    @Override
    public List<PageData> list(PageData pd) throws Exception {
        return (List<PageData>)dao.findForList("CartMapper.datalistPage",pd);
    }

    @Override
    public PageData findByGoodsId(PageData pd) throws Exception {
        return (PageData) dao.findForObject("CartMapper.findByGoodsId",pd);
    }
    @Override
    public void editByGoodsId(PageData pd) throws Exception {
         dao.update("CartMapper.editByGoodsId",pd);
    }
    @Override
    public void deleteGoods(PageData pd) throws Exception {
        dao.delete("CartMapper.deleteGoods",pd);
    }

    @Override
    public int listByDayEnterCount(PageData pd) throws Exception {
        return (Integer)dao.findForObject("CartMapper.listByDayEnterCount",pd);
    }
}

