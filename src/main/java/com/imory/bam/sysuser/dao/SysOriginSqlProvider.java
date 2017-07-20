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
 * @Date 2017/7/20
 */
public class SysOriginSqlProvider {

    public String listSysOrigin(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select * from sys_origin where 1 = 1\n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and area like '%" + qryVal + "%' \n");
            sql.append("or acronym like '%" + qryVal + "%'");
            sql.append("or code like '%" + qryVal + "%'");
        }
        sql.append("limit #{startPos},#{maxRows}");
        return sql.toString();
    }

    public String countSysOrigin(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from sys_origin where 1 = 1\n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and area like '%" + qryVal + "%' \n");
            sql.append("or acronym like '%" + qryVal + "%'");
            sql.append("or code like '%" + qryVal + "%'");
        }
        return sql.toString();
    }

    public String deleteByIds(Map<String, Object> paramsMap)
    {
        Integer[] ids = (Integer[]) paramsMap.get("ids");

        StringBuffer sql = new StringBuffer();
        sql.append("delete from sys_origin where id in \n");
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
