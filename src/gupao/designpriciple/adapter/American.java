package gupao.designpriciple.adapter;

public class American implements Adaptee{
    @Override
    public int change110v() {
        System.out.println("输出110V电压");
        return 110;
    }
}
