package com.utils.lifh.lifhviewutils.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zy on 2019/11/8.
 */

@Retention(RetentionPolicy.RUNTIME)//设置生命周期
@Target(ElementType.FIELD)//设置作用字段
public @interface ViewInject {
    int value();
}
