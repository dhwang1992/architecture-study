package gupao.designpriciple.factory.method;

import gupao.designpriciple.factory.simple.IFactory;
import gupao.designpriciple.factory.simple.ITea;
import gupao.designpriciple.factory.simple.RedTea;

public class Main {
    public static void main(String[] args) {
        ITea tea = new RedTea("长安红茶", "red");
        IFactory factory = new RedTeaFactory();
        factory.getInstance(tea);
    }
}
