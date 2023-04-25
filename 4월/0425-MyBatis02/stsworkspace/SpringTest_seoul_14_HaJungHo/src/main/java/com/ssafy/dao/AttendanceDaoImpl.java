package com.ssafy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AttendanceDaoImpl implements AttendanceDao{
    @Autowired
    DataSource ds;
}
