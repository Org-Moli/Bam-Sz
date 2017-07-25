package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysPlatform;
import com.imory.bam.sysuser.service.SysPlatformService;
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
@RequestMapping("/bam/sysPlatformAjax")
public class SysPlatformAjaxController {

    @Autowired
    private SysPlatformService sysPlatformService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysPlatform")
    public String listSysPlatform(@Param("draw") int draw, @Param("start") int start, @Param("length") int length)
    {
        List<SysPlatform> sysPlatformList = sysPlatformService.listSysPlatform();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysPlatformList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysPlatformService.countSysPlatform()); //:总记录数
        jsonObject.put("recordsFiltered", sysPlatformService.countSysPlatform()); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysPlatform getById(Integer id)
    {
        SysPlatform sysPlatform = sysPlatformService.getById(id);
        return sysPlatform;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(SysPlatform sysPlatform)
    {
        Map<String, Object> resultMap = new HashMap<>();

        if (sysPlatform.getId() != null)
        {
            sysPlatformService.updateById(sysPlatform);
        } else
        {
            sysPlatformService.insert(sysPlatform);
        }
        if (sysPlatform.getId() != null)
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
        sysPlatformService.deleteById(id);
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
        sysPlatformService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
