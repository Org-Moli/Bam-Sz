package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysPlatform;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/20
 */
@Mapper
public interface SysPlatformMapper {

    @Insert({
            "insert into sys_platform (name, types, ",
            "isDefault,descInfo,appName,createTime) ",
            "values (#{name,jdbcType=VARCHAR}, #{types,jdbcType=VARCHAR}, ",
            "#{isDefault,jdbcType=BIT},#{descInfo,jdbcType=VARCHAR},#{appName,jdbcType=VARCHAR},now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysPlatform sysPlatform);

    @Select({
            "select * from sys_platform"
    })
    List<SysPlatform> listSysPlatform();

    @Select({
            "select count(*) from sys_platform"
    })
    int countSysPlatform();

    @Select({
            "select * from sys_platform where id = #{id}"
    })
    SysPlatform getById(Integer id);

    @Update({
            "update sys_platform",
            "set name = #{name,jdbcType=VARCHAR},",
            "types = #{types,jdbcType=VARCHAR},",
            "isDefault = #{isDefault,jdbcType=BIT},",
            "descInfo = #{descInfo,jdbcType=VARCHAR},",
            "appName = #{appName,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysPlatform sysPlatform);

    @Delete({
            "delete from sys_platform where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysPlatformSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
