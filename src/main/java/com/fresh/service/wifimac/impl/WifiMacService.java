package com.fresh.service.wifimac.impl;

import com.fresh.dao.DaoSupport;
import com.fresh.model.PageData;
import com.fresh.service.wifimac.WifiMacManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明： mac监测
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
@Service("wifimacService")
public class WifiMacService implements WifiMacManager {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception {
        dao.save("WifiMacMapper.save", pd);
    }

    @Override
    public int listByDayCount(PageData pd) throws Exception {
        return (Integer)dao.findForObject("WifiMacMapper.listByDayCount",pd);
    }

    @Override
    public int listByDayEnterCount(PageData pd) throws Exception {
        return (Integer)dao.findForObject("WifiMacMapper.listByDayEnterCount",pd);
    }
}

