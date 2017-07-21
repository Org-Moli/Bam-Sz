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
 * @Date 2017/7/21
 */
public class SysProductSqlProvider {

    public String listSysProduct(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select sp.*,so.area,sa.name as unitName from sys_product sp \n");
        sql.append("LEFT join Sys_origin so \n");
        sql.append("on sp.originId = so.id \n");
        sql.append("left join sys_amountUnit sa \n");
        sql.append("on sp.amountUnitId = sa.id \n");
        sql.append("where 1 = 1 \n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and sp.name like CONCAT('%',#{qryVal},'%') \n");
            sql.append("or sp.sku like CONCAT('%',#{qryVal},'%') \n");
        }
        sql.append("limit #{startPos},#{maxRows}");
        return sql.toString();
    }

    public String countSysProduct(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from sys_product where 1 = 1\n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and name like '%" + qryVal + "%' \n");
            sql.append("or sku like '%" + qryVal + "%'");
        }
        return sql.toString();
    }

    public String deleteByIds(Map<String, Object> paramsMap)
    {
        Integer[] ids = (Integer[]) paramsMap.get("ids");

        StringBuffer sql = new StringBuffer();
        sql.append("delete from sys_product where id in \n");
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
