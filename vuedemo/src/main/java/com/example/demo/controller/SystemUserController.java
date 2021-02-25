package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.base.util.EmptyUtil;
import com.example.demo.model.SystemUser;
import com.example.demo.model.common.ResponseModel;
import com.example.demo.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ningtf
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/systemUser")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @PostMapping("/userLogin")
    public ResponseModel userLogin(@RequestBody SystemUser systemUser){
        ResponseModel responseModel = new ResponseModel();
        QueryWrapper<SystemUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_account",systemUser.getUserAccount());
        wrapper.eq("password",systemUser.getPassword());
        SystemUser user = systemUserService.getOne(wrapper);
        if(EmptyUtil.isEmpty(user)){
            responseModel.setSuccess(false);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setData(user);
        return responseModel;
    }
}

