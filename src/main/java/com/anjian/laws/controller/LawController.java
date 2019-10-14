package com.anjian.laws.controller;

import com.anjian.laws.service.LawService;
import com.anjian.laws.util.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 08:14 2019/9/6
 * @ Description：${description}
 * @ Modified By：
 */
@RestController
@RequestMapping("law")
public class LawController {
    @Resource
    private LawService lawService;
    @RequestMapping("findItemByKey")
    public ResultVO selectContentByKeyWord(HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        String module = request.getParameter("module");
        return lawService.selectContentByKeyWord(module, keyword);
    }
    @RequestMapping("findItemByModule")
    public ResultVO findItemByModule(HttpServletRequest request){
        String module = request.getParameter("module");
        return lawService.findItemByModule(module);
    }
    @RequestMapping("findItemByTwoId")
    public ResultVO findItemByTwoId(HttpServletRequest request){
        String item = request.getParameter("item");
        String page = request.getParameter("page");
        return lawService.findItemByTwoId(item,Integer.valueOf(page));
    }
    @RequestMapping("findTotalNum")
    public ResultVO findTotalNum(HttpServletRequest request){
        String item = request.getParameter("item");
        return lawService.findTotalNum(item);
    }
    @RequestMapping("findItemByThreeId")
    public ResultVO findItemByThreeId(HttpServletRequest request){
        String item = request.getParameter("item");
        return lawService.findItemByThreeId(item);
    }
    @RequestMapping("findItemByFourId")
    public ResultVO findItemByFourId(HttpServletRequest request){
        String item = request.getParameter("item");
        return lawService.findItemByFourId(item);
    }
}
