package gupao.designpriciple.singleton.destory;

import gupao.designpriciple.singleton.hungry.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射来破坏单例 & 如何解决这种破坏
 */
public class DestroyWithReflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
        // 强吻操作
        declaredConstructor.setAccessible(true);
        Singleton singleton = declaredConstructor.newInstance();
        System.out.println("通过构造器获得的实例"+singleton);
        System.out.println("通过static方法调用获得的实例"+Singleton.getInstance());
    }
}
