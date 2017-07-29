package com.imory.bam.sysuser.bean;

import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/29
 */
public class SysKcManage {

    private Integer id;

    private Integer productId;

    private String ckName;

    private Integer rkTotal;

    private Integer ckTotal;

    private Integer syNums;

    private Date createTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getCkName()
    {
        return ckName;
    }

    public void setCkName(String ckName)
    {
        this.ckName = ckName;
    }

    public Integer getRkTotal()
    {
        return rkTotal;
    }

    public void setRkTotal(Integer rkTotal)
    {
        this.rkTotal = rkTotal;
    }

    public Integer getCkTotal()
    {
        return ckTotal;
    }

    public void setCkTotal(Integer ckTotal)
    {
        this.ckTotal = ckTotal;
    }

    public Integer getSyNums()
    {
        return syNums;
    }

    public void setSyNums(Integer syNums)
    {
        this.syNums = syNums;
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
