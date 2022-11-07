package gupao.designpriciple.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式，类加载的时候就会去创建对象
 * 由于类加载过程是同步的，所以不存在线程安全问题
 */
public class Singleton implements Serializable {

    public static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
