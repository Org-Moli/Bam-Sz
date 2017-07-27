package com.imory.bam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.imory.bam.sysuser.bean.SysRegion;
import com.imory.bam.sysuser.service.OrderService;
import com.imory.bam.sysuser.service.RegionService;

/**
 * 
 * @author hushun
 *
 */
@Controller
@RequestMapping("/bam/region")
public class RegionController {
	
	@Autowired
	private RegionService regionService;

    @RequestMapping("/index")
    public String sysOriginList()
    {
        return "/bam/region";
    }
    
    /**
     * 查询地区目录
     *
     * @return
     */
    @RequestMapping("/regionInfoSearch")
    @ResponseBody
    public String listSysOrigin(Integer  pid)
    {   
//        List<SysRegion> regionInfoSearch = regionService.regionInfoSearch(pid);
//        System.out.println(regionInfoSearch);
    	
         String x="[{ id:1, pId:0, name:'父节点 1', open:true},{ id:11, pId:1, name:'叶子节点 1-1'},{ id:12, pId:1, name:'叶子节点 1-2'},{ id:13, pId:1, name:'叶子节点 1-3'},{ id:2, pId:0, name:'父节点 2', open:true},{ id:21, pId:2, name:'叶子节点 2-1'},{ id:22, pId:2, name:'叶子节点 2-2'},{ id:23, pId:2, name:'叶子节点 2-3'},{ id:3, pId:0, name:'父节点 3', open:true},{ id:31, pId:3, name:'叶子节点 3-1'},{ id:32, pId:3, name:'叶子节点 3-2'},{ id:33, pId:3, name:'叶子节点 3-3'}]";
        return  x;
    }
    
    

}
