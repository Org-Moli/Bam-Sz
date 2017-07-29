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
public class SysProductRk {

    private Integer id;

    private String productNo;

    private String productName;

    private String sku;

    private String ckName;

    private String khName;

    private String khRkNo;

    private Date rkDate;

    private String rkOperator;

    private Integer rkNumbers;

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

    public String getCkName()
    {
        return ckName;
    }

    public void setCkName(String ckName)
    {
        this.ckName = ckName;
    }

    public String getKhName()
    {
        return khName;
    }

    public void setKhName(String khName)
    {
        this.khName = khName;
    }

    public String getKhRkNo()
    {
        return khRkNo;
    }

    public void setKhRkNo(String khRkNo)
    {
        this.khRkNo = khRkNo;
    }

    public Date getRkDate()
    {
        return rkDate;
    }

    public void setRkDate(Date rkDate)
    {
        this.rkDate = rkDate;
    }

    public String getRkOperator()
    {
        return rkOperator;
    }

    public void setRkOperator(String rkOperator)
    {
        this.rkOperator = rkOperator;
    }

    public Integer getRkNumbers()
    {
        return rkNumbers;
    }

    public void setRkNumbers(Integer rkNumbers)
    {
        this.rkNumbers = rkNumbers;
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
