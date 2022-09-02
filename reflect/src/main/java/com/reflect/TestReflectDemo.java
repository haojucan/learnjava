package com.reflect;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//反射获取某个类的全部属性
public class TestReflectDemo extends Test implements Serializable  {
    private static final long serialVersionUID = -2862585049955236662L;

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static void main(String[] args)  {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.reflect.TestReflectDemo");
            System.out.println("===============本类属性===============");
            // 取得本类的全部属性
            Field[] field = clazz.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                // 权限修饰符
                int mo = field[i].getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = field[i].getType();
                System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
            }

            System.out.println("==========实现的接口或者父类的属性==========");
            // 取得实现的接口或者父类的属性
            Field[] filed1 = clazz.getFields();
            for (int j = 0; j < filed1.length; j++) {
                // 权限修饰符
                int mo = filed1[j].getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = filed1[j].getType();
                System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
class Test{
    String name = "Axu";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
