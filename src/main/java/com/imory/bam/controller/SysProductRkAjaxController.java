package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysProductRk;
import com.imory.bam.sysuser.service.SysProductRkService;
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
@RequestMapping("/bam/sysProductRkAjax")
public class SysProductRkAjaxController {

    @Autowired
    private SysProductRkService sysProductRkService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysProductRk")
    public String listSysProduct(@Param("draw") int draw, @Param("start") int start, @Param("length") int length,
                                 @Param("productNo") String productNo, @Param("productName") String productName,
                                 @Param("sku") String sku, @Param("ckName") String ckName,
                                 @Param("khName") String khName, @Param("khRkNo") String khRkNo,
                                 @Param("rkDate") String rkDate, @Param("rkOperator") String rkOperator)
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
        if(StringUtils.isNotBlank(khRkNo))
        {
            paramsMap.put("khCkNo", khRkNo);
        }
        if(StringUtils.isNotBlank(rkDate))
        {
            paramsMap.put("rkDate", rkDate);
        }
        if(StringUtils.isNotBlank(rkOperator))
        {
            paramsMap.put("rkOperator", rkOperator);
        }
        List<SysProductRk> sysProductRkList = sysProductRkService.listSysProductRk(paramsMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysProductRkList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysProductRkService.countSysProductRk(paramsMap)); //:总记录数
        jsonObject.put("recordsFiltered", sysProductRkService.countSysProductRk(paramsMap)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysProductRk getById(Integer id)
    {
        SysProductRk sysProductRk = sysProductRkService.getById(id);
        return sysProductRk;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Integer id, SysProductRk sysProductRk)
    {
        Map<String, Object> resultMap = new HashMap<>();

        if (id != null)
        {
            sysProductRkService.updateById(sysProductRk);
        } else
        {
            sysProductRkService.insert(sysProductRk);
        }
        if (sysProductRk.getId() != null)
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
        sysProductRkService.deleteById(id);
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
        sysProductRkService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }

}
