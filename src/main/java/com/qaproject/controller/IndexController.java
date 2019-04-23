package com.qaproject.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(path = {"/","/index"},method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello";
    }

    @RequestMapping({"/profile/{useriId}"})
    @ResponseBody
    //可以用在首页的时候，一般默认的页数为1，并且required 也为false
    public String profile(@PathVariable("userId") int userId,
                          @RequestParam("type") int type,
                          @RequestParam(value = "key",defaultValue = "zz",required = false) String key){
        return "hello";
    }

    @RequestMapping({"/vm"})
    public String template(Model model){
         model.addAttribute("value", "vvvv1");
        return "hello";
    }


    @RequestMapping(path = {"/request"},method = RequestMethod.GET)
    @ResponseBody
    public String request(HttpServletResponse response,
                        HttpServletRequest request,
                        HttpSession session){

        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod());
        sb.append(request.getRequestURI());

        response.addHeader("username", "chen");
        response.addCookie(new Cookie("username", "chen"));
        return sb.toString();
    }

    //工业上的使用，可以对应手机和电脑上网 做不同的处理，还有就是对网页维护时，或者做活动 用临时的跳转
    @RequestMapping({"/redirect/{code}"})
    public RedirectView template(@PathVariable("code") int code,
                                 HttpSession session){
        session.setAttribute("msg","sssss");
        RedirectView red = new RedirectView("/",true);
        if(code == 301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        }
        return red;
    }
}
