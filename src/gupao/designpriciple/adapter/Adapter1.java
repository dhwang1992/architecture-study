package gupao.designpriciple.adapter;

public abstract class Adapter1 implements Target {

    Adaptee adaptee;

    public Adapter1(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
