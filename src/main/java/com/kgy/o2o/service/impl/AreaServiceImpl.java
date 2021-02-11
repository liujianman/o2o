package com.kgy.o2o.service.impl;

import com.kgy.o2o.dao.AreaDao;
import com.kgy.o2o.entity.Area;
import com.kgy.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ljm on 2018/1/3.
 */
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
