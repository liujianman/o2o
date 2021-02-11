package com.kgy.o2o.service;

import com.kgy.o2o.entity.HeadLine;

import java.util.List;

public interface HeadLineService {
     /**
      * 返回头条列表
      * @date 2018/3/18 14:53
      * @param   headLineCondition
      * @return   getHeadLineList
      */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition)throws Exception;
}
