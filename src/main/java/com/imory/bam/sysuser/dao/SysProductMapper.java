package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysProduct;
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
 * @Date 2017/7/21
 */
@Mapper
public interface SysProductMapper {

    @SelectProvider(type = SysProductSqlProvider.class, method = "listSysProduct")
    List<Map<String,Object>> listSysProduct(Map<String, Object> paramsMap);

    @Insert({
            "insert into sys_product (name, sku,amountUnitId,",
            "originId,maozhong,jingzhong,brandName,barCode,",
            "hgbah,hgbm,gjbah,gyscode,gysName,",
            "productGg,price,yhprice,productDesc,state)",
            "values (#{name,jdbcType=VARCHAR}, #{sku,jdbcType=VARCHAR}, ",
            "#{amountUnitId,jdbcType=INTEGER},#{originId,jdbcType=INTEGER},",
            "#{maozhong,jdbcType=DOUBLE},#{jingzhong,jdbcType=DOUBLE},",
            "#{brandName,jdbcType=VARCHAR},#{barCode,jdbcType=VARCHAR},",
            "#{hgbah,jdbcType=VARCHAR},#{hgbm,jdbcType=VARCHAR},",
            "#{gjbah,jdbcType=VARCHAR},#{gyscode,jdbcType=VARCHAR},",
            "#{gysName,jdbcType=VARCHAR},#{productGg,jdbcType=VARCHAR},",
            "#{price,jdbcType=DOUBLE},#{yhprice,jdbcType=DOUBLE},",
            "#{productDesc,jdbcType=VARCHAR},0)"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysProduct sysProduct);

    @SelectProvider(type = SysProductSqlProvider.class,method = "countSysProduct")
    int countSysProduct(Map<String,Object> paramsMap);

    @Select({
            "select * from sys_product where id = #{id}"
    })
    SysProduct getById(Integer id);

    @Update({
            "update sys_product",
            "set name = #{name,jdbcType=VARCHAR},",
            "sku = #{sku,jdbcType=VARCHAR},",
            "amountUnitId = #{amountUnitId,jdbcType=INTEGER}",
            "originId = #{originId,jdbcType=INTEGER}",
            "maozhong = #{maozhong,jdbcType=DOUBLE}",
            "jingzhong = #{jingzhong,jdbcType=DOUBLE}",
            "brandName = #{brandName,jdbcType=VARCHAR}",
            "barCode = #{barCode,jdbcType=VARCHAR}",
            "hgbah = #{hgbah,jdbcType=VARCHAR}",
            "hgbm = #{hgbm,jdbcType=VARCHAR}",
            "gjbah = #{gjbah,jdbcType=VARCHAR}",
            "gyscode = #{gyscode,jdbcType=VARCHAR}",
            "gysName = #{gysName,jdbcType=VARCHAR}",
            "productGg = #{productGg,jdbcType=VARCHAR}",
            "price = #{price,jdbcType=DOUBLE}",
            "yhprice = #{yhprice,jdbcType=DOUBLE}",
            "productDesc = #{productDesc,jdbcType=VARCHAR}",
            "state = #{desc,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysProduct sysProduct);

    @Delete({
            "delete from sys_product where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysProductSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);
}
