package com.imory.bam.controller;

import com.imory.bam.sysuser.service.SysAmountUnitService;
import com.imory.bam.sysuser.service.SysOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/20
 */
@Controller
@RequestMapping("/bam/sysProduct")
public class SysProductController {

    @Autowired
    private SysOriginService sysOriginService;

    @Autowired
    private SysAmountUnitService sysAmountUnitService;

    @RequestMapping("/sysProductList")
    public String sysProductList()
    {
        return "/bam/sysProductList";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model)
    {
        //查询所有产地
        model.addAttribute("sysOriginList", sysOriginService.listSysOrigin(null, null, ""));
        //查询所有单位
        model.addAttribute("sysAmountUnitList", sysAmountUnitService.listSysAmountUnit(null, null, ""));
        return "/bam/addProduct";
    }

}
