package com.kgy.o2o.service;

import com.kgy.o2o.entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ljm on 2018/1/3.
 */
public interface AreaService {
    List<Area> getAreaList();
}
