package com.example.demo.service;

import com.example.demo.model.OdBusiNotelog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.common.PagingParams;
import com.example.demo.model.common.PagingResultModel;

/**
 * <p>
 * 消息记录表  服务类
 * </p>
 *
 * @author ningtf
 * @since 2021-02-08
 */
public interface OdBusiNotelogService extends IService<OdBusiNotelog> {
    PagingResultModel<OdBusiNotelog> getOdBusiNotelogPaingList(PagingParams<OdBusiNotelog> pagingParams);
}
