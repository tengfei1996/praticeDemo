package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.common.ResponseModel;
import com.example.demo.service.OdBusiNotelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getTableData")
    public ResponseModel getTableData(){
        return new ResponseModel(odBusiNotelogService.list(new QueryWrapper<>()));
    }
}

