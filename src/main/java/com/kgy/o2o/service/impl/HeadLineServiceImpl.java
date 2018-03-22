package com.kgy.o2o.service.impl;

import com.kgy.o2o.dao.HeadLineDao;
import com.kgy.o2o.entity.HeadLine;
import com.kgy.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: ljm
 * @create: 2018-03-18 14:58
 **/
@Service
public class HeadLineServiceImpl implements HeadLineService {

    @Autowired
    private HeadLineDao headLineDao;

     /**
      * @author ljm
      * @date 2018/3/18 14:58
      * 实现
      * @return
      */
    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws Exception {
        return headLineDao.queryHeadLine(headLineCondition);
    }
}
