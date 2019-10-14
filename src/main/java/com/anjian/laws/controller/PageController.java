package com.anjian.laws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 09:13 2019/9/5
 * @ Description：${description}
 * @ Modified By：
 */
@Controller
@RequestMapping("acceptPolice")
public class PageController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("home")
    public String getHome(){
        return "home";
    }
    @RequestMapping("two")
    public String two(){
        return "two";
    }
    @RequestMapping("three")
    public String three(){
        return "three";
    }
    @RequestMapping("four")
    public String four(){
        return "four";
    }
    @RequestMapping("txt")
    public String txt(){
        return "parserTxt";
    }
    @RequestMapping("photo")
    public String photo(){
        return "photoShow";
    }

}
