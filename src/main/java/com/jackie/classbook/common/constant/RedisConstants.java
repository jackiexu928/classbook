package com.jackie.classbook.common.constant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public class RedisConstants {
    //同学录用户前缀
    public static final String CLASSBOOK_USER_PREFIX="classbook_userid_";
    //redis用户超时时间，6小时
    public static final int USER_CACHE_TIME_OUT=6*3600;
    //数据填报用户口令前缀
    public static final String CLASSBOOK_USER_TOKEN="classbook_usertoken_";
}
