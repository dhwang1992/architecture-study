package gupao.designpriciple.proxy.dynamic.jdkproxy;

public class Main {

    public static void main(String[] args) {
        IPerson iPerson = JDKProxy.getInstance(new Jingzhang());
        iPerson.findGirlFriends();

        // Proxy出来的类只能强转为接口，不能转为具体的实现类，这也要求JDK动态代理必须代理接口
        IAnimal iAnimal = (IAnimal)JDKProxy.getInstance1(new Cat());
        iAnimal.eat();

        // 代理多个接口的实现类如何实现，使用注释处代码块会报错, 代理多个接口时，也必须多次调用，无法一次调用完成所有接口的代理
//        MeiRenYu meiRenYu = (MeiRenYu) JDKProxy.getInstance1(new MeiRenYu());
        IAnimal iAnimal1 = (IAnimal) JDKProxy.getInstance1(new MeiRenYu());
        IPerson iPerson1 = (IPerson) JDKProxy.getInstance1(new MeiRenYu());
        iAnimal1.eat();
        iPerson1.findGirlFriends();
    }
}
