package com.imory.bam.sysuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.searchDto.OrderDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysRegion;
import com.imory.bam.sysuser.dao.OrderMapper;
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

    public List<SysRegion> regionInfoSearch(Integer  pid)
    {
        return regionMapper.regionInfoSearch(pid);
    }



}
