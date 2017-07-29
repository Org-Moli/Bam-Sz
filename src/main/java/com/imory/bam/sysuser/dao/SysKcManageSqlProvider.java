package com.imory.bam.sysuser.dao;

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
public class SysKcManageSqlProvider {

    public String listSysKcManage(Map<String, Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select sk.*,sp.productNo,sp.name,sp.sku from sys_kcManage sk \n");
        sql.append("left join sys_product sp on sk.productId = sp.id \n");
        sql.append("where 1 = 1 \n");
        if (paramsMap.get("productNo") != null)
        {
            sql.append("and sp.productNo like CONCAT('%',#{productNo},'%') \n");
        }
        if (paramsMap.get("productName") != null)
        {
            sql.append("and sp.name like CONCAT('%',#{name},'%') \n");
        }
        if (paramsMap.get("sku") != null)
        {
            sql.append("and sp.sku like CONCAT('%',#{sku},'%') \n");
        }
        if (paramsMap.get("ckName") != null)
        {
            sql.append("and sk.ckName = #{ckName} \n");
        }
        if (paramsMap.get("startPos") != null && paramsMap.get("maxRows") != null)
        {
            sql.append("limit #{startPos},#{maxRows}");
        }
        return sql.toString();
    }

    public String countSysKcManage(Map<String, Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from sys_kcManage sk \n");
        sql.append("left join sys_product sp on sk.productId = sp.id \n");
        sql.append("where 1 = 1 \n");
        if (paramsMap.get("productNo") != null)
        {
            sql.append("and sp.productNo like CONCAT('%',#{productNo},'%') \n");
        }
        if (paramsMap.get("productName") != null)
        {
            sql.append("and sp.name like CONCAT('%',#{name},'%') \n");
        }
        if (paramsMap.get("sku") != null)
        {
            sql.append("and sp.sku like CONCAT('%',#{sku},'%') \n");
        }
        if (paramsMap.get("ckName") != null)
        {
            sql.append("and sk.ckName = #{ckName} \n");
        }
        return sql.toString();
    }

    public String deleteByIds(Map<String, Object> paramsMap)
    {
        Integer[] ids = (Integer[]) paramsMap.get("ids");

        StringBuffer sql = new StringBuffer();
        sql.append("delete from sys_kcManage where id in \n");
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
