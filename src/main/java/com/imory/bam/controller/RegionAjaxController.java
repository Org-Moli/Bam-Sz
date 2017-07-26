package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysRegion;
import com.imory.bam.sysuser.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 
 * @author hushun
 *
 */
@Controller
@RequestMapping("/bam/regionAjax")
public class RegionAjaxController {
	
	@Autowired
	private RegionService regionService;

    /**
     * 查询地区目录
     *
     * @return
     */
    @RequestMapping("/listRegion")
    @ResponseBody
    public List<SysRegion> listRegion(Integer  pid)
    {
        return regionService.regionInfoSearch(pid);
    }
    
    

}
