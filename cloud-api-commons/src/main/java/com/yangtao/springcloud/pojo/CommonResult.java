package com.yangtao.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：杨涛
 * @create: 2021-04-08 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T t;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
