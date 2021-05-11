package com.example.demo.model.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页参数定义
 */
@Data
public class PagingParams<T> {
    private int page;//当前页面
    private int size;//总页数
    private T queryParam;
    private String orderParam;//排序字段
    private String orderType;//排序类型 desc/asc

    //获取mybatisPlus封装的Page对象
    public Page<T> getPagePlus() {
        Page<T> pagePlus = new Page();
        pagePlus.setCurrent(this.page);
        pagePlus.setSize(this.size);
        if (this.orderParam != null && this.orderParam != "") {
            if (this.orderType.toUpperCase().equals("ASC")) {
                pagePlus.setAsc(orderParam);
            } else if (this.orderType.toUpperCase().equals("DESC")) {
                pagePlus.setDesc(orderParam);
            }
        }
        return pagePlus;
    }
}
