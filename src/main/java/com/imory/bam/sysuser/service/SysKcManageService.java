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

    public List<SysKcManage> listSysOrigin(Integer startPos, Integer maxRows, String productNo,
                                           String productName, String sku)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", startPos);
        paramsMap.put("maxRows", maxRows);
        paramsMap.put("productNo", productNo);
        paramsMap.put("productName", productName);
        paramsMap.put("sku", sku);
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
