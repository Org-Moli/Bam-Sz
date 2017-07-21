package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysProduct;
import com.imory.bam.sysuser.dao.SysProductMapper;
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
 * @Date 2017/7/21
 */
@Service
public class SysProductService {

    @Autowired
    private SysProductMapper sysProductMapper;

    public List<Map<String, Object>> listSysProduct(Integer startPos, Integer maxRows, String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", startPos);
        paramsMap.put("maxRows", maxRows);
        paramsMap.put("qryVal", qryVal);
        return sysProductMapper.listSysProduct(paramsMap);
    }

    public int countSysProduct(String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("qryVal", qryVal);
        return sysProductMapper.countSysProduct(paramsMap);
    }

    /**
     * 保存
     *
     * @param sysProduct
     * @return
     */
    public int insert(SysProduct sysProduct)
    {
        return sysProductMapper.insert(sysProduct);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    public SysProduct getById(Integer id)
    {
        return sysProductMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param sysProduct
     * @return
     */
    public int updateById(SysProduct sysProduct)
    {
        return sysProductMapper.updateById(sysProduct);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysProductMapper.deleteById(id);
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
        sysProductMapper.deleteByIds(paramsMap);
    }

    /**
     * 审核
     *
     * @param ids
     */
    public void auditProduct(Integer[] ids)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("ids", ids);
        sysProductMapper.auditProduct(paramsMap);
    }

}
