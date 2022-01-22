package com.shura.common.framework.vo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 分页参数
 */
public class PageParam implements Serializable {

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    private Integer pageNo;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    @Range(min = 1, max = 100, message = "条数范围为 [1, 100]")
    private Integer pageSize;

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
