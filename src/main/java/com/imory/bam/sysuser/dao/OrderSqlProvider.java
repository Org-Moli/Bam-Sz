package com.imory.bam.sysuser.dao;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.imory.bam.searchDto.OrderDto;

/**
 * 
 * @author Hans
 *
 */
public class OrderSqlProvider {
	
	  public String searchList(OrderDto orderDto)
	    {
	        StringBuffer sql = new StringBuffer();
	        sql.append("select * from sys_order where 1 = 1\n");
	        if (orderDto!=null)
	        {    
	        	if(orderDto.getDraw()==null){
	        		orderDto.setDraw(1);
	        	}
	        	if(orderDto.getStart()==null){
	        		orderDto.setStart(0);
	        	}
	        	if(orderDto.getLength()==null){
	        		orderDto.setLength(10);
	        	}
	        	if(null!=orderDto.getOrderStatus()){//订单状态：审核  未审核
	        		sql.append(" and audit_status = "+orderDto.getOrderStatus()+" \n");
	        	}
	        	if(StringUtils.isNoneBlank(orderDto.getStartTime())){
	        		sql.append(" and create_date  >='"+orderDto.getStartTime()+"' \n");
	        	}
	        	if(StringUtils.isNoneBlank(orderDto.getEndTime())){
	        		sql.append(" and create_date  < '"+orderDto.getEndTime()+"'  \n");
	        	}
	        	if(null!=orderDto.getSearchTag()){
	        		if(0==orderDto.getSearchTag()){//订单编号
	        			sql.append(" and orderNum  like '%"+orderDto.getSearchTxt()+"%' \n");
	        		}
	        		if(1==orderDto.getSearchTag()){//trans_user_name
	        			sql.append(" and trans_user_name  like '%"+orderDto.getSearchTxt()+"%' \n");
	        		}
	        	}
	        }
	        sql.append("limit "+orderDto.getStart()+","+orderDto.getLength());
	        return sql.toString();
	    }
}
