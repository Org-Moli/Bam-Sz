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

    private String productNo;

    private String productName;

    private String sku;

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

    public String getProductNo()
    {
        return productNo;
    }

    public void setProductNo(String productNo)
    {
        this.productNo = productNo;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku(String sku)
    {
        this.sku = sku;
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
