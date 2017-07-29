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
public class SysProductCk {

    private Integer id;

    private String productNo;

    private String productName;

    private String sku;

    private String ckName;

    private String khName;

    private String khCkNo;

    private String ckDate;

    private String ckOperator;

    private Integer ckNumbers;

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

    public String getKhCkNo()
    {
        return khCkNo;
    }

    public void setKhCkNo(String khCkNo)
    {
        this.khCkNo = khCkNo;
    }

    public String getCkDate()
    {
        return ckDate;
    }

    public void setCkDate(String ckDate)
    {
        this.ckDate = ckDate;
    }

    public String getCkOperator()
    {
        return ckOperator;
    }

    public void setCkOperator(String ckOperator)
    {
        this.ckOperator = ckOperator;
    }

    public Integer getCkNumbers()
    {
        return ckNumbers;
    }

    public void setCkNumbers(Integer ckNumbers)
    {
        this.ckNumbers = ckNumbers;
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
