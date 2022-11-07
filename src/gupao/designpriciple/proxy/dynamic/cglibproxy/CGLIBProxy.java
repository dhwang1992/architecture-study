package gupao.designpriciple.proxy.dynamic.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 通过创建类的子类的方式来实现代理，可以代理任何可以被继承的类
 * jdk 创建创建接口的实现类实现代理，只能代理接口，基于反射，理论上速度会更快一些
 * spring aop是基于 jdk+cglib，有实现接口的使用jdk，无接口实现的使用cglib
 * mybatis全部都是基于jdk代理，因为mybatis本身就是接于接口的设计
 */
public class CGLIBProxy {

    public static Object getInstance(Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin cglib proxy");
                method.invoke(object);
                System.out.println("end cglib proxy");
                return proxy;
            }
        });
        return enhancer.create();
    }
}
