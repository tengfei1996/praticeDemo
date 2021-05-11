package com.example.demo.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.OdBusiNotelog;
import com.example.demo.dao.OdBusiNotelogDAO;
import com.example.demo.model.common.PagingParams;
import com.example.demo.model.common.PagingResultModel;
import com.example.demo.service.OdBusiNotelogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 消息记录表  服务实现类
 * </p>
 *
 * @author ningtf
 * @since 2021-02-08
 */
@Service
public class OdBusiNotelogServiceImpl extends ServiceImpl<OdBusiNotelogDAO, OdBusiNotelog> implements OdBusiNotelogService {

    @Override
    public PagingResultModel<OdBusiNotelog> getOdBusiNotelogPaingList(PagingParams<OdBusiNotelog> pagingParams) {
        Page page = pagingParams.getPagePlus();
        PagingResultModel pagingList = new PagingResultModel();
        List list = baseMapper.getPagingList(page);
        pagingList.setTotal(page.getTotal());
        pagingList.setList(list);
        return pagingList;
    }
}
