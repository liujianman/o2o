package com.kgy.o2o.dao;

import com.kgy.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: ljm
 * @create: 2018-03-18 11:52
 **/
public interface HeadLineDao {
 /**
  * 根据传入的条件查询头条新闻
  * @date 2018/3/18 12:04  
  * @param   headLineCondition
  * @return   queryHeadLine
  */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);


}
