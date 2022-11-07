package gupao.designpriciple.proxy.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这种写法理论也只能代理IPerson这一类对象，如何对程序升级，代理更多的类呢
 */
public class JDKProxy {

    public static IPerson getInstance(IPerson iPerson) {
        // todo:: 为什么程序打了断点之后，打印的日志不对
        return (IPerson)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), iPerson.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("物色对象");
                method.invoke(iPerson, args);
                System.out.println("完成寻找");
                return proxy;
            }
        });
    }

    /**
     * 用此种方法实现，可以代理任何接口，但要求一定是接口
     * @param object
     * @return
     */
    public static Object getInstance1(Object object) {
        // todo:: 为什么程序打了断点之后，打印的日志不对
        return Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始代理");
                method.invoke(object, args);
                System.out.println("代理完成");
                return proxy;
            }
        });
    }

}
