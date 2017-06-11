package com.fresh.model;

import java.util.List;

/*
 * 返回信息
 */
public class Message {

    public final static int STATUS_SUCCESS = 0;
    public final static int STATUS_FAIL = 1;
    public final static int STATUS_SYSTEM_ERROR = 2;

    private int status;         // 返回状态
    private String message;     // 返回信息
    private Object data;        // 返回数据
    private List<Object> dataList; // 返回数据集合

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
