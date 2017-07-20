package com.imory.bam.sysuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.dao.OrderMapper;

/**
 * 
 * @author hushun
 *
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<SysOrder> orderListSearch(Integer startPos, Integer maxRows)
    {
        return orderMapper.orderListSearch(startPos, maxRows);
    }
    
    /**
     * 查询总条数
     * @return
     */
    public int countOrder()
    {
        return orderMapper.countOrder();
    }
    
    
    
//
//    /**
//     * 保存
//     *
//     * @param sysOrigin
//     * @return
//     */
//    public int insert(SysOrigin sysOrigin)
//    {
//        return OrderMapper.insert(sysOrigin);
//    }
//
//    /**
//     * 查询
//     * @param id
//     * @return
//     */
//    public SysOrigin getById(Integer id)
//    {
//        return OrderMapper.getById(id);
//    }
//
//    /**
//     * 更新
//     *
//     * @param sysOrigin
//     * @return
//     */
//    public int updateById(SysOrigin sysOrigin)
//    {
//        return OrderMapper.updateById(sysOrigin);
//    }
}
