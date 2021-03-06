package com.imory.bam.sysuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.searchDto.OrderDto;
import com.imory.bam.sysuser.bean.SysOrder;
import com.imory.bam.sysuser.bean.SysOrderDetail;
import com.imory.bam.sysuser.bean.SysOrigin;
import com.imory.bam.utils.SimpleInLangDriver;
import com.imory.bam.utils.SimpleUpdateLangDriver;

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
    @SelectProvider(type = OrderSqlProvider.class, method = "searchList")
    List<SysOrder> orderListSearch(OrderDto  orderDto);

    
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
    
    
    @Select({
        "select * from sys_orderdetail where orderNum = #{orderNum}"
    })
	List<SysOrderDetail> getByIdofDetail(String orderNum);

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
    
    @Update({
        "update  sys_orderdetail ",
        "set amount = #{amount,jdbcType=INTEGER},",
        "prices = #{prices,jdbcType=DOUBLE} ",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateDetailOrder(SysOrderDetail orderDetail);
    
    @Update({
        "update sys_order",
        "set audit_status = 0 ",
        "where id = #{id,jdbcType=INTEGER} and  audit_status=1"
    })
    int fshById(Integer id);
    
    @Update({
        "update sys_order",
        "set del_flag = 1 ",
        "where id in (#{list}) and del_flag=0 "
    })
    @Lang(SimpleInLangDriver.class) 
    int deleteById(List<Integer> list);
    
    @Update({
        "update sys_order",
        " set audit_status = 1 ",
        " where id in (#{list}) and audit_status=0 "
    })
    @Lang(SimpleInLangDriver.class) 
    int chenckById(List<Integer> list);
    
    
    @Update({
        "update sys_order (#{sysOrderDetail})",
        "where id = #{id} "
    })
    @Lang(SimpleUpdateLangDriver.class)
    int updateSysOrderDetailOfJpa(SysOrderDetail sysOrderDetail);
    
    @Update({
        "update sys_order (#{sysOrder})",
        "where id = #{id} "
    })
    @Lang(SimpleUpdateLangDriver.class)
    int updateSysOrderOfJpa(SysOrder sysOrder);

}
