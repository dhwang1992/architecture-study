package gupao.singleton.lazy;

public class Singleton {
    /**
     * 加上volatile关键字的目的是？所有线程看到的是同一份变量，不发生指令重排
     * 指令重排，多线程情况下，会发生指令重排
     * 先了解下java创建对象有哪些指令，例如Singleton singleton = new Singleton();
     * 1.分配内存空间
     * 2.初始化对象（这里的初始化对象是指调用对象的构造函数，因为构造函数里面有时会做一些特殊的操作）
     * 3.将引用指向内存空间
     * 那么指令 123的顺序在指令重排后可能会变成1 3 2
     * 分配内存空间，将引用指向内存空间，此时singleton !=null ，会直接返回该对象，但是该对象没有完成初始化，是一个不完整的对象，所以需要加上volatile关键字
     * 问题？？ 在不加上volatile时，按照 123顺序执行，假如指令执行到2，此时判断singleton == null会成立，则不会返回该对象，也不会返回不完整的对象
     */
    public static volatile Singleton singleton;

    /**
     * V1 懒汉式单例，需要使用时才会创建单例对象
     * 问题？ static资源是类共享的，多线程下会存在线程安全问题
     * 解决方案？ 添加sycnchronized
     * @return
     */
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    /**
     * 使用synchronized关键字保证线程安全，但是对于性能会有影响，只需要对创建这一块加锁
     * @return
     */
//    public static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    /**
     * 无法保证线程安全 singleton = new Singleton();这一段是串行的，但其他地方都是并行的
     * singleton == null 并发执行，然后阻塞在singleton = new Singleton()
     * @return
     */
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                singleton = new Singleton();
//            }
//        }
//        return singleton;
//    }

    /**
     * dcl 双重检验
     * 优化的点在哪里呢？ 原本是针对方法加锁，访问方法时就会加锁，但现在只会针对singleton == null的线程才会加锁，优化了效率
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 使用静态内部类创建懒汉式单例，也可以解决线程安全问题
     * 为什么解决了线程安全问题呢？静态内部类，在内加载时就会创建对象
     * 静态内部类是延时加载的，会在使用singleton时需要创建该对象
     * 类加载的过程的过程是互斥的，所以不会存在线程安全问题
     * @return
     */
    public static Singleton getInstanceByInnerClass() {
        return InnerSingleton.singleton;
    }

    public static class InnerSingleton {
        public static Singleton singleton = new Singleton();
    }

}
