package com.example.demo.model.common;

import lombok.Data;

import java.util.List;

/**
 * @author ntf
 * @version 1.0
 * @date 2021/5/11 15:54
 * @description 分页结果
 * @className PagingResultModel
 **/
@Data
public class PagingResultModel<T> {
    private Long total;
    private List<T> list;
}
