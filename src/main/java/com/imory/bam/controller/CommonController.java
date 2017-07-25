package com.imory.bam.controller;

import com.imory.bam.sysuser.bean.SysUser;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/11
 */
@Controller
@RequestMapping("/bam")
public class CommonController {

    private static Logger logger = Logger.getLogger(CommonController.class);

    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login()
    {
        return "/bam/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map)
    {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null)
        {
            if (UnknownAccountException.class.getName().equals(exception))
            {
                logger.info("UnknownAccountException -- > 账号不存在：");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception))
            {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception))
            {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "验证码错误";
            } else
            {
                msg = "else >> " + exception;
                logger.info("else >> " + exception);
            }
            map.put("msg", msg);
            // 此方法不处理登录成功,由shiro进行处理.
            return "/bam/login";
        }
        return "redirect:/common/index";
    }

    @RequestMapping(path = {"/common/index", "/"})
    public String index(Model model)
    {
        String sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.addAttribute("sysDate", sysDate);
        return "/bam/index";
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout()
    {
        Subject currentUser = SecurityUtils.getSubject();
        logger.info("用户:" + ((SysUser) currentUser.getPrincipal()).getLogonId() + "登出系统.");
        currentUser.logout();
        return "/bam/login";
    }

}
