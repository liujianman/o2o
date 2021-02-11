package com.kgy.o2o.dao;

import com.kgy.o2o.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ljm on 2018/1/3.
 */
@Repository
public interface AreaDao{
    /**
     * 列出所有区域
     *
     * @return
     */
    List<Area> queryArea();
}
