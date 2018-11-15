package com.syaaa.base.demo03;

/**
 * 静态内部类的方式创建单例模式
 *
 * @author syaaa
 * @version 1.0
 * @date 10:22   2018/11/15
 **/
public class InnerSingleton {

    private static class Singleton{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.singleton;
    }

}
