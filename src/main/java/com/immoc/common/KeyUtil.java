package com.immoc.common;

import java.util.Random;

/**
 * @author lilin
 * @Title: KeyUtil
 * @date 2018/10/21上午11:50
 */
public class KeyUtil {

    /**
     * 生成唯一主键：
     * 格式： 时间+随机数(六位随机数)
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
