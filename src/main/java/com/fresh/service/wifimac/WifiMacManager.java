package com.fresh.service.wifimac;

import com.fresh.model.PageData;

/**
 * 说明： mac监测
 * 创建人：xucg
 * 创建时间：2017-05-19
 */
public interface WifiMacManager {

    /**
     * 新增
     *
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd) throws Exception;

    /**
     * 按每小时查询
     */
    public int listByDayCount(PageData pd) throws Exception;
    /**
     * 按每小时查询进店人数
     */
    public int listByDayEnterCount(PageData pd) throws Exception;
}

