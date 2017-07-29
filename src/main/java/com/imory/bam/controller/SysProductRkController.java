package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysProductRk;
import com.imory.bam.sysuser.service.SysProductRkService;
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
 * @Date 2017/7/29
 */
@Controller
@RequestMapping("/bam/sysProductRk")
public class SysProductRkController {

    @Autowired
    private SysProductRkService sysProductRkService;

    @RequestMapping("/sysProductRkList")
    public String sysProductRkList()
    {
        return "/bam/sysProductRkList";
    }

    @RequestMapping("/addProductRk")
    public String addProductCk(Integer id, Model model)
    {
        if (id != null)
        {
            model.addAttribute("productRk", sysProductRkService.getById(id));
        } else
        {
            model.addAttribute("productRk", new SysProductRk());
        }
        return "/bam/addProductRk";
    }
}
