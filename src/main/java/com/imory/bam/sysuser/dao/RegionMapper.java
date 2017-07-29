package com.imory.bam.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.searchDto.RegionDto;
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
     * 查询当前节点下的子节点
     * @param startPos
     * @param maxRows
     * @return
     */
	@Select({
        "select * from region where pid = #{pid}"
	})
    List<SysRegion> regionInfoSearch(Integer  pid);
	
	/**
	 * 查询当前子节点下是否存在子节点
	 * @param list
	 * @return
	 */
	@Select({
        "select  pid,count(1) count from region where pid in(#{list}) group by pid"
	})
	@Lang(SimpleInLangDriver.class) 
	List<RegionDto> regionParentSearch(List<Integer>  list);
	
	

    @Insert({
            "insert into region (name, pid) ",
            "values (#{name,jdbcType=VARCHAR}, #{pid,jdbcType=INTEGER}) ",
    })
	int addRegionInfo(SysRegion sysRegion);
    
    
    @Update({
        "update  region",
        "set name = #{name,jdbcType=VARCHAR} ",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int editRegionInfo(SysRegion sysRegion);
    
    
    @Delete({
        "delete from region where id = #{id,jdbcType=INTEGER}"
    })
    int delRegionInfo(SysRegion sysRegion);
 
}
