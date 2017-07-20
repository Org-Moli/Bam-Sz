package com.imory.bam.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.service.OrderService;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/20
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
    public String listSysOrigin(@Param("draw") int draw, @Param("start") int start ,@Param("length") int length)
    {
        List<SysOrder> orderList = orderService.orderListSearch(start, length);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(orderList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", orderList.size());
        jsonObject.put("recordsFiltered", orderService.countOrder());
        return jsonObject.toJSONString();
    }

}
