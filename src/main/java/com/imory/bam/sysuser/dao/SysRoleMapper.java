package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysRole;
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
public interface SysRoleMapper {

    @Insert({
            "insert into sys_role (name, enabled) ",
            "values (#{name,jdbcType=VARCHAR}, 1)"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysRole sysRole);

    @Select({
            "select * from sys_role"
    })
    List<SysRole> listSysRole();

    @Select({
            "select count(*) from sys_role"
    })
    int countSysRole();

    @Select({
            "select * from sys_role where id = #{id}"
    })
    SysRole getById(Integer id);

    @Update({
            "update sys_role",
            "set name = #{name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysRole sysRole);

    @Delete({
            "delete from sys_role where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysRoleSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
