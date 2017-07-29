package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysProductRk;
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
public interface SysProductRkMapper {

    @Insert({
            "insert into sys_productRk (productNo, productName,sku,",
            "ckName,khName,khRkNo,rkDate,",
            "rkOperator,rkNumbers, createTime) ",
            "values (#{productNo,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
            "#{sku,jdbcType=VARCHAR},#{ckName,jdbcType=VARCHAR},#{khName,jdbcType=VARCHAR},",
            "#{khRkNo,jdbcType=VARCHAR}, #{rkDate},#{rkOperator},#{rkNumbers},now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysProductRk sysProductRk);

    @SelectProvider(type = SysProductRkSqlProvider.class,method = "listSysProductRk")
    List<SysProductRk> listSysProductRk(Map<String, Object> paramsMap);

    @SelectProvider(type = SysProductRkSqlProvider.class,method = "countSysProductRk")
    int countSysProductRk(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_productRk where id = #{id}"
    })
    SysProductRk getById(Integer id);

    @Update({
            "update sys_productRk",
            "set productNo = #{productNo,jdbcType=VARCHAR},",
            "productName = #{productName,jdbcType=VARCHAR},",
            "sku = #{sku,jdbcType=VARCHAR},",
            "ckName = #{ckName,jdbcType=VARCHAR},",
            "khName = #{khName,jdbcType=VARCHAR},",
            "khRkNo = #{khRkNo,jdbcType=VARCHAR},",
            "rkDate = #{rkDate},",
            "rkOperator = #{rkOperator,jdbcType=VARCHAR},",
            "rkNumbers = #{rkNumbers,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysProductRk sysProductRk);

    @Delete({
            "delete from sys_productRk where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysProductRkSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
