package com.example.demo.serviceImpl;

import com.example.demo.model.SystemUser;
import com.example.demo.dao.SystemUserDAO;
import com.example.demo.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ningtf
 * @since 2021-02-07
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserDAO, SystemUser> implements SystemUserService {

}
