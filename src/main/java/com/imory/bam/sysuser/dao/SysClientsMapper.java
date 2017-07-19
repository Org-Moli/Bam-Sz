package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysClients;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/14
 */
@Mapper
public interface SysClientsMapper {

    @Select({
            "select * from sys_clients"
    })
    List<SysClients> listSysClients();

    @Insert({
            "insert into sys_clients(name,picUrl,bindUrl,createTime)",
            "values",
            "(#{name},#{picUrl},#{bindUrl},now())"
    })
    int insert(@Param("name") String name, @Param("picUrl") String picUrl, @Param("bindUrl") String bindUrl);

    @Delete({
            "delete from sys_clients where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @Update({
            "update sys_clients set name=#{name},picUrl = #{picUrl},bindUrl=#{bindUrl}",
            "where id = #{id}"
    })
    void update(@Param("name") String name, @Param("picUrl") String picUrl, @Param("bindUrl") String bindUrl, @Param("id") Integer id);
}
