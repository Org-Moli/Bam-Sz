package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/11
 */
@Mapper
public interface SysUserMapper {

    @Select({
            "select * from sys_user where id = #{id}"
    })
    SysUser findUserById(@Param("id") Integer id);

    @Insert({
            "insert into sys_user(logonId,userName,password,level,createTime)",
            "values",
            "(#{logonId},#{userName},#{password},#{level},now())"
    })
    int insert(@Param("logonId") String logonId, @Param("userName") String userName, @Param("password") String password,
               @Param("level") Integer level);

    @Update({
            "update sys_user set password = 'e10adc3949ba59abbe56e057f20f883e'",
            "where id = #{id}"
    })
    void resertPsd(@Param("id") Integer id);

    @Select({
            "select * from sys_user",
            "limit #{startPos},#{maxRows}"
    })
    List<SysUser> listSysUser(@Param("startPos") Integer startPos, @Param("maxRows") Integer maxRows);

    @Select({
            "select * from sys_user where logonId = #{logonId} and password = #{password}"
    })
    SysUser userLogon(@Param("logonId") String logonId, @Param("password") String password);

    @Select({
            "select * from sys_user where logonId = #{logonId}"
    })
    SysUser findSysUserByLogonId(@Param("logonId") String logonId);
}
