package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysProductCk;
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
public interface SysProductCkMapper {

    @Insert({
            "insert into sys_productCk (productNo, productName,sku,",
            "ckName,khName,khCkNo,ckDate,",
            "ckOperator,ckNumbers, createTime) ",
            "values (#{productNo,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
            "#{sku,jdbcType=VARCHAR},#{ckName,jdbcType=VARCHAR},#{khName,jdbcType=VARCHAR},",
            "#{khCkNo,jdbcType=VARCHAR}, #{ckDate},#{ckOperator},#{ckNumbers},now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysProductCk sysProductCk);

    @SelectProvider(type = SysProductCkSqlProvider.class,method = "listSysProductCk")
    List<SysProductCk> listSysProductCk(Map<String, Object> paramsMap);

    @SelectProvider(type = SysProductCkSqlProvider.class,method = "countSysProductCk")
    int countSysProductCk(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_productCk where id = #{id}"
    })
    SysProductCk getById(Integer id);

    @Update({
            "update sys_productCk",
            "set productNo = #{productNo,jdbcType=VARCHAR},",
            "productName = #{productName,jdbcType=VARCHAR},",
            "sku = #{sku,jdbcType=VARCHAR},",
            "ckName = #{ckName,jdbcType=VARCHAR},",
            "khName = #{khName,jdbcType=VARCHAR},",
            "khCkNo = #{khCkNo,jdbcType=VARCHAR},",
            "ckDate = #{ckDate},",
            "ckOperator = #{ckOperator,jdbcType=VARCHAR},",
            "ckNumbers = #{ckNumbers,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysProductCk sysProductCk);

    @Delete({
            "delete from sys_productCk where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysProductCkSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
