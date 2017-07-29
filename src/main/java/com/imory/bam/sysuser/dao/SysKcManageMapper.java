package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysKcManage;
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
public interface SysKcManageMapper {

    @Insert({
            "insert into sys_kcManage (productNo, productName,sku,",
            "rkTotal,ckTotal,syNums,createTime)",
            "values (#{productNo,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
            "#{sku,jdbcType=VARCHAR},#{rkTotal,jdbcType=INTEGER},#{ckTotal,jdbcType=INTEGER},",
            "#{syNums,jdbcType=INTEGER}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysKcManage sysKcManage);

    @SelectProvider(type = SysKcManageSqlProvider.class,method = "listSysKcManage")
    List<SysKcManage> listSysKcManage(Map<String, Object> paramsMap);

    @SelectProvider(type = SysKcManageSqlProvider.class,method = "countSysKcManage")
    int countSysKcManage(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_kcManage where id = #{id}"
    })
    SysKcManage getById(Integer id);

    @Update({
            "update sys_kcManage",
            "set productNo = #{productNo,jdbcType=VARCHAR},",
            "productName = #{productName,jdbcType=VARCHAR},",
            "sku = #{sku,jdbcType=VARCHAR},",
            "rkTotal = #{rkTotal,jdbcType=INTEGER},",
            "ckTotal = #{ckTotal,jdbcType=INTEGER},",
            "syNums = #{syNums,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysKcManage sysKcManage);

    @Delete({
            "delete from sys_kcManage where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysKcManageSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
