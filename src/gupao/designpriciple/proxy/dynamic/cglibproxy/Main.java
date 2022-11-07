package gupao.designpriciple.proxy.dynamic.cglibproxy;

public class Main {

    public static void main(String[] args) {

        Cat cat = (Cat)CGLIBProxy.getInstance(new Cat());
        cat.eat();

        AnyClass anyClass = (AnyClass) CGLIBProxy.getInstance(new AnyClass());
        anyClass.run();
        anyClass.photo();
    }
}
