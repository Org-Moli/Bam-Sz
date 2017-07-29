package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysProductCk;
import com.imory.bam.sysuser.service.SysKcManageService;
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
@RequestMapping("/bam/sysKcManageAjax")
public class SysKcManageAjaxController {

    @Autowired
    private SysKcManageService sysKcManageService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysKcManage")
    public String listSysProduct(@Param("draw") int draw, @Param("start") int start, @Param("length") int length,
                                 @Param("productNo") String productNo, @Param("productName") String productName,
                                 @Param("sku") String sku, @Param("ckName") String ckName)
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
        List<Map<String,Object>> sysKcManageList = sysKcManageService.listSysKcManage(paramsMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysKcManageList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysKcManageService.countSysKcManage(paramsMap)); //:总记录数
        jsonObject.put("recordsFiltered", sysKcManageService.countSysKcManage(paramsMap)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

}
