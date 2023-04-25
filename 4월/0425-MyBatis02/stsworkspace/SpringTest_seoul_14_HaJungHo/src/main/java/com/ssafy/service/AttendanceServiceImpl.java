package com.ssafy.service;

import com.ssafy.dao.AttendanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements UserService{
    @Autowired
    AttendanceDao dao;
}
