package com.imory.bam.sysuser.dao;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/29
 */
public class SysProductRkSqlProvider {

    public String listSysProductRk(Map<String, Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from sys_productRk where 1 = 1\n");
        if(paramsMap.get("productNo") != null)
        {
            sql.append("and productNo like CONCAT('%',#{productNo},'%') \n");
        }
        if(paramsMap.get("productName") != null)
        {
            sql.append("and productName like CONCAT('%',#{productName},'%') \n");
        }
        if(paramsMap.get("sku") != null)
        {
            sql.append("and sku like CONCAT('%',#{sku},'%') \n");
        }
        if(paramsMap.get("ckName") != null)
        {
            sql.append("and ckName like CONCAT('%',#{ckName},'%') \n");
        }
        if(paramsMap.get("khName") != null)
        {
            sql.append("and khName like CONCAT('%',#{khName},'%') \n");
        }
        if(paramsMap.get("khRkNo") != null)
        {
            sql.append("and khRkNo like CONCAT('%',#{khRkNo},'%') \n");
        }
        if(paramsMap.get("rkDate") != null)
        {
            sql.append("and rkDate = #{rkDate, jdbcType=VARCHAR} \n");
        }
        if(paramsMap.get("rkOperator") != null)
        {
            sql.append("and rkOperator like CONCAT('%',#{rkOperator},'%') \n");
        }
        if(paramsMap.get("startPos") != null && paramsMap.get("maxRows") != null)
        {
            sql.append("limit #{startPos},#{maxRows}");
        }
        return sql.toString();
    }

    public String countSysProductRk(Map<String, Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from sys_productRk where 1 = 1\n");
        if(paramsMap.get("productNo") != null)
        {
            sql.append("and productNo like CONCAT('%',#{productNo},'%') \n");
        }
        if(paramsMap.get("productName") != null)
        {
            sql.append("and productName like CONCAT('%',#{productName},'%') \n");
        }
        if(paramsMap.get("sku") != null)
        {
            sql.append("and sku like CONCAT('%',#{sku},'%') \n");
        }
        if(paramsMap.get("ckName") != null)
        {
            sql.append("and ckName like CONCAT('%',#{ckName},'%') \n");
        }
        if(paramsMap.get("khName") != null)
        {
            sql.append("and khName like CONCAT('%',#{khName},'%') \n");
        }
        if(paramsMap.get("khRkNo") != null)
        {
            sql.append("and khRkNo like CONCAT('%',#{khRkNo},'%') \n");
        }
        if(paramsMap.get("rkDate") != null)
        {
            sql.append("and rkDate = #{rkDate, jdbcType=VARCHAR} \n");
        }
        if(paramsMap.get("rkOperator") != null)
        {
            sql.append("and rkOperator like CONCAT('%',#{rkOperator},'%') \n");
        }
        return sql.toString();
    }

    public String deleteByIds(Map<String, Object> paramsMap)
    {
        Integer[] ids = (Integer[]) paramsMap.get("ids");

        StringBuffer sql = new StringBuffer();
        sql.append("delete from sys_productRk where id in \n");
        sql.append("(\n");
        for (int i = 0; i < ids.length; i++)
        {
            if (i != ids.length - 1)
            {
                sql.append(ids[i] + ",");
            } else
            {
                sql.append(ids[i]);
            }
        }
        sql.append(")\n");

        return sql.toString();
    }
}
