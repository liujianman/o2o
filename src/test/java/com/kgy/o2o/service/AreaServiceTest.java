package com.kgy.o2o.service;

import com.kgy.o2o.dao.BaseTest;
import com.kgy.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ljm on 2018/1/3.
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList() throws Exception {
        List<Area>areaList = areaService.getAreaList();
        assertEquals("西苑",areaList.get(0).getAreaName());
    }

}