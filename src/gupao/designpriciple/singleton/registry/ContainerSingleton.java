package gupao.designpriciple.singleton.registry;

import java.util.HashMap;

/**
 * 注册型单例
 * 1.容器型单例
 * 2.枚举型单例
 */
public class ContainerSingleton {

    public static HashMap<String, ContainerSingleton> map = new HashMap<>();

    public static synchronized ContainerSingleton getInstance() {
        if (map.get("instance") == null) {
            map.put("instance", new ContainerSingleton());
        }
        return map.get("instance");
    }

    /**
     * 容器化单例用容器来替换类的创建，不会有指令重排的问题
     * @return
     */
    public static ContainerSingleton getInstance1() {
        if (map.get("instance") == null) {
            synchronized (ContainerSingleton.class) {
                if (map.get("instance") == null) {
                    map.put("instance", new ContainerSingleton());
                }
            }
        }
        return map.get("instance");
    }

}
