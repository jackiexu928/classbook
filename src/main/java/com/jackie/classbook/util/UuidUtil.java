package com.jackie.classbook.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public class UuidUtil {
    public static String getUuid(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

    public static String getUuidNoSplit(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }


    public static void main(String[] args){
        System.out.println(getUuid());
        System.out.println(getUuidNoSplit());
    }
}
