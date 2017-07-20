package com.imory.bam.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrigin;

/**
 * 
 * @author hushun
 *
 */
@Mapper
public interface OrderMapper {

    @Insert({
            "insert into sys_origin (area, acronym, ",
            "code, createTime) ",
            "values (#{area,jdbcType=VARCHAR}, #{acronym,jdbcType=VARCHAR}, ",
            "#{code,jdbcType=VARCHAR}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysOrigin sysOrigin);
    
    
    /**
     * 分页查询匹配数据内容
     * @param startPos
     * @param maxRows
     * @return
     */
    @Select({
            "select * from sys_order limit #{startPos},#{maxRows}"
    })
    List<SysOrder> orderListSearch(@Param("startPos") Integer startPos, @Param("maxRows") Integer maxRows);

    
    /**
     * 查询总条数
     * @return
     */
    @Select({
            "select count(*) from sys_order "
    })
    int countOrder();
    
    
    
    

    @Select({
            "select * from sys_origin where id = #{id}"
    })
    SysOrigin getById(Integer id);

    @Update({
            "update sys_origin",
            "set area = #{area,jdbcType=VARCHAR},",
            "acronym = #{acronym,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysOrigin sysOrigin);
}
