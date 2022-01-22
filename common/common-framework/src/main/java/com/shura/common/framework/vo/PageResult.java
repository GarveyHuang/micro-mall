package com.shura.common.framework.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 分页结果返回对象
 */
public final class PageResult<T> implements Serializable {

    /**
     * 数据列表
     */
    private List<T> list;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
