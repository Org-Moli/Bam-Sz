package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysKcManage;
import com.imory.bam.sysuser.bean.SysProductRk;
import com.imory.bam.sysuser.dao.SysKcManageMapper;
import com.imory.bam.sysuser.dao.SysProductRkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class SysProductRkService {

    @Autowired
    private SysProductRkMapper sysProductRkMapper;

    @Autowired
    private SysKcManageMapper sysKcManageMapper;

    public List<SysProductRk> listSysProductRk(Map<String, Object> paramsMap)
    {
        return sysProductRkMapper.listSysProductRk(paramsMap);
    }

    public int countSysProductRk(Map<String, Object> paramsMap)
    {
        return sysProductRkMapper.countSysProductRk(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysProductRk
     * @return
     */
    public int insert(SysProductRk sysProductRk)
    {
        sysProductRkMapper.insert(sysProductRk);
        //查询该商品是否已入库
        List<SysKcManage> sysKcManageList = sysKcManageMapper.listSysKcManageByProductAndCk(sysProductRk.getProductId(), sysProductRk.getCkName());
        if (sysKcManageList.size() > 0)
        {
            SysKcManage sysKcManage = sysKcManageList.get(0);
            sysKcManage.setRkTotal(sysKcManage.getRkTotal() + sysProductRk.getRkNumbers());
            sysKcManage.setSyNums(sysKcManage.getSyNums() + sysProductRk.getRkNumbers());
            sysKcManageMapper.updateById(sysKcManage);
        } else
        {
            SysKcManage sysKcManage = new SysKcManage();
            sysKcManage.setProductId(sysProductRk.getProductId());
            sysKcManage.setCkTotal(0);
            sysKcManage.setCkName(sysProductRk.getCkName());
            sysKcManage.setRkTotal(sysProductRk.getRkNumbers());
            sysKcManage.setSyNums(sysProductRk.getRkNumbers());
            sysKcManageMapper.insert(sysKcManage);
        }
        return 1;
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysProductRk getById(Integer id)
    {
        return sysProductRkMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysProductRk
     * @return
     */
    public int updateById(SysProductRk sysProductRk)
    {
        SysProductRk oldRk = sysProductRkMapper.getById(sysProductRk.getId());
        //查询该商品是否已入库
        List<SysKcManage> sysKcManageList = sysKcManageMapper.listSysKcManageByProductAndCk(sysProductRk.getProductId(), sysProductRk.getCkName());
        if (sysKcManageList.size() > 0)
        {
            SysKcManage sysKcManage = sysKcManageList.get(0);
            sysKcManage.setRkTotal(sysKcManage.getRkTotal() - oldRk.getRkNumbers() + sysProductRk.getRkNumbers());
            sysKcManage.setSyNums(sysKcManage.getSyNums() + sysProductRk.getRkNumbers() - oldRk.getRkNumbers());
            sysKcManageMapper.updateById(sysKcManage);
        }
        sysProductRkMapper.updateById(sysProductRk);
        return 1;
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysProductRkMapper.deleteById(id);
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
        sysProductRkMapper.deleteByIds(paramsMap);
    }
}
