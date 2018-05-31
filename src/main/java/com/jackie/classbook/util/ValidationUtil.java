package com.jackie.classbook.util;

import com.jackie.classbook.common.enumtype.ClassbookCodeEnum;
import com.jackie.classbook.exception.ClassbookException;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public class ValidationUtil {
    public static void validation(Object object){
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                if (f.get(object) == null) {
                    throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT, f.get(object).getClass().getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
