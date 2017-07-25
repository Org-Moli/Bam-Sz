package com.imory.bam.sysuser.service;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.searchDto.OrderDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrderDetail;
import com.imory.bam.sysuser.dao.OrderMapper;
import com.imory.bam.utils.SimpleUpdateLangDriver;

/**
 * 
 * @author hushun
 *
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    
    public  int updateDetailOrder(SysOrderDetail orderDetail){
    	return orderMapper.updateDetailOrder(orderDetail);
    }

    public List<SysOrder> orderListSearch(OrderDto  orderDto)
    {
        return orderMapper.orderListSearch(orderDto);
    }
    
    /**
     * 查询总条数
     * @return
     */
    public int countOrder()
    {
        return orderMapper.countOrder();
    }
    
    
    /**
	  * 查询
	  * @param id
	  * @return
	  */
	 public SysOrder getById(Integer id)
	 {
	     return orderMapper.getById(id);
	 }
	 
	 /**
	  * 查询订单明细
	  * @param orderNum
	  * @return
	  */
	 public List<SysOrderDetail> getByIdofDetail(String orderNum){
		 return orderMapper.getByIdofDetail(orderNum);
	 }
	 
	 
	 
	   /**
	    * 更新
	    *
	    * @param sysOrigin
	    * @return
	    */
	   public int updateById(SysOrder sysOrder)
	   {
	       return orderMapper.updateById(sysOrder);
	   }
	   
	   
	   /**
	    * 反审核
	    *
	    * @param sysOrigin
	    * @return
	    */
	   public int fshById(Integer id)
	   {
	       return orderMapper.fshById(id);
	   }
	   
	   /**
	    * 删除
	    * @param ids
	    * @return
	    */
	   public int deleteById(List<Integer> idList){
		   return orderMapper.deleteById(idList);
	   }
	   
	   /**
	    * 审核
	    * @param ids
	    * @return
	    */
	   public int chenckById(List<Integer> idList){
		   return orderMapper.chenckById(idList);
	   }
	   
	   public  int updateSysOrderDetailOfJpa(SysOrderDetail sysOrderDetail){
		   return orderMapper.updateSysOrderDetailOfJpa(sysOrderDetail);
	   }
	   
	   public  int updateSysOrderOfJpa(SysOrder sysOrder){
		   return orderMapper.updateSysOrderOfJpa(sysOrder);
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


}
