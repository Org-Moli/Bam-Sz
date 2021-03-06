package com.imory.bam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.searchDto.OrderDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrderDetail;
import com.imory.bam.sysuser.service.OrderService;

/**
 * 
 * @author hushun
 *
 */
@Controller
@RequestMapping("/bam/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

    @RequestMapping("/orderList")
    public String sysOriginList()
    {
        return "/bam/orderList";
    }
    
    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/orderListSearch")
    @ResponseBody
    public String listSysOrigin(OrderDto  orderDto)
    {   
        List<SysOrder> orderList = orderService.orderListSearch(orderDto);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(orderList));
        jsonObject.put("draw", orderDto.getDraw());
        jsonObject.put("recordsTotal", orderList.size());
        jsonObject.put("recordsFiltered", orderService.countOrder());
        return jsonObject.toJSONString();
    }
    
    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    @ResponseBody
    public String getById(Integer id)
    {
    	SysOrder sysOrder = orderService.getById(id);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("order", JSON.toJSON(sysOrder));
    	if(sysOrder!=null && StringUtils.isNotBlank(sysOrder.getOrderNum())){
    		//再查询订单明细内容
        	List<SysOrderDetail> byIdofDetail = orderService.getByIdofDetail(sysOrder.getOrderNum());
        	jsonObject.put("orderDetail", JSON.toJSON(byIdofDetail));
    	}
        return jsonObject.toJSONString();
    }
    
    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/updateDetailOrder")
    @ResponseBody
    public Map<String, Object> updateDetailOrder(SysOrderDetail orderDetail)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(orderService.updateDetailOrder(orderDetail)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success", false);
    	 }
    	 return resultMap;
    }
    
    
    
    
    @RequestMapping("/updateOrder")
    @ResponseBody
    public Map<String, Object> updateOrder(SysOrder sysOrder)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	if(sysOrder==null){
    		 resultMap.put("success", false);
    	}else{
    		 if(null==sysOrder.getId()){
    			 resultMap.put("success", false);
    			 resultMap.put("errorMsg","ID值为空，修改失败");
    		 }else{
    			  if(orderService.updateById(sysOrder)>0){
    				  resultMap.put("success", true);
    			  }else{
    				  resultMap.put("success", false);
    				  resultMap.put("errorMsg","编辑失败");
    			  }
    		 }
    	}
        return resultMap;
    }
    
    @RequestMapping("/fshById")
    @ResponseBody
    public Map<String, Object> fshById(Integer id)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(orderService.fshById(id)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success",false);
    	 }
         return resultMap;
    }
    
    @RequestMapping("/deleteById")
    @ResponseBody
    public Map<String, Object> deleteById(@RequestParam("idList[]") List<Integer> idList)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(orderService.deleteById(idList)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success",false);
    	 }
         return resultMap;
    }
    
    @RequestMapping("/chenckById")
    @ResponseBody
    public Map<String, Object> chenckById(@RequestParam("idList[]") List<Integer> idList)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(orderService.chenckById(idList)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success",false);
    	 }
         return resultMap;
    }
    

}
