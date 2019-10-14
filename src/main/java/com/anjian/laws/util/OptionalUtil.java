package com.anjian.laws.util;

import java.util.Optional;

/**
 * @author ：努力吧小朱.
 * @version : Java1.8
 * @date ：Created in 10:56 2019/8/26
 * @ Description：${description}
 * @ Modified By：
 */
public class OptionalUtil<T> {
    public static <T> T isNull(T t,T defaultValue){
        Optional<T> t1 = Optional.ofNullable(t);
        return t1.orElse(defaultValue);
    }
}
