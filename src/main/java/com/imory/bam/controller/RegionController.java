package com.imory.bam.controller;

import java.util.ArrayList;
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
import com.imory.bam.searchDto.RegionDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrderDetail;
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
    public List listSysOrigin(Integer id)
    {   
    	if(id==null){
    		id=-1;
    	}
        //获取当前节点的子节点
    	List<SysRegion> regionInfoSearch = regionService.regionInfoSearch(id);
    	List<Integer>  listIds=new ArrayList<Integer>();
        //获取当前节点下的子节点是否存在子节点 存在则标记 isParent:true  配合上面的方法一起使用
    	for(SysRegion  s:regionInfoSearch){
    		listIds.add(s.getId());
    	}
    	if(listIds.size()>0){
    		List<RegionDto> rList = regionService.regionParentSearch(listIds);
    		for (RegionDto entry : rList) {
    			for(SysRegion  s:regionInfoSearch){
    	    		if(s.getId()==entry.getPid() && entry.getCount() > 0){
    	    			s.setIsParent("true");
    	    		}
    	    	}
    		}
    	}
        return  regionInfoSearch;
    }
    
    
    /**
     * 添加地区节点
     *
     * @return
     */
    @RequestMapping("/addRegionInfo")
    @ResponseBody
    public Map<String, Object> addRegionInfo(SysRegion sysRegion)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(regionService.addRegionInfo(sysRegion)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success", false);
    	 }
    	 return resultMap;
    }
    
    /**
     * 修改节点
     *
     * @return
     */
    @RequestMapping("/editRegionInfo")
    @ResponseBody
    public Map<String, Object> editRegionInfo(SysRegion sysRegion)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(regionService.editRegionInfo(sysRegion)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success", false);
    	 }
    	 return resultMap;
    }
    
    
    /**
     * 删除节点
     *
     * @return
     */
    @RequestMapping("/delRegionInfo")
    @ResponseBody
    public Map<String, Object> delRegionInfo(SysRegion sysRegion)
    {    
    	 Map<String, Object> resultMap = new HashMap<>();
    	 if(regionService.delRegionInfo(sysRegion)>0){
    		 resultMap.put("success", true);
    	 }else{
    		 resultMap.put("success", false);
    	 }
    	 return resultMap;
    }
    
    

}
