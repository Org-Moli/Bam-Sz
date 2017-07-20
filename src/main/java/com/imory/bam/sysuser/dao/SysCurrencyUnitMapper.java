package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysCurrencyUnit;
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
public interface SysCurrencyUnitMapper {

    @Insert({
            "insert into sys_currencyUnit (name, ",
            "code, createTime) ",
            "values (#{name,jdbcType=VARCHAR},",
            "#{code,jdbcType=VARCHAR}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysCurrencyUnit sysCurrencyUnit);

    @SelectProvider(type = SysCurrencyUnitSqlProvider.class, method = "listSysCurrencyUnit")
    List<SysCurrencyUnit> listSysCurrencyUnit(Map<String, Object> paramsMap);

    @SelectProvider(type = SysCurrencyUnitSqlProvider.class, method = "countSysCurrencyUnit")
    int countSysCurrencyUnit(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_currencyUnit where id = #{id}"
    })
    SysCurrencyUnit getById(Integer id);

    @Update({
            "update sys_currencyUnit",
            "set name = #{name,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysCurrencyUnit sysOrigin);

    @Delete({
            "delete from sys_currencyUnit where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysCurrencyUnitSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);

}
