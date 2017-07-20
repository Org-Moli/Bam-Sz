package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysAmountUnit;
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
public interface SysAmountUnitMapper {

    @Insert({
            "insert into sys_amountUnit (name, ",
            "code, createTime) ",
            "values (#{name,jdbcType=VARCHAR},",
            "#{code,jdbcType=VARCHAR}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysAmountUnit sysAmountUnit);

    @SelectProvider(type = SysAmountUnitSqlProvider.class, method = "listSysAmountUnit")
    List<SysAmountUnit> listSysAmountUnit(Map<String, Object> paramsMap);

    @SelectProvider(type = SysAmountUnitSqlProvider.class, method = "countSysAmountUnit")
    int countSysAmountUnit(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_amountUnit where id = #{id}"
    })
    SysAmountUnit getById(Integer id);

    @Update({
            "update sys_amountUnit",
            "set name = #{name,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysAmountUnit sysOrigin);

    @Delete({
            "delete from sys_amountUnit where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @DeleteProvider(type = SysAmountUnitSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);

}
