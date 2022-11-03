package gupao.singleton.registry;


/**
 * 枚举类也可以定义成员变量和方法，可以把枚举同等理解为类
 * 枚举类的每一个枚举都是一个实例，且是单例的，只会被类加载器加载一次
 */
public class Singleton {

    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }


    enum SingletonEnum {
        INSTANCE;

        private Singleton singleton;

        SingletonEnum() {
            this.singleton = new Singleton();
        }

        public Singleton getInstance() {
            return INSTANCE.singleton;
        }
    }
}

