package com.anjian.laws.service;

import com.anjian.laws.dao.LawDao;
import com.anjian.laws.entity.LawItem;
import com.anjian.laws.util.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 08:02 2019/9/6
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class LawService {
    @Resource
    private LawDao lawDao;
    public ResultVO selectContentByKeyWord(String module,String keyword) {
        List<String> list = new ArrayList<>(3);
        if(lawDao.selectOneContentByKeyWord(module)!=null){
            list.addAll(lawDao.selectOneContentByKeyWord(module));
        }
        if(lawDao.selectTwoContentByKeyWord(module)!=null){
            list.addAll(lawDao.selectTwoContentByKeyWord(module));
        }
        if (lawDao.selectThreeContentByKeyWord(module)!=null){
            list.addAll(lawDao.selectThreeContentByKeyWord(module));
        }
        if (lawDao.selectFourContentByKeyWord(module)!=null){
            list.addAll(lawDao.selectFourContentByKeyWord(module));
        }
        list.removeIf(e -> !e.contains(keyword));
        if(list.size()>0){
            list = list.stream().distinct().collect(Collectors.toList());
            return ResultVO.success("ok",list);
        }else {
            return ResultVO.failMsg("error");
        }
    }

    public ResultVO findItemByModule(String module) {
        List<LawItem> itemByModule = lawDao.findItemByModule(module);
        if (itemByModule!=null){
            return ResultVO.success("ok",itemByModule);
        }else {
            return ResultVO.failMsg("error");
        }
    }

    public ResultVO findItemByTwoId(String item,Integer page) {
        List<LawItem> list = lawDao.findItemByTwoId(item,(page-1)*10,10);
        if (list!=null){
            return ResultVO.success("ok",list);
        }else {
            return ResultVO.failMsg("error");
        }
    }

    public ResultVO findItemByThreeId(String item) {
        List<LawItem> list = lawDao.findItemByThreeId(item);
        if (list!=null){
            return ResultVO.success("ok",list);
        }else {
            return ResultVO.failMsg("error");
        }
    }

    public ResultVO findItemByFourId(String item) {
        List<LawItem> list = lawDao.findItemByFourId(item);
        if (list!=null){
            return ResultVO.success("ok",list);
        }else {
            return ResultVO.failMsg("error");
        }
    }

    public ResultVO findTotalNum(String item) {
        Integer list = lawDao.findTotalNum(item)/10;
        return ResultVO.success("ok",list);
    }
}
