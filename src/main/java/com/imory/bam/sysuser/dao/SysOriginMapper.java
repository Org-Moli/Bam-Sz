package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysOrigin;
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
public interface SysOriginMapper {

    @Insert({
            "insert into sys_origin (area, acronym, ",
            "code, createTime) ",
            "values (#{area,jdbcType=VARCHAR}, #{acronym,jdbcType=VARCHAR}, ",
            "#{code,jdbcType=VARCHAR}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysOrigin sysOrigin);

    @SelectProvider(type = SysOriginSqlProvider.class,method = "listSysOrigin")
    List<SysOrigin> listSysOrigin(Map<String,Object> paramsMap);

    @SelectProvider(type = SysOriginSqlProvider.class,method = "countSysOrigin")
    int countSysOrigin(Map<String,Object> paramsMap);

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

    @Delete({
            "delete from sys_origin where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysOriginSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
