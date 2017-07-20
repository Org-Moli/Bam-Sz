package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysCurrencyUnit;
import com.imory.bam.sysuser.service.SysCurrencyUnitService;
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
@RequestMapping("/bam/sysCurrencyUnitAjax")
public class SysCurrencyUnitAjaxController {

    @Autowired
    private SysCurrencyUnitService sysCurrencyUnitService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysAmountUnit")
    public String listSysAmountUnit(@Param("draw") int draw, @Param("start") int start, @Param("length") int length, @Param("qryVal") String qryVal)
    {
        List<SysCurrencyUnit> sysCurrencyUnitList = sysCurrencyUnitService.listSysCurrencyUnit(start, length, qryVal);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysCurrencyUnitList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysCurrencyUnitService.countSysCurrencyUnit(qryVal)); //:总记录数
        jsonObject.put("recordsFiltered", sysCurrencyUnitService.countSysCurrencyUnit(qryVal)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysCurrencyUnit getById(Integer id)
    {
        SysCurrencyUnit sysCurrencyUnit = sysCurrencyUnitService.getById(id);
        return sysCurrencyUnit;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Integer id, String name, String code)
    {
        Map<String, Object> resultMap = new HashMap<>();

        SysCurrencyUnit sysCurrencyUnit = new SysCurrencyUnit();
        sysCurrencyUnit.setName(name);
        sysCurrencyUnit.setCode(code);

        if (id != null)
        {
            sysCurrencyUnit.setId(id);
            sysCurrencyUnitService.updateById(sysCurrencyUnit);
        } else
        {
            sysCurrencyUnitService.insert(sysCurrencyUnit);
        }
        if (sysCurrencyUnit.getId() != null)
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
        sysCurrencyUnitService.deleteById(id);
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
        sysCurrencyUnitService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
