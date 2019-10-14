package com.anjian.laws.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 13:01 2019/9/6
 * @ Description：${description}
 * @ Modified By：
 */
@Data
public class LawItem implements Serializable {
    private static final long serialVersionUID = -5107915073653405274L;
    private String item;
    private String isLast;
}
