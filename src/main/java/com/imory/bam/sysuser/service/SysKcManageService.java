package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysKcManage;
import com.imory.bam.sysuser.dao.SysKcManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class SysKcManageService {

    @Autowired
    private SysKcManageMapper sysKcManageMapper;

    public List<Map<String, Object>> listSysKcManage(Map<String, Object> paramsMap)
    {
        return sysKcManageMapper.listSysKcManage(paramsMap);
    }

    public int countSysKcManage(Map<String, Object> paramsMap)
    {
        return sysKcManageMapper.countSysKcManage(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysKcManage
     * @return
     */
    public int insert(SysKcManage sysKcManage)
    {
        return sysKcManageMapper.insert(sysKcManage);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysKcManage getById(Integer id)
    {
        return sysKcManageMapper.getById(id);
    }

}
