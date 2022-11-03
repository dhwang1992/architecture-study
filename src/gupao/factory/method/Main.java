package gupao.factory.method;

import gupao.factory.simple.IFactory;
import gupao.factory.simple.ITea;
import gupao.factory.simple.RedTea;

public class Main {
    public static void main(String[] args) {
        ITea tea = new RedTea("长安红茶", "red");
        IFactory factory = new RedTeaFactory();
        factory.getInstance(tea);
    }
}
