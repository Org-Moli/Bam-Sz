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
    public String listSysOrigin(@Param("draw") int draw, @Param("start") int start ,@Param("length") int length)
    {
        List<SysOrigin> sysOriginList = sysOriginService.listSysOrigin(start, length);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysOriginList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysOriginList.size());
        jsonObject.put("recordsFiltered", sysOriginService.countSysOrigin());
        return jsonObject.toJSONString();
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
}
