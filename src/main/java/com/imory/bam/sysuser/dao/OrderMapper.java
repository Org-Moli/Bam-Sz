package com.imory.bam.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrigin;

/**
 * 
 * @author hushun
 *
 */
@Mapper
public interface OrderMapper {

    @Insert({
            "insert into sys_origin (area, acronym, ",
            "code, createTime) ",
            "values (#{area,jdbcType=VARCHAR}, #{acronym,jdbcType=VARCHAR}, ",
            "#{code,jdbcType=VARCHAR}, now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysOrigin sysOrigin);
    
    
    /**
     * 分页查询匹配数据内容
     * @param startPos
     * @param maxRows
     * @return
     */
    @Select({
            "select * from sys_order limit #{startPos},#{maxRows}"
    })
    List<SysOrder> orderListSearch(@Param("startPos") Integer startPos, @Param("maxRows") Integer maxRows);

    
    /**
     * 查询总条数
     * @return
     */
    @Select({
            "select count(*) from sys_order "
    })
    int countOrder();
    
    
    
    

    @Select({
            "select * from sys_order where id = #{id}"
    })
    SysOrder getById(Integer id);

    @Update({
            "update  sys_order",
            "set orderNum = #{orderNum,jdbcType=VARCHAR},",
            "trans_user_name = #{trans_user_name,jdbcType=VARCHAR},",
            "trans_user_id_num = #{trans_user_id_num,jdbcType=VARCHAR},",
            "trans_user_phone = #{trans_user_phone,jdbcType=VARCHAR},",
            "trans_user_address = #{trans_user_address,jdbcType=VARCHAR},",
            "payer_name = #{payer_name,jdbcType=VARCHAR},",
            "payer_id_num = #{payer_id_num,jdbcType=VARCHAR},",
            "payer_phone = #{payer_phone,jdbcType=VARCHAR},",
            "order_amount = #{order_amount,jdbcType=DOUBLE},",
            "payer_amount = #{payer_amount,jdbcType=DOUBLE},",
            "trans_amount = #{trans_amount,jdbcType=DOUBLE},",
            "delevery_order = #{delevery_order,jdbcType=VARCHAR},",
            "prd_amount = #{prd_amount,jdbcType=DOUBLE},",
            "tax_amount = #{tax_amount,jdbcType=DOUBLE},",
            "postal_code = #{postal_code,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysOrder sysOrder);
}
