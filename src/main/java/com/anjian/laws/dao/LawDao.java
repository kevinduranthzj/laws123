package com.anjian.laws.dao;

import com.anjian.laws.entity.LawItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 19:49 2019/9/5
 * @ Description：${description}
 * @ Modified By：
 */
@Mapper
public interface LawDao {
    /**
     * 根据关键字查询一级目录表内容
     * @param module 模糊查询索引
     * @return
     */
    List<String> selectOneContentByKeyWord(@Param("oneid") String module);
    /**
     * 根据关键字查询二级目录表内容
     * @param module 模糊查询索引
     * @return
     */
    List<String> selectTwoContentByKeyWord(@Param("oneid") String module);
    /**
     *  根据关键字查询三级目录表内容
     * @param module 模糊查询索引
     * @return 查询所得内容
     */
    List<String> selectThreeContentByKeyWord(@Param("threeid") String module);
    /**
     *  根据关键字查询四级目录表内容
     *  @param module 模糊查询索引
     * @return 查询所得内容
     */
    List<String> selectFourContentByKeyWord(@Param("fourid") String module);

    /**
     * 根据模块查询所有的
     * @param module 对应模块
     * @return
     */
    List<LawItem> findItemByModule(@Param("module") String module);

    /**
     * 根据第一层目录的目录名查询第二层目录的目录名
     * @param item 第一层目录的目录名
     * @return
     */
    List<LawItem> findItemByTwoId(@Param("item") String item,@Param("start") Integer start,@Param("pageNum") Integer pageNum);
    /**
     * 根据第一级目录名查找第二级目录的所有条数
     * @param item 第一层目录的目录名
     * @return
     */
    int findTotalNum(@Param("item") String item);
    /**
     * 根据第二层目录的目录名查询第三层目录的目录名
     * @param item 第二层目录的目录名
     * @return
     */
    List<LawItem> findItemByThreeId(String item);

    /**
     * 根据第三层目录的目录名查询第四层目录的目录名
     * @param item 第三层目录的目录名
     * @return
     */
    List<LawItem> findItemByFourId(String item);
}
