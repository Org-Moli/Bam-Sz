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
        List<SysRegion> regionInfoSearch = regionService.regionInfoSearch(pid);
        System.out.println(regionInfoSearch);
        return  null;
    }
    
    

}
