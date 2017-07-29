package com.imory.bam.sysuser.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.searchDto.RegionDto;
import com.imory.bam.sysuser.bean.SysRegion;
import com.imory.bam.sysuser.dao.RegionMapper;

/**
 * 
 * @author hushun
 *
 */
@Service
public class RegionService {

    @Autowired
    private RegionMapper regionMapper;
    
    /**
     * 查询当前节点下的子节点
     * @param startPos
     * @param maxRows
     * @return
     */
    public List<SysRegion> regionInfoSearch(Integer  pid)
    {
        return regionMapper.regionInfoSearch(pid);
    }
    
    /**
	 * 查询当前子节点下是否存在子节点
	 * @param list
	 * @return
	 */
    public List<RegionDto> regionParentSearch(List<Integer>  ids)
    {
        return regionMapper.regionParentSearch(ids);
    }
    
    public int addRegionInfo(SysRegion sysRegion){
    	 return regionMapper.addRegionInfo(sysRegion);
    }
    
    public int editRegionInfo(SysRegion sysRegion){
   	 return regionMapper.editRegionInfo(sysRegion);
    }
    
    
    public int delRegionInfo(SysRegion sysRegion){
      	 return regionMapper.delRegionInfo(sysRegion);
    }
    
    
    
    



}
