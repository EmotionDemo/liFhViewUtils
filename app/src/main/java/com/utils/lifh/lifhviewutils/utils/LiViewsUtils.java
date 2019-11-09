package com.utils.lifh.lifhviewutils.utils;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.crypto.spec.IvParameterSpec;

/**
 * Created by zy on 2019/11/8.
 */

public class LiViewsUtils {
    public static void inject(Activity activity) {
        //绑定控件
        try {
            bindView(activity);
            bindCick(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }



    private static void bindView(Activity activity) throws IllegalAccessException {
        //获取Activity的字节码
        Class clazz = activity.getClass();
        //获取到字节码多有的Field
        Field[] declaredFields = clazz.getDeclaredFields();

        //遍历字段，判断哪些是我们想要的字段
        for (Field field : declaredFields) {
            //获得字段上的字节
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject != null) {
                //获取当前注解的值
                int resId = viewInject.value();
                //通过findViewbyid获取View id
                View view = activity.findViewById(resId);
                //将当前的view设置给当前的Field
                field.setAccessible(true);
                //给activity对象的field字段设置为view对象
                field.set(activity, view);
            } else {
            }
        }
    }

    private static void bindCick(final Activity activity) {
        //获得activity字节码文件
        Class clazz = activity.getClass();
        //获得字节码中所有声明的各种方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //高级for循环将其以此填充 并判断哪一些是我们需要的方法
        for (final Method method : declaredMethods) {
            //获取当前方法上的注解，拿到method的字节码文件
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick != null) {
                //获得注解上的值
                int resId = onClick.value();
                //将获取到的值传递给activity，拿到view
                View view = activity.findViewById(resId);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        method.setAccessible(true);
                        try {
                            //匿名内部类的一个对象访问当前对象的变量 需要加入final
                            //父类无法抛异常，子类也无法抛异常，方法继承父类，异常小于等于父类
                            method.invoke(activity, view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }




}
