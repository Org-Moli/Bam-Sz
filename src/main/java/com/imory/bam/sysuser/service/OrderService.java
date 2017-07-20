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
