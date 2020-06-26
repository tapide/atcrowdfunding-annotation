package com.atguigu.crowd.service;

import com.atguigu.crowd.bean.Admin;
import com.atguigu.crowd.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    private AdminMapper adminMapper;

    @Transactional
    public int addAdmin(Admin admin){
        return adminMapper.insert(admin);
    }

    @Transactional(readOnly = true)
    public Admin getAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
