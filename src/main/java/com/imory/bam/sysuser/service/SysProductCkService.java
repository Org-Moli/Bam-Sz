package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysKcManage;
import com.imory.bam.sysuser.bean.SysProductCk;
import com.imory.bam.sysuser.dao.SysKcManageMapper;
import com.imory.bam.sysuser.dao.SysProductCkMapper;
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
public class SysProductCkService {

    @Autowired
    private SysProductCkMapper sysProductCkMapper;

    @Autowired
    private SysKcManageMapper sysKcManageMapper;

    public List<SysProductCk> listSysProductCk(Map<String, Object> paramsMap)
    {

        return sysProductCkMapper.listSysProductCk(paramsMap);
    }

    public int countSysProductCk(Map<String, Object> paramsMap)
    {
        return sysProductCkMapper.countSysProductCk(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysProductCk
     * @return
     */
    public int insert(SysProductCk sysProductCk)
    {
        //查询该商品是否已入库
        List<SysKcManage> sysKcManageList = sysKcManageMapper.listSysKcManageByProductAndCk(sysProductCk.getProductId(), sysProductCk.getCkName());
        if (sysKcManageList.size() > 0)
        {
            SysKcManage sysKcManage = sysKcManageList.get(0);
            sysKcManage.setCkTotal(sysProductCk.getCkNumbers());
            sysKcManage.setSyNums(sysKcManage.getSyNums() - sysProductCk.getCkNumbers());
            sysKcManageMapper.updateById(sysKcManage);
        }
        return sysProductCkMapper.insert(sysProductCk);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysProductCk getById(Integer id)
    {
        return sysProductCkMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysProductCk
     * @return
     */
    public int updateById(SysProductCk sysProductCk)
    {
        SysProductCk oldCk = sysProductCkMapper.getById(sysProductCk.getId());
        //查询该商品是否已入库
        List<SysKcManage> sysKcManageList = sysKcManageMapper.listSysKcManageByProductAndCk(sysProductCk.getProductId(), sysProductCk.getCkName());
        if (sysKcManageList.size() > 0)
        {
            SysKcManage sysKcManage = sysKcManageList.get(0);
            sysKcManage.setCkTotal(sysKcManage.getCkTotal() - oldCk.getCkNumbers() + sysProductCk.getCkNumbers());
            sysKcManage.setSyNums(sysKcManage.getSyNums() + oldCk.getCkNumbers() - sysProductCk.getCkNumbers());
            sysKcManageMapper.updateById(sysKcManage);
        }
        return sysProductCkMapper.updateById(sysProductCk);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysProductCkMapper.deleteById(id);
    }

    /**
     * 删除
     *
     * @param ids
     */
    public void deleteByIds(Integer[] ids)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("ids", ids);
        sysProductCkMapper.deleteByIds(paramsMap);
    }
}
