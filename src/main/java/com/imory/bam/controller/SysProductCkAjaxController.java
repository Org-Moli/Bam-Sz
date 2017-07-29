package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysProductCk;
import com.imory.bam.sysuser.service.SysProductCkService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
@RestController
@RequestMapping("/bam/sysProductCkAjax")
public class SysProductCkAjaxController {

    @Autowired
    private SysProductCkService sysProductCkService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysProductCk")
    public String listSysProduct(@Param("draw") int draw, @Param("start") int start, @Param("length") int length,
                                 @Param("productNo") String productNo, @Param("productName") String productName,
                                 @Param("sku") String sku, @Param("ckName") String ckName,
                                 @Param("khName") String khName, @Param("khCkNo") String khCkNo,
                                 @Param("ckDate") String ckDate, @Param("ckOperator") String ckOperator)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", start);
        paramsMap.put("maxRows", length);
        if(StringUtils.isNotBlank(productNo))
        {
            paramsMap.put("productNo", productNo);
        }
        if(StringUtils.isNotBlank(productName))
        {
            paramsMap.put("productName", productName);
        }
        if(StringUtils.isNotBlank(sku))
        {
            paramsMap.put("sku", sku);
        }
        if(StringUtils.isNotBlank(ckName))
        {
            paramsMap.put("ckName", ckName);
        }
        if(StringUtils.isNotBlank(khName))
        {
            paramsMap.put("khName", khName);
        }
        if(StringUtils.isNotBlank(khCkNo))
        {
            paramsMap.put("khCkNo", khCkNo);
        }
        if(StringUtils.isNotBlank(ckDate))
        {
            paramsMap.put("ckDate", ckDate);
        }
        if(StringUtils.isNotBlank(ckOperator))
        {
            paramsMap.put("ckOperator", ckOperator);
        }
        List<SysProductCk> sysProductCkList = sysProductCkService.listSysProductCk(paramsMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysProductCkList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysProductCkService.countSysProductCk(paramsMap)); //:总记录数
        jsonObject.put("recordsFiltered", sysProductCkService.countSysProductCk(paramsMap)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysProductCk getById(Integer id)
    {
        SysProductCk sysProductCk = sysProductCkService.getById(id);
        return sysProductCk;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Integer id, SysProductCk sysProductCk)
    {
        Map<String, Object> resultMap = new HashMap<>();

        if (id != null)
        {
            sysProductCkService.updateById(sysProductCk);
        } else
        {
            sysProductCkService.insert(sysProductCk);
        }
        if (sysProductCk.getId() != null)
        {
            resultMap.put("success", true);
        } else
        {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Map<String, Object> deleteById(Integer id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        sysProductCkService.deleteById(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/deleteByIds")
    public Map<String, Object> deleteByIds(Integer[] ids)
    {
        Map<String, Object> resultMap = new HashMap<>();
        sysProductCkService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/auditProduct")
    public Map<String, Object> auditProduct(Integer[] ids)
    {
        Map<String, Object> resultMap = new HashMap<>();
        sysProductCkService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
