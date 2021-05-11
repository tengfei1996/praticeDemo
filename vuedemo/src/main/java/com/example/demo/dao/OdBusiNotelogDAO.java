package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.OdBusiNotelog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 消息记录表  Mapper 接口
 * </p>
 *
 * @author ningtf
 * @since 2021-02-08
 */
public interface OdBusiNotelogDAO extends BaseMapper<OdBusiNotelog> {

    List<OdBusiNotelog> getPagingList(Page<OdBusiNotelog> page);
}
