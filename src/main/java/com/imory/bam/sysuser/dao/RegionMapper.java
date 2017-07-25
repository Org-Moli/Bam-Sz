package com.imory.bam.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.searchDto.OrderDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrigin;
import com.imory.bam.sysuser.bean.SysRegion;
import com.imory.bam.utils.SimpleInLangDriver;

/**
 * 
 * @author hushun
 *
 */
@Mapper
public interface RegionMapper {

    /**
     * 分页查询匹配数据内容
     * @param startPos
     * @param maxRows
     * @return
     */
	@Select({
        "select * from region where pid = #{pid}"
	})
    List<SysRegion> regionInfoSearch(Integer  pid);
 
}
