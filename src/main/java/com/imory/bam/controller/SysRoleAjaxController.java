package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysRole;
import com.imory.bam.sysuser.service.SysRoleService;
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
@RequestMapping("/bam/sysRoleAjax")
public class SysRoleAjaxController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/listSysRoleList")
    public String listSysRoleList(@Param("draw") int draw, @Param("start") int start, @Param("length") int length)
    {
        List<SysRole> sysRoleList = sysRoleService.listSysRole();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysRoleList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysRoleService.countSysRole()); //:总记录数
        jsonObject.put("recordsFiltered", sysRoleService.countSysRole()); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 查询所有产地
     *
     * @return
     */
    @RequestMapping("/getById")
    public SysRole getById(Integer id)
    {
        return sysRoleService.getById(id);
    }

    @RequestMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdate(SysRole sysRole)
    {
        Map<String, Object> resultMap = new HashMap<>();

        if (sysRole.getId() != null)
        {
            sysRoleService.updateById(sysRole);
        } else
        {
            sysRoleService.insert(sysRole);
        }
        if (sysRole.getId() != null)
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
        sysRoleService.deleteById(id);
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
        sysRoleService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
