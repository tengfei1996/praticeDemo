package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.OdBusiNotelog;
import com.example.demo.model.common.PagingParams;
import com.example.demo.model.common.ResponseModel;
import com.example.demo.service.OdBusiNotelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 消息记录表  前端控制器
 * </p>
 *
 * @author ningtf
 * @since 2021-02-08
 */
@RestController
@RequestMapping("/odBusiNotelog")
public class OdBusiNotelogController {

    @Autowired
    OdBusiNotelogService odBusiNotelogService;

    @PostMapping("/getTableData")
    public ResponseModel getTableData(@RequestBody PagingParams<OdBusiNotelog> pagingParams){
        return new ResponseModel(odBusiNotelogService.getOdBusiNotelogPaingList(pagingParams));
    }
}

