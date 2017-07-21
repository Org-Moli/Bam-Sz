package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysProduct;
import com.imory.bam.sysuser.service.SysProductService;
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
@RequestMapping("/bam/sysProductAjax")
public class SysProductAjaxController {

    @Autowired
    private SysProductService sysProductService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysProduct")
    public String listSysProduct(@Param("draw") int draw, @Param("start") int start, @Param("length") int length, @Param("qryVal") String qryVal)
    {
        List<Map<String,Object>> sysProductList = sysProductService.listSysProduct(start, length, qryVal);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysProductList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysProductService.countSysProduct(qryVal)); //:总记录数
        jsonObject.put("recordsFiltered", sysProductService.countSysProduct(qryVal)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysProduct getById(Integer id)
    {
        SysProduct sysProduct = sysProductService.getById(id);
        return sysProduct;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Integer id, SysProduct sysProduct)
    {
        Map<String, Object> resultMap = new HashMap<>();

        if (id != null)
        {
            sysProduct.setId(id);
            sysProductService.updateById(sysProduct);
        } else
        {
            sysProduct.setYhprice(sysProduct.getPrice());
            sysProductService.insert(sysProduct);
        }
        if (sysProduct.getId() != null)
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
        sysProductService.deleteById(id);
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
        sysProductService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
