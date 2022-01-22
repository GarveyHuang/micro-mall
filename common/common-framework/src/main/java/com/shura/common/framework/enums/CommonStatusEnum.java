package com.shura.common.framework.enums;

import com.shura.common.framework.core.IntArrayValuable;

import java.util.Arrays;

/**
 * @Author Garvey
 * @Created 2022/1/22
 * @Description 通用状态值枚举
 */
public enum CommonStatusEnum implements IntArrayValuable {

    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CommonStatusEnum::getStatus).toArray();

    /**
     * 状态值
     */
    private final Integer status;

    /**
     * 状态名称
     */
    private final String name;

    CommonStatusEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }


    @Override
    public int[] array() {
        return ARRAYS;
    }
}
