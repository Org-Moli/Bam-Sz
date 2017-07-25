package com.imory.bam.sysuser.bean;

import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/25
 */
public class SysPlatform {

    private Integer id;

    private String name;

    private String types;

    private Boolean isDefault;

    private String descInfo;

    private String appName;

    private Date createTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTypes()
    {
        return types;
    }

    public void setTypes(String types)
    {
        this.types = types;
    }

    public Boolean getDefault()
    {
        return isDefault;
    }

    public void setDefault(Boolean aDefault)
    {
        isDefault = aDefault;
    }

    public String getDescInfo()
    {
        return descInfo;
    }

    public void setDescInfo(String descInfo)
    {
        this.descInfo = descInfo;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
