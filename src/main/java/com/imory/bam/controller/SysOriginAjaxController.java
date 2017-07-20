package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysOrigin;
import com.imory.bam.sysuser.service.SysOriginService;
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
@RequestMapping("/bam/sysOriginAjax")
public class SysOriginAjaxController {

    @Autowired
    private SysOriginService sysOriginService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysOrigin")
    public String listSysOrigin(@Param("draw") int draw, @Param("start") int start, @Param("length") int length, @Param("qryVal") String qryVal)
    {
        List<SysOrigin> sysOriginList = sysOriginService.listSysOrigin(start, length,qryVal);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysOriginList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysOriginService.countSysOrigin(qryVal)); //:总记录数
        jsonObject.put("recordsFiltered", sysOriginService.countSysOrigin(qryVal)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysOrigin getById(Integer id)
    {
        SysOrigin sysOrigin = sysOriginService.getById(id);
        return sysOrigin;
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Integer id, String area, String acronym, String code)
    {
        Map<String, Object> resultMap = new HashMap<>();

        SysOrigin sysOrigin = new SysOrigin();
        sysOrigin.setArea(area);
        sysOrigin.setAcronym(acronym);
        sysOrigin.setCode(code);

        if (id != null)
        {
            sysOrigin.setId(id);
            sysOriginService.updateById(sysOrigin);
        } else
        {
            sysOriginService.insert(sysOrigin);
        }
        if (sysOrigin.getId() != null)
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
        sysOriginService.deleteById(id);
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
        sysOriginService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
